package com.example.workintech.ecommege.entity;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product", schema = "ecommerce")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @NotBlank
    @NotNull
    @Size(max = 50)
    @Column(name = "name")
    private String name;

    @NotEmpty
    @NotBlank
    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "price")
    private Double price;

    @NotNull
    @Column(name = "stock")
    private Integer stock;

    @Column(name = "store_id")
    private Long storeId;

    @NotNull
    @Column(name = "rating")
    private Double rating;

    @NotNull
    @Column(name = "sell_count")
    private Integer sellCount;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDate createdAt;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductImages> productImages = new ArrayList<>();
}

