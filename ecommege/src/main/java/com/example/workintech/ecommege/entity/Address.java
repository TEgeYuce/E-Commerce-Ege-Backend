package com.example.workintech.ecommege.entity;
import java.time.LocalDate;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
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
@Table(name = "address", schema = "ecommerce")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 10)
    @Column(name = "title")
    private String title;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 20)
    @Column(name = "name")
    private String name;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 20)
    @Column(name = "surname")
    private String surname;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 12)
    @Column(name = "phone")
    private String phone;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 20)
    @Column(name = "city")
    private String city;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 30)
    @Column(name = "district")
    private String district;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 30)
    @Column(name = "neighborhood")
    private String neighborhood;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 50)
    @Column(name = "address")
    private String address;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDate createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDate updatedAt;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}

