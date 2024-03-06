package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

//Create skeleton model class for payment to avoid compile errors
public class Payment {
    @Getter @Setter
    private String id;
    @Getter @Setter
    private String method;
    @Getter @Setter
    private Map<String, String> paymentData;
    @Getter @Setter
    private String status;

    public Payment(String id, String method, Map<String, String> paymentData) {
        this.id = id;
        this.method = method;
        this.paymentData = paymentData;
        this.status = "CHECKING_PAYMENT";
    }


}
