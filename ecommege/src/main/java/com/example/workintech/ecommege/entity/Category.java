package com.example.workintech.ecommege.entity;
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
@Table(name = "category", schema = "ecommerce")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @NotBlank
    @NotNull
    @Size(max = 20)
    @Column(name = "code")
    private String code;

    @NotEmpty
    @NotBlank
    @NotNull
    @Size(max = 20)
    @Column(name = "title")
    private String title;

    @NotEmpty
    @NotBlank
    @NotNull
    @Column(name = "img")
    private String img;

    @NotNull
    @Column(name = "rating")
    private Double rating;

    @NotEmpty
    @NotBlank
    @NotNull
    @Size(max = 1)
    @Column(name = "gender")
    private String gender;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDate createdAt;


}

