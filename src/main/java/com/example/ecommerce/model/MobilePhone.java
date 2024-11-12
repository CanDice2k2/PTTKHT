package com.example.ecommerce.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class MobilePhone extends ElectronicDevices{
    private String cameraSpecifications;
}
