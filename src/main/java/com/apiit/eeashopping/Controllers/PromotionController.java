package com.apiit.eeashopping.Controllers;

import com.apiit.eeashopping.DB.PromotionRepository;
import com.apiit.eeashopping.Model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/promotion")
public class PromotionController {
    @Autowired
    PromotionRepository promoRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Promotion> getAllPromotions(){
        System.out.println("Fetching all promotions items");
        return promoRepository.findAll();
    }

    @PostMapping(path = "/add")
    public Promotion addNewPromotion(@RequestBody Promotion promotion){

        promoRepository.save(promotion);
        System.out.println(promotion.getPromoname() + " promotion is added");

        return promotion;
    }

    @PutMapping
    public Promotion updateCategory(@RequestBody Promotion promotion){

        promoRepository.save(promotion);
        System.out.println(promotion.getPromoname() +" is updated");

        return promotion;
    }

    @DeleteMapping("/{cid}")
    public boolean deleteCategory(@PathVariable String cid){

        Promotion p = promoRepository.findById(cid).get();
        promoRepository.deleteById(cid);
        System.out.println(p.getPromoname() + " is deleted");

        return true;
    }
}
