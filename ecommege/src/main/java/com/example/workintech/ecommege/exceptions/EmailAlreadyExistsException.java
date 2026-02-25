package com.example.workintech.ecommege.exceptions;
import org.springframework.http.HttpStatus;


public class EmailAlreadyExistsException extends ECommerceException {

    public EmailAlreadyExistsException(String message) {

        super(message, HttpStatus.CONFLICT);

    }


}

