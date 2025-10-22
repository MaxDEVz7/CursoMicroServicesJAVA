package com.max.hrPayroll.hrpayroll.resources;


import com.max.hrPayroll.hrpayroll.entities.Payments;
import com.max.hrPayroll.hrpayroll.services.PaymentServices;
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

    @GetMapping(value = "/{idWorker}/days/{days}")
    public ResponseEntity<Payments> findById(@PathVariable Long idWorker, @PathVariable int days){
        Payments payment = paymentServices.getPayment(idWorker, days);
        return ResponseEntity.ok().body(payment);
    }
}
