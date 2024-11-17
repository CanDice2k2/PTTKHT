package com.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity_in_stock")
    private int quantityInStock;

    @Column(name = "price")
    private float price;

    @Column(name = "type")
    private String type;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getGenderId() {
        return genderId;
    }

    public void setGenderId(Long genderId) {
        this.genderId = genderId;
    }

    public List<Storage> getProductStorageList() {
        return productStorageList;
    }

    public void setProductStorageList(List<Storage> productStorageList) {
        this.productStorageList = productStorageList;
    }

    public List<Ram> getProductRamList() {
        return productRamList;
    }

    public void setProductRamList(List<Ram> productRamList) {
        this.productRamList = productRamList;
    }

    @Column(name = "language")
    private String language;

    @Column(name = "brand")
    private String brand;

    @Column(name = "os")
    private String os;

    @Column(name = "weight")
    private String weight;

    @Column(name = "dimensions")
    private String dimensions;

    @Column(name = "processor")
    private String processor;

    @Column(name = "keyboard_type")
    private String keyboardType;

    @Column(name = "camera_specifications")
    private String cameraSpecifications;

    @Column(name = "material")
    private String material;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @Column(name = "gender_id", insertable = false, updatable = false)
    private Long genderId;

    @Column(name = "pattern")
    private String pattern;

    @Column(name = "sole_type")
    private String soleType;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImage> productImageList;

    public List<ProductColor> getProductColorList() {
        return productColorList;
    }

    public void setProductColorList(List<ProductColor> productColorList) {
        this.productColorList = productColorList;
    }

    public List<ProductSize> getProductSizeList() {
        return productSizeList;
    }

    public void setProductSizeList(List<ProductSize> productSizeList) {
        this.productSizeList = productSizeList;
    }

    public List<ProductImage> getProductImageList() {
        return productImageList;
    }

    public void setProductImageList(List<ProductImage> productImageList) {
        this.productImageList = productImageList;
    }

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductColor> productColorList;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductSize> productSizeList;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Storage> productStorageList;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ram> productRamList;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AuthorBook> productAuthorBook;

    public List<AuthorBook> getProductAuthorBook() {
        return productAuthorBook;
    }

    public void setProductAuthorBook(List<AuthorBook> productAuthorBook) {
        this.productAuthorBook = productAuthorBook;
    }

    public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getQuantityInStock() {
            return quantityInStock;
        }

        public void setQuantityInStock(int quantityInStock) {
            this.quantityInStock = quantityInStock;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public LocalDate getPublicationDate() {
            return publicationDate;
        }

        public void setPublicationDate(LocalDate publicationDate) {
            this.publicationDate = publicationDate;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getOs() {
            return os;
        }

        public void setOs(String os) {
            this.os = os;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getDimensions() {
            return dimensions;
        }

        public void setDimensions(String dimensions) {
            this.dimensions = dimensions;
        }

        public String getProcessor() {
            return processor;
        }

        public void setProcessor(String processor) {
            this.processor = processor;
        }

        public String getKeyboardType() {
            return keyboardType;
        }

        public void setKeyboardType(String keyboardType) {
            this.keyboardType = keyboardType;
        }

        public String getCameraSpecifications() {
            return cameraSpecifications;
        }

        public void setCameraSpecifications(String cameraSpecifications) {
            this.cameraSpecifications = cameraSpecifications;
        }

        public String getMaterial() {
            return material;
        }

        public void setMaterial(String material) {
            this.material = material;
        }

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }

        public String getSoleType() {
            return soleType;
        }

        public void setSoleType(String soleType) {
            this.soleType = soleType;
        }

        @Override
        public String toString() {
            return "Product [id=" + id + ", category=" + category + ", name=" + name + ", description=" + description
                    + ", quantityInStock=" + quantityInStock + ", price=" + price + ", type=" + type + ", publicationDate="
                    + publicationDate + ", language=" + language + ", brand=" + brand + ", os=" + os + ", weight=" + weight
                    + ", dimensions=" + dimensions + ", processor=" + processor + ", keyboardType=" + keyboardType
                    + ", cameraSpecifications=" + cameraSpecifications + ", material=" + material + ", gender=" + genderId
                    + ", pattern=" + pattern + ", soleType=" + soleType + "]";
        }

}
