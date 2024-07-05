package com.hectorcano.springboot.megamedia.springboot_hector_mega.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hectorcano.springboot.megamedia.springboot_hector_mega.entities.Role;



public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByName(String name);
    
}
