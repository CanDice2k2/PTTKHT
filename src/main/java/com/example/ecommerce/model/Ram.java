package com.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Ram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ram_option_id")
    private RamOption ramOption;

    @ManyToOne
    @JoinColumn(name = "electronic_devices_id")
    private ElectronicDevices electronicDevices;
}
