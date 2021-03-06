package com.apiit.eeashopping.Controllers;

import com.apiit.eeashopping.DB.CategoryRepository;
import com.apiit.eeashopping.Model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping(path = "/public/all")
    public @ResponseBody Iterable<Category> getAllCategories(){
        System.out.println("Fetching all categories");
        return categoryRepository.findAll();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(path = "/auth/add")
    public Category addNewCategory(@RequestBody String categoryName){
        Category category = new Category();
        category.setName(categoryName);
        categoryRepository.save(category);
        System.out.println(category.getName() + " category is added");

        return category;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping(path = "/auth")
    public Category updateCategory(@RequestBody Category category){

        categoryRepository.save(category);
        System.out.println(category.getName() + " is updated");

        return category;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/auth/{catId}")
    public boolean deleteCategory(@PathVariable int catId){

        Optional<Category> c = categoryRepository.findById(catId);
        if(c.isPresent())
        categoryRepository.deleteById(catId);
        System.out.println(c.get().getName() + " is deleted");

        return c.isPresent();
    }
}
