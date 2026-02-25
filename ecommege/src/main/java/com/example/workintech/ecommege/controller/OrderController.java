package com.example.workintech.ecommege.controller;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.workintech.ecommege.service.OrderService;
import com.example.workintech.ecommege.dto.OrderResponse;
import com.example.workintech.ecommege.dto.OrderRequest;


@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/order")
    public List<OrderResponse> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping("/order")
    public OrderResponse save(@Validated @RequestBody OrderRequest orderRequest) {
        return orderService.save(orderRequest);

    }


}

