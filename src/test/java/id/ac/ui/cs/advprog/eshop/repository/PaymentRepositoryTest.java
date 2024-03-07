package id.ac.ui.cs.advprog.eshop.repository;

//import payment status from enums
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentRepositoryTest {
    PaymentRepository paymentRepository;
    List<Payment> payments;

    @BeforeEach
    void setUp(){
        paymentRepository = new PaymentRepository();
        payments = new ArrayList<>();
        Map<String, String> paymentData1 = new HashMap<>();
        paymentData1.put("VoucherCode", "ESHOP1234ABC5678");
        Payment payment1 = new Payment("101", "VOUCHER",paymentData1);
        payments.add(payment1);

        Map<String, String> paymentData2 = new HashMap<>();
        paymentData2.put("deliveryFee", "20");
        paymentData2.put("address", "Jl. Sudirman");
        Payment payment2 = new Payment("202", "COD", paymentData2);
        payments.add(payment2);
    }

    @Test
    void testFindByIdIfIdFound() {
        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        Payment findResult = paymentRepository.findById(payments.get(1).getId());
        assertEquals(payments.get(1).getId(), findResult.getId());
        assertEquals(payments.get(1).getMethod(), findResult.getMethod());
        assertEquals(payments.get(1).getPaymentData(), findResult.getPaymentData());
        assertEquals(payments.get(1).getStatus(), findResult.getStatus());
    }

    @Test
    void testFindByIdIfIdNotFound() {
        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        Payment findResult = paymentRepository.findById("zczc");
        assertNull(findResult);
    }

    @Test
    void testFindAll() {
        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        List <Payment> payments1 = paymentRepository.findAll();
        assertEquals(2, payments1.size());
    }

    @Test
    void testFindAllEmpty() {
        List <Payment> payments1 = paymentRepository.findAll();
        assertTrue(payments1.isEmpty());
    }
}
