package com.example.workintech.ecommege.exceptions;
import org.springframework.http.HttpStatus;


public class CardAlreadyExistsException extends ECommerceException {

    public CardAlreadyExistsException(String message) {

        super(message, HttpStatus.CONFLICT);

    }


}

