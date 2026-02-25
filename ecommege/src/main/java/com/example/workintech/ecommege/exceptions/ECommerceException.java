package com.example.workintech.ecommege.exceptions;
import org.springframework.http.HttpStatus;
import lombok.Getter;


@Getter
public class ECommerceException extends RuntimeException {

    private HttpStatus httpStatus;

    public ECommerceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;

    }


}

