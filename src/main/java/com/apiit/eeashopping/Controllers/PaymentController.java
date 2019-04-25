package com.apiit.eeashopping.Controllers;

import com.apiit.eeashopping.DB.PaymentRepository;
import com.apiit.eeashopping.Model.Payment;
import com.apiit.eeashopping.Model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/user/payments")
public class PaymentController {
    @Autowired
    PaymentRepository PaymentRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Payment> getAllPromotions(){
        System.out.println("Fetching all promotions items");
        return PaymentRepository.findAll();
    }

    @PostMapping(path = "/add")
    public Payment addNewPayment(@RequestBody Payment payment){

        PaymentRepository.save(payment);
        System.out.println(payment.getTransactionName() + " promotion is added");

        return payment;
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping(path = "/admin")
    public Payment updatePayment(@RequestBody Payment payment){

        PaymentRepository.save(payment);
        System.out.println(payment.getTransactionName() +" is updated");

        return payment;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/admin/{payId}")
    public boolean deletePayment(@PathVariable String payId){

        Optional<Payment> p = PaymentRepository.findById(payId);
        if(p.isPresent())
        PaymentRepository.deleteById(payId);
        System.out.println(p.get().getTransactionName() + " is deleted");

        return p.isPresent();
    }
}
