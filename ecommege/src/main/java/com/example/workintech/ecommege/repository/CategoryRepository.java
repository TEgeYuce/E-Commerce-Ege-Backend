package com.example.workintech.ecommege.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.workintech.ecommege.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByCode(String code);

    Category findByCode(String code);
}