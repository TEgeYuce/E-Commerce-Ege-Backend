package com.example.workintech.ecommege.mapper;
import org.springframework.stereotype.Component;
import com.example.workintech.ecommege.entity.CreditCard;
import com.example.workintech.ecommege.dto.CreditCardResponse;
import com.example.workintech.ecommege.dto.CreditCardRequest;


@Component
public class CreditCardMapper {
    public CreditCard toEntity(CreditCardRequest creditCardRequest) {
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNo(creditCardRequest.card_no());
        creditCard.setExpireMonth(creditCardRequest.expire_month());
        creditCard.setExpireYear(creditCardRequest.expire_year());
        creditCard.setNameOnCard(creditCardRequest.name_on_card());
        return creditCard;
    }

    public CreditCardResponse toResponse(CreditCard creditCard) {

        return new CreditCardResponse(creditCard.getId(), creditCard.getCardNo(), creditCard.getExpireMonth(), creditCard.getExpireYear(), creditCard.getNameOnCard(), creditCard.getUser().getId());
    }


}

