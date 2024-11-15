package com.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ProductColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fashion_id")
    private Fashion fashion;

    @ManyToOne
    @JoinColumn(name = "mobile_phone_id")
    private MobilePhone mobilePhone;

    @ManyToOne
    @JoinColumn(name = "laptop_id")
    private Laptop laptop;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "electronic_devices_id")
    private ElectronicDevices electronicDevices;
}
