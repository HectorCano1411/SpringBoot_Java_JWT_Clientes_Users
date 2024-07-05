package com.hectorcano.springboot.megamedia.springboot_hector_mega.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;

import com.hectorcano.springboot.megamedia.springboot_hector_mega.entities.Cliente;



public interface ClienteRepository  extends JpaRepository<Cliente, Long>{

}
