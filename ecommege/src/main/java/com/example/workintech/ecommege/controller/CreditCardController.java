package com.example.workintech.ecommege.controller;
import java.util.List;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.http.HttpStatus;
import com.example.workintech.ecommege.service.CreditCardService;
import com.example.workintech.ecommege.dto.CreditCardResponse;
import com.example.workintech.ecommege.dto.BackendResponse;
import com.example.workintech.ecommege.dto.CreditCardRequest;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class CreditCardController {

    private final CreditCardService creditCardService;

    @GetMapping("/card")
    public List<CreditCardResponse> getCreditCards() {
        return creditCardService.getCreditCards();
    }

    @PostMapping("/card")
    public CreditCardResponse save(@Validated @RequestBody CreditCardRequest cardRequest) {
        return creditCardService.save(cardRequest);
    }

    @PutMapping("/card")
    public CreditCardResponse update(@Positive Long id, @Validated @RequestBody CreditCardRequest cardRequest) {
        return creditCardService.update(id, cardRequest);
    }

    @DeleteMapping("/card/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BackendResponse delete(@Positive @PathVariable Long id) {
        return creditCardService.delete(id);
    }


}

