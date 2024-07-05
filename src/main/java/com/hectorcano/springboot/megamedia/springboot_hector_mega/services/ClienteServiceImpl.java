package com.hectorcano.springboot.megamedia.springboot_hector_mega.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hectorcano.springboot.megamedia.springboot_hector_mega.entities.Cliente;
import com.hectorcano.springboot.megamedia.springboot_hector_mega.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl  implements ClienteService {
    
    @Autowired
    private ClienteRepository clienterepository;


    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {        
        return (List<Cliente>) clienterepository.findAll(); 
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Cliente> findById(Long id) {        
        return clienterepository.findById(id);
    }
    
    
    @Override
    @Transactional
    public Cliente save(Cliente clientes) {       
        return clienterepository.save(clientes);
    }
    
    @Override
    @Transactional
    public Optional <Cliente> update(Long id, Cliente clientes) {
        Optional <Cliente>  clienteoptional = clienterepository.findById(id);
        if(clienteoptional.isPresent()) {
            Cliente cliDb = clienteoptional.orElseThrow();
            cliDb.setNombre(clientes.getNombre());
            cliDb.setApellido(clientes.getApellido());
            cliDb.setEmail(clientes.getEmail());
            cliDb.setTelefono(clientes.getTelefono());
            return Optional.of(clienterepository.save(cliDb));
        };
        return clienteoptional;
    }
    @Override
    @Transactional
    public Optional <Cliente> delete(Long id) {
        Optional <Cliente>  clienteoptional = clienterepository.findById(id);
        clienteoptional.ifPresent(cliDb -> {
            clienterepository.delete(cliDb);
        });
        return clienteoptional;
        
    }


}
