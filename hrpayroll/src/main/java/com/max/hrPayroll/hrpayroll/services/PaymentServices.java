package com.max.hrPayroll.hrpayroll.services;

import com.max.hrPayroll.hrpayroll.entities.Payments;
import com.max.hrPayroll.hrpayroll.entities.Worker;
import com.max.hrPayroll.hrpayroll.feignClient.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentServices {

    @Autowired
    WorkerFeignClient workerFeignClient;

    public Payments getPayment(Long workerId, int days) {

        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payments(worker.getName(), worker.getDailyIncome(), days);
    }
}
