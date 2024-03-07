package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.OrderRepository;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Service
@Component
public class PaymentServiceImpl implements PaymentService {


    private PaymentRepository paymentRepository;

    private OrderRepository orderRepository;

    @Override
    public Payment addPayment(Order order, String method, Map<String, String> paymentData) {
        // Implement logic to create and save a new payment based on the provided order
        // and return the created payment
        return null;
    }

    @Override
    public Payment setStatus(Payment payment, String status) {
        // Implement logic to set the status of the provided payment
        // and update the related order status if necessary
        return null;
    }

    @Override
    public Payment getPayment(String paymentId) {
        // Implement logic to retrieve a payment by its ID
        return null;
    }

    @Override
    public List<Payment> getAllPayments() {
        // Implement logic to retrieve all payments
        return null;
    }
}
