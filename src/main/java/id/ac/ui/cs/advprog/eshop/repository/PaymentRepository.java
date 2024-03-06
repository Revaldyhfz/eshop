package id.ac.ui.cs.advprog.eshop.repository;

//from the payment repository tests (PaymentRepositoryTest.java), Implement only the skeleton model (Return null) for initial [RED] testing
//implement interface first

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;

import java.util.Map;

public class PaymentRepository {
    public static Payment addPayment(Order order, String method, Map<String, String> paymentData) {
        return null;
    }

    public static Payment setStatus(Payment payment, String status) {
        return null;
    }

    public static Payment getPayment(String paymentId) {
        return null;
    }

    public static Payment getAllPayments() {
        return null;
    }
}