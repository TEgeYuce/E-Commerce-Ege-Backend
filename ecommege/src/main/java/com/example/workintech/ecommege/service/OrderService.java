package com.example.workintech.ecommege.service;
import java.util.List;
import com.example.workintech.ecommege.dto.OrderResponse;
import com.example.workintech.ecommege.dto.OrderRequest;


public interface OrderService {

    List<OrderResponse> getOrders();
    OrderResponse save(OrderRequest orderRequest);

}

