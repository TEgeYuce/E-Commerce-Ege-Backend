package com.example.workintech.ecommege.dto;


public record ProductFilterRequest(

        String filter,
        Long categoryId,
        String sort,
        String direction,
        Integer limit,
        Integer offset


)

{}