package com.example.workintech.ecommege.dto;
import java.util.List;


public record ProductListResponse(List<ProductResponse> products, Long total) {

}

