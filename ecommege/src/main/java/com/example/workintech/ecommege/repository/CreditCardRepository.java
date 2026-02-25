package com.example.workintech.ecommege.repository;
import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.workintech.ecommege.entity.CreditCard;


public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

    Optional<CreditCard> findByCardNo(Long cardNo);
    List<CreditCard> findByUserId(Long userId);

}

