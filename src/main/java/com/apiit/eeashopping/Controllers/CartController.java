package com.apiit.eeashopping.Controllers;

import com.apiit.eeashopping.DB.CartRepository;
import com.apiit.eeashopping.Model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    CartRepository cartRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Cart> getAllCartItems(){
        System.out.println("Fetching all cart items");
        return cartRepository.findAll();
    }

    @PostMapping(path = "/add")
    public Cart addNewItemToCart(@RequestBody Cart cart){

        cartRepository.save(cart);
        System.out.println(cart.getCid() + " item added");

        return cart;
    }

    @PutMapping
    public Cart updateCartItem(@RequestBody Cart cart){

        cartRepository.save(cart);
        System.out.println(cart.getCid() +" is updated");

        return cart;
    }

    @DeleteMapping("/{cid}")
    public boolean deleteCartItem(@PathVariable String cid){

        Cart c = cartRepository.findById(cid).get();
        cartRepository.deleteById(cid);
        System.out.println(c.getCid() + " is deleted");

        return true;
    }
}
