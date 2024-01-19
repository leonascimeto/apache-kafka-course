package tech.leondev.paymentservice.resource.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.leondev.paymentservice.model.Payment;
import tech.leondev.paymentservice.resource.PaymentResource;
import tech.leondev.paymentservice.service.PaymentService;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/payments")
public class PaymentResourceImpl implements PaymentResource {

    private final PaymentService paymentService;

    @Override
    public ResponseEntity<Payment> payment(@RequestBody Payment payment) {
        paymentService.sendPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
