package com.example.workintech.ecommege.mapper;
import java.util.List;
import org.springframework.stereotype.Component;
import com.example.workintech.ecommege.entity.Product;
import com.example.workintech.ecommege.dto.ProductResponse;
import com.example.workintech.ecommege.dto.ProductImagesResponse;


@Component
public class ProductMapper {

    public ProductResponse toResponse(Product product) {
        List<ProductImagesResponse> productImagesResponses = product.getProductImages()
                .stream()
                .map(image -> new ProductImagesResponse(image.getUrl(), image.getIndex()))
                .toList();

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getCategory().getId(),
                product.getPrice(),
                product.getRating(),
                product.getSellCount(),
                product.getStock(),
                product.getStoreId(),
                productImagesResponses
        );
    }

}

