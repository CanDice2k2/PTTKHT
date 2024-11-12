package com.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Fashion extends Product{
    private String material;

    private String brand;

    @OneToMany(mappedBy = "fashion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductSize> size;

    @OneToMany(mappedBy = "fashion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductColor> color;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;
}
