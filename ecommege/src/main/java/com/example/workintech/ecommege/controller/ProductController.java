package com.example.workintech.ecommege.controller;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import jakarta.validation.constraints.Positive;
import com.example.workintech.ecommege.service.ProductService;
import com.example.workintech.ecommege.dto.ProductResponse;
import com.example.workintech.ecommege.dto.ProductListResponse;
import com.example.workintech.ecommege.dto.ProductFilterRequest;


@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public ProductListResponse getFilteredProducts(@RequestParam(required = false) String filter,
                                                   @RequestParam(required = false) Long category,
                                                   @RequestParam(required = false) String sort,
                                                   @RequestParam(required = false, defaultValue = "asc") String direction,
                                                   @RequestParam(defaultValue = "24") Integer limit,
                                                   @RequestParam(defaultValue = "0") Integer offset) {
        ProductFilterRequest request = new ProductFilterRequest(filter, category, sort, direction, limit, offset);

        return productService.getFilteredProducts(request);
    }

    @GetMapping("/products/{id}")
    public ProductResponse getProductById(@Positive @PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("products/bestsellers")
    public ProductListResponse getBestSellers(@RequestParam(defaultValue = "10") Integer limit) {
        return productService.getBestSellerProducts(limit);

    }


}

