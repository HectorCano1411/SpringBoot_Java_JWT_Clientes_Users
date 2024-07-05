package com.hectorcano.springboot.megamedia.springboot_hector_mega.services;

import java.util.List;
import java.util.Optional;

import com.hectorcano.springboot.megamedia.springboot_hector_mega.entities.Cliente;

public interface ClienteService {

    List<Cliente> findAll();

    Optional<Cliente> findById(Long id);

    Cliente save(Cliente clientes);
    Optional <Cliente> update(Long id, Cliente clientes);

    Optional<Cliente> delete (Long id );

    // boolean existsBy(String value);
    

}
