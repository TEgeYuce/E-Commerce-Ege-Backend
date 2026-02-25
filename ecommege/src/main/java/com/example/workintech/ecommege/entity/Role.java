package com.example.workintech.ecommege.entity;
import org.springframework.security.core.GrantedAuthority;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "role", schema = "ecommerce")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 50)
    private String name;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 50)
    private String code;

    @Override
    public String getAuthority() {
        return this.code;
    }


}

