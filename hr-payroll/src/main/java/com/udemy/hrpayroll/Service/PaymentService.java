package com.udemy.hrpayroll.Service;

import com.udemy.hrpayroll.entity.Payment;
import com.udemy.hrpayroll.entity.Worker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    private RestTemplate restTemplate;

    public PaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment getPayment(Long id, Integer day){
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", ""+id);
        Worker worker = restTemplate.getForObject(workerHost +"/{id}", Worker.class, uriVariables);
        return  new Payment(worker.getName(), worker.getDailyIncome(), day);
    }
}
