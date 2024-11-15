package com.example.ecommerce.request;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.ecommerce.model.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateProductRequest {

	private String name;

	private String description;

	private Integer quantityInStock;

	private Float price;

	private List<ProductImage> productImageList;

	//book
	private String type;

	private Date publicationDate;

	private String language;

	private List<AuthorBook> authorBookList;

	//clothes
	private String pattern;


	//fashion
	private String material;

	private String brand;

	private List<ProductSize> size;

	private List<ProductColor> color;

	private Gender gender;

	//laptop
	private String keyboardType;

	//mobile phone
	private String cameraSpecifications;

	//shoes
	private String soleType;

	//category id
	private String categoryName;

	//electronic devices
	private String os;

	private String weight;

	private String dimensions;

	private List<Storage> storage;

	private List<Ram> ram;

	private String processor;
}
