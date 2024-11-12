package com.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProductSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fashion_id")
    private Fashion fashion;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size size;
}
