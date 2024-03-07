package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Payment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PaymentRepository {
    private Map<String, Payment> paymentMap = new HashMap<>();

    public Payment save(Payment payment) {
        if (paymentMap.containsKey(payment.getId())) {
            paymentMap.put(payment.getId(), payment);
        } else {
            Payment newPayment = new Payment(payment.getId(), payment.getMethod(), payment.getStatus(), new HashMap<>(payment.getPaymentData()));
            paymentMap.put(payment.getId(), newPayment);
        }
        return payment;
    }

    public Payment findById(String id) {
        return paymentMap.get(id);
    }

    public List<Payment> findAll() {
        return new ArrayList<>(paymentMap.values());
    }
}
