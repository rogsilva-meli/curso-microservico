package com.udemy.hrpayroll.controller;

import com.udemy.hrpayroll.service.PaymentService;
import com.udemy.hrpayroll.entity.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/{worker_id}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long worker_id, @PathVariable Integer days){
        Payment payment = paymentService.getPayment(worker_id, days);
        return ResponseEntity.status(HttpStatus.OK).body(payment);
    }
}
