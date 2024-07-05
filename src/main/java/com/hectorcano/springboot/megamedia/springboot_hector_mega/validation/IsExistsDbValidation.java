package com.hectorcano.springboot.megamedia.springboot_hector_mega.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.hectorcano.springboot.megamedia.springboot_hector_mega.services.ClienteService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class IsExistsDbValidation implements ConstraintValidator<IsExistsDb, String>{

    @Autowired
    private ClienteService service;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        
        if (service == null) {
            return true;
        }

        return true;
    }
    
}
