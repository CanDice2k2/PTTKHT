package com.example.ecommerce.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Laptop extends ElectronicDevices{
    private String keyboardType;
}
