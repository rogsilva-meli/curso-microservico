package com.udemy.hrpayroll.Service;

import com.udemy.hrpayroll.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long id, Integer day){
        return new Payment("Rogério", 200.0, 2);
    }
}
