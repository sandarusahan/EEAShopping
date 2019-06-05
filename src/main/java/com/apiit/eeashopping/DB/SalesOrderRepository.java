package com.apiit.eeashopping.DB;

import com.apiit.eeashopping.Model.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrder, Integer> {
    Iterable<SalesOrder> findAllByUserId(int userId);
}
