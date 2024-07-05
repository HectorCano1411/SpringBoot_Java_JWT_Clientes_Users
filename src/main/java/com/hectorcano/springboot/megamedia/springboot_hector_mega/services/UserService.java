package com.hectorcano.springboot.megamedia.springboot_hector_mega.services;

import java.util.List;

import com.hectorcano.springboot.megamedia.springboot_hector_mega.entities.User;



public interface UserService {
    
    List<User> findAll();

    User save(User user);

    boolean existsByUsername(String username);

}
