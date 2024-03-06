package id.ac.ui.cs.advprog.eshop.model;

import java.util.HashMap;
import java.util.Map;

public class Payment {
    private String id;
    private String method;
    private String status;
    private Map<String, String> paymentData;

    // Constructor with id, method, and paymentData
    public Payment(String id, String method, Map<String, String> paymentData) {
        this.id = id;
        this.method = method;
        this.paymentData = paymentData;
        this.status = "CHECK_PAYMENT"; // Default status
    }

    // Constructor with id, method, status, and paymentData
    public Payment(String id, String method, String status, Map<String, String> paymentData) {
        this.id = id;
        this.method = method;
        this.status = status;
        this.paymentData = paymentData;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (!status.equals("CHECK_PAYMENT") && !status.equals("SUCCESS") && !status.equals("REJECTED")) {
            throw new IllegalArgumentException("Invalid status");
        }
        this.status = status;
    }

    public Map<String, String> getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(Map<String, String> paymentData) {
        this.paymentData = paymentData;
    }

    // Additional methods for adding/removing payment data
    public void addPaymentData(String key, String value) {
        if (paymentData == null) {
            paymentData = new HashMap<>();
        }
        paymentData.put(key, value);
    }

    public void removePaymentData(String key) {
        if (paymentData != null) {
            paymentData.remove(key);
        }
    }
}