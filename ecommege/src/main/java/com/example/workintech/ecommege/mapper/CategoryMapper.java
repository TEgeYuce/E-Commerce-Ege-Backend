package com.example.workintech.ecommege.mapper;
import org.springframework.stereotype.Component;
import com.example.workintech.ecommege.entity.Category;
import com.example.workintech.ecommege.dto.CategoryResponse;


@Component
public class CategoryMapper {

    public CategoryResponse toResponse(Category category) {

        return new CategoryResponse(category.getId(), category.getCode(), category.getTitle(), category.getImg(), category.getRating(), category.getGender());
    }


}

