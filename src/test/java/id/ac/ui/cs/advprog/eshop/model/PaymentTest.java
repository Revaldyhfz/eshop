import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

public class PaymentTest {

    @Test
    void testVoucherPaymentCreation() {
        // Test valid voucher payment creation
        Map<String, String> voucherData = new HashMap<>();
        voucherData.put("VoucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment("1", "VOUCHER", voucherData);

        assertEquals("1", payment.getId());
        assertEquals("VOUCHER", payment.getOrderId());
        assertTrue(payment.getPaymentData().containsKey("VoucherCode"));
        assertEquals("CHECKING_PAYMENT", payment.getStatus());
    }

    @Test
    void testCashPaymentCreation() {
        // Test valid cash payment creation
        Map<String, String> cashData = new HashMap<>();
        cashData.put("address", "Cipete");
        cashData.put("deliveryFee", "10000");
        Payment payment = new Payment("2", "CASH", cashData);

        assertEquals("2", payment.getId());
        assertEquals("CASH", payment.getMethod());
        assertTrue(payment.getPaymentData().containsKey("address"));
        assertTrue(payment.getPaymentData().containsKey("deliveryFee"));
        assertEquals("CHECKING_PAYMENT", payment.getStatus());
    }

    // Add more specific payment method tests if needed

    @Test
    void testInvalidPaymentCreation() {
        // Test invalid payment creation
        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("1", "INVALID_METHOD", new HashMap<>());
        });
    }

    @Test
    void testStatusUpdate() {
        // Test status update
        Payment payment = new Payment("1", "VOUCHER", new HashMap<>());
        payment.setStatus("SUCCESS");
        assertEquals("SUCCESS", payment.getStatus());

        assertThrows(IllegalArgumentException.class, () -> {
            payment.setStatus("INVALID_STATUS");
        });
    }

    // Create more tests if voucher is invalid
    @Test
    void testVoucherPaymentCreationInvalid() {
        // Test invalid voucher payment creation
        Map<String, String> voucherData = new HashMap<>();
        voucherData.put("VoucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment("1", "VOUCHER", voucherData);

        assertEquals("1", payment.getId());
        assertEquals("VOUCHER", payment.getOrderId());
        assertTrue(payment.getPaymentData().containsKey("VoucherCode"));
        assertEquals("CHECKING_PAYMENT", payment.getStatus());
    }
    //create more tests if cash is invalid
    @Test
    void testCashPaymentCreationInvalid() {
        // Test invalid cash payment creation
        Map<String, String> cashData = new HashMap<>();
        cashData.put("address", "Cipete");
        cashData.put("deliveryFee", "10000");
        Payment payment = new Payment("2", "CASH", cashData);

        assertEquals("2", payment.getId());
        assertEquals("CASH", payment.getMethod());
        assertTrue(payment.getPaymentData().containsKey("address"));
        assertTrue(payment.getPaymentData().containsKey("deliveryFee"));
        assertEquals("CHECKING_PAYMENT", payment.getStatus());
    }

}