package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {
    @Test
    void testCreateVoucherPaymentDefault() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("VoucherCode", "SAMPLEVOUCHER123");
        Payment payment = new Payment("1001", "VOUCHER", paymentData);

        assertTrue(payment.getPaymentData().containsKey("VoucherCode"));
        assertEquals("1001", payment.getId());
        assertEquals("VOUCHER", payment.getMethod());
        assertEquals("CHECKING_PAYMENT", payment.getStatus());
    }

    @Test
    void testCreateCODPaymentDefault() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("deliveryFee", "15");
        paymentData.put("address", "123 Main St");
        Payment payment = new Payment("2002", "CASH", paymentData);

        assertTrue(payment.getPaymentData().containsKey("deliveryFee"));
        assertTrue(payment.getPaymentData().containsKey("address"));
        assertEquals("CHECKING_PAYMENT", payment.getStatus());
        assertEquals("2002", payment.getId());
        assertEquals("CASH", payment.getMethod());
    }

    @Test
    void testCreatePaymentSuccessStatus() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("VoucherCode", "SAMPLEVOUCHER123");
        Payment payment = new Payment("1001", "VOUCHER", paymentData);
        payment.setStatus("SUCCESS");
        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testCreatePaymentInvalidStatus() {
        assertThrows(IllegalArgumentException.class, () -> {
            Map<String, String> paymentData = new HashMap<>();
            paymentData.put("VoucherCode", "SAMPLEVOUCHER123");
            Payment payment = new Payment("1001", "VOUCHER", paymentData);
        });
    }

    @Test
    void testCreatePaymentCashSuccess() {
        Map<String, String> subFeature = new HashMap<>();
        subFeature.put("address", "456 Elm St");
        subFeature.put("deliveryFee", "1000");

        Payment payment = new Payment("3003", "cash", subFeature);

        assertNotNull(payment.getPaymentData().get("address"));
        assertNotNull(payment.getPaymentData().get("deliveryFee"));
        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testCreatePaymentCashReject_AllSubFieldsNull() {
        Map<String, String> subFeature = new HashMap<>();

        Payment payment = new Payment("3003", "cash", subFeature);

        assertNull(payment.getPaymentData().get("address"));
        assertNull(payment.getPaymentData().get("deliveryFee"));
        assertEquals("REJECT", payment.getStatus());
    }

    @Test
    void testCreatePaymentCashReject_AllEmptySubFields() {
        Map<String, String> subFeature = new HashMap<>();
        subFeature.put("address", "");
        subFeature.put("deliveryFee", "");

        Payment payment = new Payment("3003", "cash", subFeature);

        assertTrue(payment.getPaymentData().get("address").isEmpty());
        assertTrue(payment.getPaymentData().get("deliveryFee").isEmpty());
        assertEquals("REJECT", payment.getStatus());
    }
}
