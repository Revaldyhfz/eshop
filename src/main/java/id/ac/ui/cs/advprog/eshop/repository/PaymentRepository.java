package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentRepository {
    private List<Payment> paymentList = new ArrayList<>();

    public Payment save(Payment payment) {
        Payment existingPayment = findById(payment.getId());
        if (existingPayment == null) {
            paymentList.add(payment);
            return payment;
        } else {
            int index = paymentList.indexOf(existingPayment);
            paymentList.set(index, payment);
            return payment;
        }
    }

    public Payment findById(String id) {
        for (Payment payment : paymentList) {
            if (payment.getId().equals(id)) {
                return payment;
            }
        }
        return null;
    }

    public List<Payment> findAll() {
        return new ArrayList<>(paymentList);
    }
}
