package com.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ElectronicDevices getElectronicDevices() {
        return electronicDevices;
    }

    public void setElectronicDevices(ElectronicDevices electronicDevices) {
        this.electronicDevices = electronicDevices;
    }

    public StorageOption getStorageOption() {
        return storageOption;
    }

    public void setStorageOption(StorageOption storageOption) {
        this.storageOption = storageOption;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
