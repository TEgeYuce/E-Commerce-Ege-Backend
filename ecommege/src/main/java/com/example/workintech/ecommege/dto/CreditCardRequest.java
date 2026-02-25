package com.example.workintech.ecommege.dto;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotBlank;


public record CreditCardRequest(

        @NotNull
        Long card_no,

        @NotNull
        Integer expire_month,

        @NotNull
        Integer expire_year,

        @NotNull
        @NotEmpty
        @NotBlank
        @Size(max = 50)
        String name_on_card


)

{}