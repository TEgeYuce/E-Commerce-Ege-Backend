package com.example.workintech.ecommege.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import com.example.workintech.ecommege.repository.CategoryRepository;
import com.example.workintech.ecommege.entity.Category;

@Configuration
@RequiredArgsConstructor
public class CategorySeedConfig {

    private final CategoryRepository categoryRepository;

    @Bean
    CommandLineRunner seedCategories() {
        return args -> {
            createOrUpdateCategory("ERK_GOMLEK", "Gömlek", "e", "https://images.pexels.com/photos/428338/pexels-photo-428338.jpeg");
            createOrUpdateCategory("ERK_TSHIRT", "T-Shirt", "e", "https://images.pexels.com/photos/1002644/pexels-photo-1002644.jpeg");
            createOrUpdateCategory("ERK_AYAKKABI", "Ayakkabı", "e", "https://images.pexels.com/photos/298863/pexels-photo-298863.jpeg");
            createOrUpdateCategory("ERK_PANTOLON", "Pantolon", "e", "https://images.pexels.com/photos/428338/pexels-photo-428338.jpeg");

            createOrUpdateCategory("KAD_ELBISE", "Elbise", "k", "https://images.pexels.com/photos/2983464/pexels-photo-2983464.jpeg");
            createOrUpdateCategory("KAD_BLUZ", "Bluz", "k", "https://images.pexels.com/photos/1910224/pexels-photo-1910224.jpeg");
            createOrUpdateCategory("KAD_TOPUKLU", "Topuklu", "k", "https://images.pexels.com/photos/19090/pexels-photo.jpg");
            createOrUpdateCategory("KAD_CANTA", "Çanta", "k", "https://images.pexels.com/photos/376159/pexels-photo-376159.jpeg");

            System.out.println("Categories checked/created/updated.");
        };
    }

    private void createOrUpdateCategory(String code, String title, String gender, String imgUrl) {

        Category category;

        if (categoryRepository.existsByCode(code)) {
            category = categoryRepository.findByCode(code);
            category.setImg(imgUrl);
        } else {
            category = new Category();
            category.setCode(code);
            category.setTitle(title);
            category.setGender(gender);
            category.setRating(4.5);
            category.setCreatedAt(java.time.LocalDate.now());
            category.setImg(imgUrl);
        }

        categoryRepository.save(category);
    }
}