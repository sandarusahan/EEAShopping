package com.apiit.eeashopping.Controllers;

import com.apiit.eeashopping.DB.RoleRepository;
import com.apiit.eeashopping.DB.UserRepository;
import com.apiit.eeashopping.Model.Role;
import com.apiit.eeashopping.Model.User;
import com.apiit.eeashopping.Model.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @PostMapping("/register")
    public User addNewUser(@RequestBody UserForm user){

        Role role = roleRepository.findById(user.role).get();
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        User newUser = new User();
        newUser.fName = user.fName;
        newUser.lName = user.lName;
        newUser.gender = user.gender;
        newUser.address = user.address;
        newUser.contact = user.contact;
        newUser.email = user.email;
        newUser.image = user.image;
        newUser.password = user.password;
        newUser.role = roleSet;
        userRepository.save(newUser);
        System.out.println(newUser.lName + " is added");

        return newUser;
    }

    @GetMapping("/{uid}")
    public User getUser(@PathVariable String uid){
        System.out.println("Fetching all products");
        return userRepository.findById(uid).get();
    }

    @GetMapping("check/{email}")
    public Boolean isEmailExist(@PathVariable String email){
        System.out.println("Checking email is available");

        return userRepository.existsByEmail(email);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/user/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        System.out.println("Fetching all products");
        return userRepository.findAll();
    }


    @PutMapping(path = "/user")
    public User updateUser(@RequestBody User user){

        User newuser = userRepository.save(user);
        System.out.println(newuser.fName + " is updated");

        return newuser;
    }


    @DeleteMapping("/{uid}")
        public Boolean deleteUser(@PathVariable String uid){

            Optional u = userRepository.findById(uid);
            if(u.isPresent())
            userRepository.deleteById(uid);

            System.out.println(u.get().toString() + " is deleted");

            return u.isPresent();
        }
}
