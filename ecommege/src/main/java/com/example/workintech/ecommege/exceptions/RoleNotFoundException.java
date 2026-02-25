package com.example.workintech.ecommege.exceptions;
import org.springframework.http.HttpStatus;


public class RoleNotFoundException extends ECommerceException {

    public RoleNotFoundException(String message) {

        super(message, HttpStatus.NOT_FOUND);

    }


}

