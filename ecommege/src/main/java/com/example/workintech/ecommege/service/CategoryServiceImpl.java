package com.example.workintech.ecommege.service;
import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.workintech.ecommege.repository.CategoryRepository;
import com.example.workintech.ecommege.mapper.CategoryMapper;
import com.example.workintech.ecommege.dto.CategoryResponse;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponse> getCategories() {

        return categoryRepository.findAll().stream().map(categoryMapper::toResponse).toList();

    }


}

