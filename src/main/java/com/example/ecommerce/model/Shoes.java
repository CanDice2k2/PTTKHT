package com.example.ecommerce.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Shoes extends Fashion{
    private String soleType;
}
