package com.apiit.eeashopping.Controllers;

import com.apiit.eeashopping.DB.ProductRepository;
import com.apiit.eeashopping.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(path = "/admin/add")
    public Product addNewProduct(@RequestBody Product product){

        productRepository.save(product);
        System.out.println(product.getpName() + " is added");

        return product;
    }

    @GetMapping(path = "/public/all")
    public @ResponseBody Iterable<Product> getAllProducts(){
        System.out.println("Fetching all products");
        return productRepository.findAll();
    }

    @GetMapping(path = "/{pid}")
    public Product getProduct(@PathVariable String pid){
        System.out.println("Fetching product "+pid);
        return productRepository.findById(pid).get();
    }

    @GetMapping(path = "/public/category/{category_id}")
    public Iterable getProductsFromCategory(@PathVariable String category_id){
        System.out.println("Fetching products from category "+category_id);
        return productRepository.findAllByCategoryId(category_id);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping(path = "/admin")
    public boolean updateProduct(@RequestBody Product product){

        Optional<Product> prod = productRepository.findById(product.getpId());
        if (prod.isPresent()) {
            productRepository.save(product);
            System.out.println(product.getpName() + " is updated");
            return true;

        }{
            System.out.println(product.getpName() + " is not updated");
            return false;
        }




    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/admin/{pid}")
    public Boolean deleteProduct(@PathVariable String pid){

        boolean flag = false;
        Product p = productRepository.findById(pid).get();
        if(p.getpId() == null) {
            productRepository.deleteById(pid);
            System.out.println(p.getpName() + " is deleted");
            flag = true;

        }else {
            flag = false;
        }
        return flag;
    }
}
