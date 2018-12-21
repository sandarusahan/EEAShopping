package com.apiit.eeashopping.Controllers;

import com.apiit.eeashopping.DB.ProductRepository;
import com.apiit.eeashopping.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping(path = "/add")
    public Product addNewProduct(@RequestBody Product product){

        productRepository.save(product);
        System.out.println(product.pName + " is added");

        return product;
    }


    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Product> getAllProducts(){
        System.out.println("Fetching all products");
        return productRepository.findAll();
    }

    @GetMapping(path = "/{pid}")
    public Product getProduct(@PathVariable String pid){
        System.out.println("Fetching all products");
        return productRepository.findById(pid).get();
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product){

        productRepository.save(product);
        System.out.println(product.pName + " is updated");

        return product;
    }

    @DeleteMapping("/{pid}")
    public String deleteProduct(@PathVariable String pid){

        Product p = productRepository.findById(pid).get();
        productRepository.deleteById(pid);
        System.out.println(p.pName + " is deleted");

        return "Deleted";
    }
}
