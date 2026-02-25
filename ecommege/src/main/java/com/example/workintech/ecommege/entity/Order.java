package com.example.workintech.ecommege.entity;
import java.util.List;
import java.time.LocalDateTime;
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
@Table(name = "order", schema = "ecommerce")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "card_expire_month")
    private Integer cardExpireMonth;

    @NotNull
    @Column(name = "card_expire_year")
    private Integer cardExpireYear;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 50)
    @Column(name = "card_name")
    private String cardName;

    @NotNull
    @Column(name = "card_no")
    private Long cardNo;

    @Column(name = "order_date")
    @CreationTimestamp
    private LocalDateTime orderDate;

    @NotNull
    @Column(name = "price")
    private Double price;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderProducts> products;


}

