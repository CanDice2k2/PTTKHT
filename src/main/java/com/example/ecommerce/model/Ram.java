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

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RamOption getRamOption() {
        return ramOption;
    }

    public void setRamOption(RamOption ramOption) {
        this.ramOption = ramOption;
    }

    public ElectronicDevices getElectronicDevices() {
        return electronicDevices;
    }

    public void setElectronicDevices(ElectronicDevices electronicDevices) {
        this.electronicDevices = electronicDevices;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
