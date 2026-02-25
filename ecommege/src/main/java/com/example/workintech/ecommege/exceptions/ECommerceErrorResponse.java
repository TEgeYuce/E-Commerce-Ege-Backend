package com.example.workintech.ecommege.exceptions;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Getter
@Setter
public class ECommerceErrorResponse {

    private String message;
    private int status;
    private long timestamp;
    private LocalDateTime localDateTime;

}

