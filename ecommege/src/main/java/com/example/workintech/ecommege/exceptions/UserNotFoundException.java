package com.example.workintech.ecommege.exceptions;
import org.springframework.http.HttpStatus;


public class UserNotFoundException extends ECommerceException {

    public UserNotFoundException(String message) {

        super(message, HttpStatus.NOT_FOUND);

    }


}

