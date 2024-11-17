package com.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Fashion extends Product{
    private String material;

    private String brand;

    @OneToMany(mappedBy = "fashion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductSize> size;

    @OneToMany(mappedBy = "fashion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductColor> color;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<ProductSize> getSize() {
        return size;
    }

    public void setSize(List<ProductSize> size) {
        this.size = size;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<ProductColor> getColor() {
        return color;
    }

    public void setColor(List<ProductColor> color) {
        this.color = color;
    }
}
