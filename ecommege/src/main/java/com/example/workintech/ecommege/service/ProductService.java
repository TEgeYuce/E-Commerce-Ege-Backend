package com.example.workintech.ecommege.service;
import com.example.workintech.ecommege.dto.ProductResponse;
import com.example.workintech.ecommege.dto.ProductListResponse;
import com.example.workintech.ecommege.dto.ProductFilterRequest;


public interface ProductService {

    ProductListResponse getProducts();
    ProductListResponse getFilteredProducts(ProductFilterRequest productFilterRequest);
    ProductResponse getProductById(Long id);
    ProductListResponse getBestSellerProducts(Integer limit);

}

