package com.umut.soap.endpoint;

import com.example.soap.gen.PaymentRequest;
import com.example.soap.gen.PaymentResponse;
import com.umut.soap.service.PaymentService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PaymentEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/payment";

    private final PaymentService paymentService;

    public PaymentEndpoint(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "paymentRequest")
    @ResponsePayload
    public PaymentResponse handlePaymentRequest(@RequestPayload PaymentRequest request) {
        return paymentService.processPayment(request);
    }
}
