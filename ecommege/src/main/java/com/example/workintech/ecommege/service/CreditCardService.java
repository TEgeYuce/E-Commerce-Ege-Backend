package com.example.workintech.ecommege.service;
import java.util.List;
import com.example.workintech.ecommege.dto.CreditCardResponse;
import com.example.workintech.ecommege.dto.CreditCardRequest;
import com.example.workintech.ecommege.dto.BackendResponse;


public interface CreditCardService {

    List<CreditCardResponse> getCreditCards();
    CreditCardResponse save(CreditCardRequest creditCardRequest);
    CreditCardResponse update(Long id, CreditCardRequest creditCardRequest);
    BackendResponse delete(Long id);

}

