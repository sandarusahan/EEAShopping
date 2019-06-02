package com.apiit.eeashopping.DB;

import com.apiit.eeashopping.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findUserByEmail(String email);

    boolean existsByEmail(String email);
}
