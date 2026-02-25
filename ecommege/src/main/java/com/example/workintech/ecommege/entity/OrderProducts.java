package com.example.workintech.ecommege.entity;
import java.time.LocalDate;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "order_products", schema = "ecommerce")
public class OrderProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "count")
    private Integer count;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 50)
    @Column(name = "name")
    private String name;

    @NotNull
    @NotEmpty
    @NotBlank
    @Column(name = "description")
    private String description;

    @NotNull
    private Double price;

    @NotNull
    @NotEmpty
    @NotBlank
    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDate createdAt;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


}

