package com.apiit.eeashopping.Controllers;

import com.apiit.eeashopping.DB.CategoryRepository;
import com.apiit.eeashopping.Model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/add")
    public Category addNewCategory(@RequestBody Category category){

        categoryRepository.save(category);
        System.out.println(category.getName() + "category is added");

        return category;
    }

    @PutMapping
    public Category updateCategory(@RequestBody Category category){

        categoryRepository.save(category);
        System.out.println(category.getName() + " is updated");

        return category;
    }

    @DeleteMapping("/{catid}")
    public boolean deleteCategory(@PathVariable int catId){

        Category c = categoryRepository.findById(catId).get();
        categoryRepository.deleteById(catId);
        System.out.println(c.getName() + " is deleted");

        return true;
    }
}
