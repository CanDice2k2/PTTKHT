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

    private String dimensions;

    @OneToMany(mappedBy = "electronicDevices",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductColor> color;

    @OneToMany(mappedBy = "electronicDevices",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Storage> storage;

    @OneToMany(mappedBy = "electronicDevices",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ram> ram;

    private String processor;
}
