package com.max.hrPayroll.hrpayroll.services;

import com.max.hrPayroll.hrpayroll.entities.Payments;
import com.max.hrPayroll.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentServices {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payments getPayment(Long workerId, int days) {
        Map<String, String> uriVariables =new HashMap<>();
        uriVariables.put("id", ""+workerId);

        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
        return new Payments(worker.getName(), worker.getDailyIncome(), days);
    }
}
