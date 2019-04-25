package com.apiit.eeashopping.Controllers;

import com.apiit.eeashopping.DB.CartRepository;
import com.apiit.eeashopping.Model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user/cart")
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
    public Cart addNewItemToCart(@RequestBody Cart newCartItem){
        Cart cart = null;
        for(Cart cartItem : getAllCartItems()){
            if(cartItem.getpid().equals(newCartItem.getpid()) && cartItem.getUid().equals(newCartItem.getUid())){
                cart = cartItem;
            }
        }

        if(cart == null){
            cart = newCartItem;
        }else {
            int qty = cart.getAmount() + newCartItem.getAmount();
            cart.setAmount(qty);
        }
        cartRepository.save(cart);
        System.out.println(cart.getCid() + " item added");

        return cart;
    }

    @PostMapping(path = "add/items")
    public Iterable<Cart> AddItemsToCart(@RequestBody Iterable<Cart> items){
        return cartRepository.saveAll(items);
    }

    @PutMapping
    public Cart updateCartItem(@RequestBody Cart cart){

        cartRepository.save(cart);
        System.out.println(cart.getCid() +" is updated");

        return cart;
    }

    @DeleteMapping("/{cid}")
    public Iterable<Cart> deleteCartItem(@PathVariable String cid){

        Cart c = cartRepository.findById(cid).get();
        cartRepository.deleteById(cid);
        System.out.println(c.getCid() + " is deleted");

        return cartRepository.findAll();
    }

    @DeleteMapping("/del")
    public Iterable<Cart> deleteCartItems(@RequestBody Iterable<Cart> cartItems) {

        cartRepository.deleteAll(cartItems);
        return cartRepository.findAll();
    }
}
