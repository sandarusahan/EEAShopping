package com.apiit.eeashopping.Controllers;

import com.apiit.eeashopping.DB.SalesOrderRepository;
import com.apiit.eeashopping.Model.SalesOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salesOrder")
public class SalesOrderController {
    @Autowired
    SalesOrderRepository salesOrderRepository;

    @GetMapping(path = "/{id}")
    public Optional<SalesOrder> findProduct(@PathVariable int id){
        return salesOrderRepository.findById(id);
    }

    @GetMapping
    public List<SalesOrder> findAllOrders(){
        return salesOrderRepository.findAll();
    }

    @GetMapping(path = "/user/{userId}")
    public Iterable<SalesOrder> findOrdersByUserId(@PathVariable String userId){
        return salesOrderRepository.findAllByUserId(userId);
    }

    @PostMapping(path = "/add")
    public SalesOrder saveSalesOrder(@RequestBody SalesOrder orderProduct){
        System.out.println("method triggered");
        return salesOrderRepository.save(orderProduct);
    }

    @PutMapping
    public SalesOrder updateProduct(@RequestBody SalesOrder orderProduct)
    {
        return salesOrderRepository.save(orderProduct);
    }

    @DeleteMapping(path="/user/{id}")
    public void deleteProductByUser (@PathVariable String id){
        salesOrderRepository.deleteAllByUserId(id);
    }

    @DeleteMapping(path="/{id}")
    public boolean deleteProduct(@PathVariable int id){
        if(salesOrderRepository.existsById(id)){
            salesOrderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
