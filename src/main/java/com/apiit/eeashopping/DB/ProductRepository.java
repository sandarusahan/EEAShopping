package com.apiit.eeashopping.DB;

import com.apiit.eeashopping.Model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

//    Iterable<Product> findAllByPromotionId
    Iterable<Product> findAllByCategoryId(String categoryId);
}
