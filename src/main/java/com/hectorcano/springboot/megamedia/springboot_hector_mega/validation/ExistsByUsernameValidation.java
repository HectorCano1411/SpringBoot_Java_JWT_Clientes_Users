package com.hectorcano.springboot.megamedia.springboot_hector_mega.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hectorcano.springboot.megamedia.springboot_hector_mega.services.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class ExistsByUsernameValidation implements ConstraintValidator<ExistsByUsername, String> {

    @Autowired
    private UserService service;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (service == null) {
            return true;
        }
        return !service.existsByUsername(username);
    }
    
    
}
