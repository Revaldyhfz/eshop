
package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.OrderRepository;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Payment addPayment(Order order, String method, Map<String, String> paymentData) {
        if (method.equals(PaymentMethod.CASH_ON_DELIVERY.getValue())) {
            // For Cash On Delivery, validate and set address and delivery fee
            if (!paymentData.containsKey("address") || paymentData.get("address").isEmpty() ||
                    !paymentData.containsKey("deliveryFee") || paymentData.get("deliveryFee").isEmpty()) {
                throw new IllegalArgumentException("Address and delivery fee are required for Cash On Delivery");
            }
            // Automatically set status to REJECTED if address or delivery fee is missing
            paymentData.putIfAbsent("status", PaymentStatus.REJECTED.getValue());
        }

        Payment payment = new Payment(order.getId(), method, paymentData);
        paymentRepository.save(payment);
        return payment;
    }

    @Override
    public Payment setStatus(Payment payment, String status) {
        payment.setStatus(status);
        updateOrderStatus(payment, status);
        return paymentRepository.save(payment);
    }

    private void updateOrderStatus(Payment payment, String status) {
        Order order = orderRepository.findById(payment.getId());
        if (order != null) {
            if (PaymentStatus.SUCCESS.getValue().equals(status)) {
                order.setStatus(OrderStatus.SUCCESS.getValue());
            } else if (PaymentStatus.REJECTED.getValue().equals(status)) {
                order.setStatus(OrderStatus.FAILED.getValue());
            }
            orderRepository.save(order);
        }
    }

    @Override
    public Payment getPayment(String paymentId) {
        return paymentRepository.findById(paymentId);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
