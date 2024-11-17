package com.example.ecommerce.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class ElectronicDevices extends Product{
    private String os;

    private String brand;

    private String weight;

    @Override
    public String getOs() {
        return os;
    }

    @Override
    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getWeight() {
        return weight;
    }

    @Override
    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String getDimensions() {
        return dimensions;
    }

    @Override
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public List<ProductColor> getColor() {
        return color;
    }

    public void setColor(List<ProductColor> color) {
        this.color = color;
    }

    public List<Storage> getStorage() {
        return storage;
    }

    public void setStorage(List<Storage> storage) {
        this.storage = storage;
    }

    public List<Ram> getRam() {
        return ram;
    }

    public void setRam(List<Ram> ram) {
        this.ram = ram;
    }

    @Override
    public String getProcessor() {
        return processor;
    }

    @Override
    public void setProcessor(String processor) {
        this.processor = processor;
    }

    private String dimensions;

    @OneToMany(mappedBy = "electronicDevices",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductColor> color;

    @OneToMany(mappedBy = "electronicDevices",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Storage> storage;

    @OneToMany(mappedBy = "electronicDevices",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ram> ram;

    private String processor;
}
