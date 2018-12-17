package com.apiit.eeashopping.Controllers;

import com.apiit.eeashopping.DB.CategoryRepository;
import com.apiit.eeashopping.Model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Category> getAllCategories(){
        System.out.println("Fetching all categories");
        return categoryRepository.findAll();
    }
}
