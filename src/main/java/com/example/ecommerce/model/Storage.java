package com.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "electronic_devices_id")
    private ElectronicDevices electronicDevices;

    @ManyToOne
    @JoinColumn(name = "storage_option_id")
    private StorageOption storageOption;
}
