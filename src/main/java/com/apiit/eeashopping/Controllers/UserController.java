package com.apiit.eeashopping.Controllers;

import com.apiit.eeashopping.DB.UserRepository;
import com.apiit.eeashopping.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public User addNewUser(@RequestBody User user){

        userRepository.save(user);
        System.out.println(user.FName + " is added");

        return user;
    }

    @GetMapping("/{uid}")
    public User getUser(@PathVariable String uid){
        System.out.println("Fetching all products");
        return userRepository.findById(uid).get();
    }

    @PutMapping
    public User updateProduct(@RequestBody User user){

        userRepository.save(user);
        System.out.println(user.FName + " is updated");

        return user;
    }
    @DeleteMapping("/{uid}")
        public String deleteProduct(@PathVariable String uid){

            User u = userRepository.findById(uid).get();
            userRepository.deleteById(uid);
            System.out.println(u.FName + " is deleted");

            return "Deleted";
        }
}
