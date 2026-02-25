package com.example.workintech.ecommege.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.workintech.ecommege.entity.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserId(Long userId);

}

