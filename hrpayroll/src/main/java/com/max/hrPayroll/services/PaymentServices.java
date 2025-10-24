package com.max.hrPayroll.services;

import com.max.hrPayroll.entities.Payments;
import com.max.hrPayroll.entities.Worker;
import com.max.hrPayroll.feignClient.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServices {

    @Autowired
    WorkerFeignClient workerFeignClient;

    public Payments getPayment(Long workerId, int days) {

        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payments(worker.getName(), worker.getDailyIncome(), days);
    }
}
