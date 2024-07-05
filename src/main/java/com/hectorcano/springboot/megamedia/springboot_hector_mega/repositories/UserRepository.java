package com.hectorcano.springboot.megamedia.springboot_hector_mega.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hectorcano.springboot.megamedia.springboot_hector_mega.entities.User;



public interface UserRepository extends CrudRepository<User, Long>{
    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);
}
