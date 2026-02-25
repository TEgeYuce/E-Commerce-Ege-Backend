package com.example.workintech.ecommege.dto;


public record CreditCardResponse(Long id, Long card_no, Integer expire_month, Integer expire_year, String name_on_card, Long user_id) {

}

