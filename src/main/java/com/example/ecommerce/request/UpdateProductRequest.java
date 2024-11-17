package com.example.ecommerce.request;

import com.example.ecommerce.model.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Getter
@Setter
public class UpdateProductRequest {
    private Long id;

    private String name;
    private String description;
    private int quantityInStock;
    private float price;
    private String type;
    private LocalDate publicationDate;
    private String language;
    private String brand;
    private String os;
    private String weight;
    private String dimensions;
    private String processor;
    private String keyboardType;
    private String cameraSpecifications;
    private String material;
    private Gender genderId; // Reference to Gender entity
    private String pattern;
    private String soleType;
    private Category categoryId;

	private List<Storage> storage;
	private List<Ram> ram;
	private List<ProductSize> size;
	private List<AuthorBook> authorBookList;
	private List<ProductColor> color;
	private List<ProductImage> productImageList;
}
