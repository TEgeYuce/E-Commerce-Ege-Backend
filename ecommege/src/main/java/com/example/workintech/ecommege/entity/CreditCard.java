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
@Table(name = "credit_card", schema = "ecommerce")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "card_no")
    private Long cardNo;

    @NotNull
    @Column(name = "expire_month")
    private Integer expireMonth;

    @NotNull
    @Column(name = "expire_year")
    private Integer expireYear;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 50)
    @Column(name = "name_on_card")
    private String nameOnCard;

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

