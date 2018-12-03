package com.apiit.eeashopping.API;

import com.apiit.eeashopping.DB.ProductRepository;
import com.apiit.eeashopping.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
public class Controller {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/add")
    public @ResponseBody Product addNewProduct(@RequestParam String name, @RequestParam String category, @RequestParam String desc, @RequestParam double price, @RequestParam int qty){
        Product product = new Product();

        product.setpName(name);
        product.setpCategory(category);
        product.setpPrice(price);
        product.setpDescription(desc);
        product.setpQty(qty);

        productRepository.save(product);
        System.out.println(name + " is added");

        return product;
    }

    @GetMapping(path = "/getAll")
    public @ResponseBody Iterable<Product> getAllProducts(){
        System.out.println("Fetching all products");
        return productRepository.findAll();
    }
}
