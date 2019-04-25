package com.apiit.eeashopping.Controllers;

import com.apiit.eeashopping.DB.PromotionRepository;
import com.apiit.eeashopping.Model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/promotion")
public class PromotionController {
    @Autowired
    PromotionRepository promoRepository;

    @GetMapping(path = "/public/all")
    public @ResponseBody Iterable<Promotion> getAllPromotions(){
        System.out.println("Fetching all promotions items");
        return promoRepository.findAll();
    }

    @GetMapping(path = "/public/{promoid}")
    public Promotion getPromotion(String promoid) {
        return promoRepository.findById(promoid).get();
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(path = "/admin/add")
    public Promotion addNewPromotion(@RequestBody Promotion promotion){

        Promotion promo = promoRepository.save(promotion);
        System.out.println(promotion.getPromoname() + " promotion is added");

        return promo;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping(path = "/admin")
    public Promotion updatePromotion(@RequestBody Promotion promotion){


        System.out.println(promotion.getPromoname() +" is updating");

        return promoRepository.save(promotion);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/admin/{pid}")
    public boolean deleteCategory(@PathVariable String pid){

        Optional p = promoRepository.findById(pid);
        if(p.isPresent()){
            promoRepository.deleteById(pid);
            System.out.println(p.get() + " is deleted");
            return true;
        }
        else {
            return false;
        }



    }
}
