package com.apiit.eeashopping.DB;

import com.apiit.eeashopping.Model.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, String> {

}
