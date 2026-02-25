package com.example.workintech.ecommege.exceptions;
import org.springframework.http.HttpStatus;


public class AddressNotFoundException extends ECommerceException{

    public AddressNotFoundException(String message){

        super(message, HttpStatus.NOT_FOUND);

    }


}

