package com.hectorcano.springboot.megamedia.springboot_hector_mega.entities;

// import com.hectorcano.springboot.megamedia.springboot_hector_mega.validation.IsRequired;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @IsRequired
    @Size(min=3, max=20) 
    private String nombre;

    @NotBlank(message = "debe tener minimo 3 caracteres y maxximo 20")
    @Size(min=3, max=20) 
    private String apellido;

    @NotBlank(message = "debe tener minimo 3 caracteres y maxximo 40")
    @Size(min=3, max=40) 
    private String email;

    @NotNull
    @Min(value = 9, message = "{Debe contar con minimo 9 digitos}")
    private Long telefono;


    private Long codCliente;


    // public Cliente() {
    // }


    // public Cliente(Long i, String nombre, String apellido, String email, Long telefono) {
    //     this.id = id;
    //     this.nombre = nombre;
    //     this.apellido = apellido;
    //     this.email = email;
    //     this.telefono = telefono;
    // }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getTelefono() {
        return telefono;
    }
    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
    public Long getCodCliente() {
        return codCliente;
    }
    public void setCodCliente(Long codCliente) {
        this.codCliente = codCliente;
    }


    
    
}
