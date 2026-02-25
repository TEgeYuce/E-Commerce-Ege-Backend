package com.example.workintech.ecommege.exceptions;
import org.springframework.http.HttpStatus;


public class InvalidPasswordException extends ECommerceException {

    public InvalidPasswordException(String message) {

        super(message, HttpStatus.UNAUTHORIZED);

    }


}

