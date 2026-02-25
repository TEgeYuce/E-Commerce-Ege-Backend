package com.example.workintech.ecommege.dto;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotBlank;


public record AddressRequest(

        @NotNull
        @NotEmpty
        @NotBlank
        @Size(max = 10)
        String title,

        @NotNull
        @NotEmpty
        @NotBlank
        @Size(max = 20)
        String name,

        @NotNull
        @NotEmpty
        @NotBlank
        @Size(max = 20)
        String surname,

        @NotNull
        @NotEmpty
        @NotBlank
        @Size(max = 12)
        String phone,

        @NotNull
        @NotEmpty
        @NotBlank
        @Size(max = 20)
        String city,

        @NotNull
        @NotEmpty
        @NotBlank
        @Size(max = 30)
        String district,

        @NotNull
        @NotEmpty
        @NotBlank
        @Size(max = 30)
        String neighborhood,

        @NotNull
        @NotEmpty
        @NotBlank
        @Size(max = 50)
        String address


)


{}