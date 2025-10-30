package com.max.hrPayroll.resources;


import com.max.hrPayroll.entities.Payments;
import com.max.hrPayroll.services.PaymentServices;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentsResources {
    @Autowired
    private PaymentServices paymentServices;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{idWorker}/days/{days}")
    public ResponseEntity<Payments> findById(@PathVariable Long idWorker, @PathVariable int days){
        Payments payment = paymentServices.getPayment(idWorker, days);
        return ResponseEntity.ok().body(payment);
    }

    public ResponseEntity<Payments> getPaymentAlternative(Long idWorker, int days){
        Payments payment = new Payments("Alternativo", 400.0 , days);
        return ResponseEntity.ok().body(payment);
    }
}
