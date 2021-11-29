package com.udemy.hrpayroll.service;

import com.udemy.hrpayroll.entity.Payment;
import com.udemy.hrpayroll.entity.Worker;
import com.udemy.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long id, Integer days){
        Worker worker = workerFeignClient.getWorker(id).getBody();
        return  new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
