package com.apiit.eeashopping.Services;

import com.apiit.eeashopping.DB.UserRepository;
import com.apiit.eeashopping.Model.CustomUserDetails;
import com.apiit.eeashopping.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findUserByEmail(s);
        if(user.isPresent()) {
            return new CustomUserDetails(user.get());
        }else {
            throw new UsernameNotFoundException("email not found");
        }
    }
}
