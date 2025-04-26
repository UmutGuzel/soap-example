package com.umut.soap.service;

import com.example.soap.gen.PaymentRequest;
import com.example.soap.gen.PaymentResponse;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.UUID;

@Service
public class PaymentService {

    public PaymentResponse processPayment(PaymentRequest request) {
        PaymentResponse response = new PaymentResponse();


        if (request.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            response.setResultCode("FAILED");
            response.setMessage("Invalid amount.");
            return response;
        }

        // Simulate a successful payment
        String authorizationId = UUID.randomUUID().toString();
        response.setResultCode("SUCCESS");
        response.setMessage("Payment successful.");
        response.setAuthorizationId(authorizationId);

        return response;
    }
}
