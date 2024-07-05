package com.hectorcano.springboot.megamedia.springboot_hector_mega.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.hectorcano.springboot.megamedia.springboot_hector_mega.ClienteValidatiion;
import com.hectorcano.springboot.megamedia.springboot_hector_mega.entities.Cliente;
import com.hectorcano.springboot.megamedia.springboot_hector_mega.services.ClienteService;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

@Autowired
private ClienteService service;

@Autowired
private ClienteValidatiion  validation;


@GetMapping
// @PreAuthorize("hasAnyRole('ADMIN','USER')")
public List<Cliente> list(){
        return service.findAll();
}

@GetMapping("/{id}")
// @PreAuthorize("hasAnyRole('ADMIN','USER')")
public ResponseEntity<?> view(@PathVariable Long id) {
    Optional<Cliente> clienteOptional = service.findById(id);
    if (clienteOptional.isPresent()){
        return ResponseEntity.ok(clienteOptional.orElseThrow());

    }
    return ResponseEntity.notFound().build();
}


@PostMapping
// @PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<?> create (@Valid @RequestBody Cliente clientes, BindingResult result) {
    validation.validate(clientes, result);
    if(result.hasFieldErrors())
    return validation(result);
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clientes));
}


@PutMapping("/{id}")
// @PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<?> update ( @Valid @RequestBody Cliente clientes, BindingResult result, @PathVariable Long id ) {
    validation.validate(clientes, result);

    if(result.hasFieldErrors())
    return validation(result);
    Optional<Cliente> clienteOptional = service.update(id, clientes); 
    if (clienteOptional.isPresent()) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteOptional.orElseThrow());        
    }
    return ResponseEntity.notFound().build();
}

@DeleteMapping("/{id}")
// @PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<?> delete(@PathVariable Long id) {
    
    Optional<Cliente> clienteOptional = service.delete(id);
    if (clienteOptional.isPresent()){
        return ResponseEntity.ok(clienteOptional.orElseThrow());
        
    }
    return ResponseEntity.notFound().build();
}
private ResponseEntity<?> validation(BindingResult result) {
    Map<String, String> errors = new HashMap<>();
    result.getFieldErrors().forEach( err -> {
        errors.put(err.getField(),"El campo " + err.getField() + " " + err.getDefaultMessage());
    });
    return ResponseEntity.badRequest().body(errors);
}

}