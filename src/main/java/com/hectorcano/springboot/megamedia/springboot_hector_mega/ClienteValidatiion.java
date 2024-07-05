package com.hectorcano.springboot.megamedia.springboot_hector_mega;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hectorcano.springboot.megamedia.springboot_hector_mega.entities.Cliente;

@Component
public class ClienteValidatiion  implements Validator {

    @SuppressWarnings("null")
    @Override
    public boolean supports(Class<?> clazz) {
        
        return Cliente.class.isAssignableFrom(clazz);
    }

    @SuppressWarnings("null")
    @Override
    public void validate(Object target, Errors errors) {
    Cliente clientes = (Cliente) target;
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre",null, "es requerido!");

    if(clientes.getApellido() == null || clientes.getApellido().isBlank()){
        errors.rejectValue("apellido", null,"es requerido, por favor");
    }
    if (clientes.getEmail() == null){
       errors.rejectValue("email", null,"no puede ser nulo, ok!");
   } 
     if (clientes.getTelefono() == null){
        errors.rejectValue("telefono", null,"debe ser un valor numerico mayor o igual que 9 digitos!");
    } 


    }

}
