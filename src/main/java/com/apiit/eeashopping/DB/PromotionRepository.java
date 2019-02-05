package com.apiit.eeashopping.DB;

import com.apiit.eeashopping.Model.Promotion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends CrudRepository<Promotion, String> {
}
