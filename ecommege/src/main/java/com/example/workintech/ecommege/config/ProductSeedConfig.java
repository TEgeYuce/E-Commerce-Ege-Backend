package com.example.workintech.ecommege.config;
import com.example.workintech.ecommege.entity.Product;
import com.example.workintech.ecommege.entity.ProductImages;
import com.example.workintech.ecommege.entity.Category;
import com.example.workintech.ecommege.repository.ProductRepository;
import com.example.workintech.ecommege.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


@Configuration
public class ProductSeedConfig {

    private final Random random = new Random();

    @Bean
    CommandLineRunner seedProducts(ProductRepository productRepository, CategoryRepository categoryRepository) {
        return args -> seedProductsIfEmpty(productRepository, categoryRepository);
    }

    @Transactional
    public void seedProductsIfEmpty(ProductRepository productRepository, CategoryRepository categoryRepository) {

        if (productRepository.count() > 0) {
            return;
        }

        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            System.out.println("Kategori bulunamadı. Lütfen önce kategori ekleyin!");
            return;
        }

        List<String> menProducts = List.of(
                "Erkek T-shirt", "Erkek Gömlek", "Erkek Pantolon", "Erkek Ayakkabı", "Erkek Ceket",
                "Erkek Sweatshirt", "Erkek Şort", "Erkek Mont", "Erkek Spor Ayakkabı", "Erkek Takım Elbise"
        );

        List<String> womenProducts = List.of(
                "Kadın Bluz", "Kadın Etek", "Kadın Elbise", "Kadın Topuklu Ayakkabı", "Kadın Ceket",
                "Kadın Pantolon", "Kadın Tunik", "Kadın Çanta", "Kadın Spor Ayakkabı", "Kadın Mont"
        );

        List<String> menImages = List.of(
                "https://source.unsplash.com/800x800/?men,tshirt",
                "https://source.unsplash.com/800x800/?men,shirt",
                "https://source.unsplash.com/800x800/?men,shoes",
                "https://source.unsplash.com/800x800/?men,jacket",
                "https://source.unsplash.com/800x800/?men,pants"
        );

        List<String> womenImages = List.of(
                "https://source.unsplash.com/800x800/?women,blouse",
                "https://source.unsplash.com/800x800/?women,dress",
                "https://source.unsplash.com/800x800/?women,shoes",
                "https://source.unsplash.com/800x800/?women,bag",
                "https://source.unsplash.com/800x800/?women,jacket"
        );

        List<Product> productsToSave = new ArrayList<>();

        for (int i = 0; i < 55; i++) {

            boolean isMen = random.nextBoolean();
            String name = isMen
                    ? menProducts.get(random.nextInt(menProducts.size()))
                    : womenProducts.get(random.nextInt(womenProducts.size()));

            String description = "Bu ürün " + name + " kategorisindendir.";

            double price = 50 + (500 - 50) * random.nextDouble();
            int stock = 5 + random.nextInt(50);
            double rating = Math.round((1 + random.nextDouble() * 4) * 10.0) / 10.0;
            int sellCount = random.nextInt(200);

            Category category = categories.get(random.nextInt(categories.size()));

            Product product = new Product();
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            product.setStock(stock);
            product.setRating(rating);
            product.setSellCount(sellCount);
            product.setCategory(category);

            int imageCount = 1 + random.nextInt(3);
            for (int j = 0; j < imageCount; j++) {
                ProductImages img = new ProductImages();
                String imageUrl = isMen
                        ? menImages.get(random.nextInt(menImages.size()))
                        : womenImages.get(random.nextInt(womenImages.size()));
                img.setUrl(imageUrl);
                img.setProduct(product);
                product.getProductImages().add(img);
            }

            productsToSave.add(product);
        }

        productRepository.saveAll(productsToSave);
        System.out.println(productsToSave.size() + " ürün başarıyla eklendi!");
    }
}