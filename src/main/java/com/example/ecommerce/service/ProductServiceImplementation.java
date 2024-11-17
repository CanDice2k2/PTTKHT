package com.example.ecommerce.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.ecommerce.model.*;
import com.example.ecommerce.repository.GenderRepository;
import com.example.ecommerce.request.UpdateProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.ecommerce.exception.ProductException;
import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.request.CreateProductRequest;

@Service
public class ProductServiceImplementation implements ProductService {

	private ProductRepository productRepository;
	private UserService userService;
	private CategoryRepository categoryRepository;
	private GenderRepository genderRepository;


	public ProductServiceImplementation(ProductRepository productRepository,UserService userService,CategoryRepository categoryRepository, GenderRepository genderRepository) {
		this.productRepository=productRepository;
		this.userService=userService;
		this.categoryRepository=categoryRepository;
		this.genderRepository=genderRepository;

	}
	

	@Override
	public Product createProduct(CreateProductRequest req) {
		Category category = categoryRepository.findById(req.getCategoryId())
                                              .orElseThrow(() -> new RuntimeException("Category not found"));
		Product product = null;


		if (category.getName().equals("book")) {
			// Add book
			product = new Product();
			product.setLanguage(req.getLanguage());
			product.setType(req.getType());
			product.setPublicationDate(req.getPublicationDate());
			if (product.getProductAuthorBook() == null) {
				product.setProductAuthorBook(new ArrayList<>());
			}
			if (req.getAuthorBookList() != null && !req.getAuthorBookList().isEmpty()) {
				for (AuthorBook authorbook : req.getAuthorBookList()) {
					authorbook.setId(null);
					authorbook.setProduct(product);
					if (!product.getProductAuthorBook().contains(authorbook)) {
						product.getProductAuthorBook().add(authorbook);
					}
				}
			}

		} else if (category.getName().equals("clothes")) {
			// Add clothes
			Optional<Gender> gender = genderRepository.findById(req.getGenderId());
			product = new Product();
			product.setBrand(req.getBrand());
			product.setMaterial(req.getMaterial());
			product.setPattern(req.getPattern());
			if (gender.isPresent()) {
				product.setGenderId(gender.get().getId());
				product.setGender(gender.get());
			} else {
				product.setGenderId(null);
			}
		} else if (category.getName().equals("shoes")) {
			Optional<Gender> gender = genderRepository.findById(req.getGenderId());

			// Add shoes
//			product = new Shoes();
//			((Shoes) product).setBrand(req.getBrand());
//			((Shoes) product).setColor(req.getColor());
//			((Shoes) product).setGender(gender.orElse(null));
//			((Shoes) product).setMaterial(req.getMaterial());
//			((Shoes) product).setSize(req.getSize());
//			((Shoes) product).setSoleType(req.getSoleType());
			product = new Product();
			product.setBrand(req.getBrand());
			product.setMaterial(req.getMaterial());
			product.setSoleType(req.getSoleType());
			if (gender.isPresent()) {
				product.setGenderId(gender.get().getId());
				product.setGender(gender.get());
			} else {
				product.setGenderId(null);
			}
		} else if (category.getName().equals("laptop")) {
			Optional<Gender> gender = genderRepository.findById(req.getGenderId());

			// Add laptop
			product = new Product();

			product.setOs(req.getOs());
			product.setBrand(req.getBrand());
			product.setWeight(req.getWeight());
			product.setDimensions(req.getDimensions());
			product.setProcessor(req.getProcessor());
			product.setKeyboardType(req.getKeyboardType());
			product.setLanguage(req.getLanguage());
			product.setMaterial(req.getMaterial());
			product.setSoleType(req.getSoleType());
			product.setCameraSpecifications(req.getCameraSpecifications());
			product.setType(req.getType());
			product.setPublicationDate(req.getPublicationDate());
			if (gender.isPresent()) {
				product.setGenderId(gender.get().getId());
				product.setGender(gender.get());
			} else {
				product.setGenderId(null);
			}

		} else if (category.getName().equals("mobile phone")) {
			// Add mobile phone
			product = new Product();
//			((MobilePhone) product).setOs(req.getOs());
//			((MobilePhone) product).setBrand(req.getBrand());
//			((MobilePhone) product).setWeight(req.getWeight());
//			((MobilePhone) product).setDimensions(req.getDimensions());
//			((MobilePhone) product).setColor(req.getColor());
//			((MobilePhone) product).setStorage(req.getStorage());
//			((MobilePhone) product).setRam(req.getRam());
//			((MobilePhone) product).setProcessor(req.getProcessor());
//			((MobilePhone) product).setCameraSpecifications(req.getCameraSpecifications());

			product.setOs(req.getOs());
			product.setBrand(req.getBrand());
			product.setWeight(req.getWeight());
			product.setDimensions(req.getDimensions());
			product.setProcessor(req.getProcessor());
			product.setCameraSpecifications(req.getCameraSpecifications());
		}

		if (product != null) {
			product.setCategory(category);
			product.setName(req.getName());
			product.setPrice(req.getPrice());

			if (product.getProductImageList() == null) {
				product.setProductImageList(new ArrayList<>());
			}
			if (req.getProductImageList() != null && !req.getProductImageList().isEmpty()) {
				for (ProductImage image : req.getProductImageList()) {
					image.setId(null);
					image.setProduct(product);
					if (!product.getProductImageList().contains(image)) {
						product.getProductImageList().add(image);
					}
				}
			}

			if (product.getProductColorList() == null) {
				product.setProductColorList(new ArrayList<>());
			}
			if (req.getProductColorList() != null && !req.getProductColorList().isEmpty()) {
				for (ProductColor color : req.getProductColorList()) {
					color.setId(null);
					color.setProduct(product);
					if (!product.getProductColorList().contains(color)) {
						product.getProductColorList().add(color);
					}
				}
			}

			if (product.getProductSizeList() == null) {
				product.setProductSizeList(new ArrayList<>());
			}
			if (req.getProductSizeList() != null && !req.getProductSizeList().isEmpty()) {
				for (ProductSize size : req.getProductSizeList()) {
					size.setId(null);
					size.setProduct(product);
					if (!product.getProductSizeList().contains(size)) {
						product.getProductSizeList().add(size);
					}
				}
			}

			if (product.getProductRamList() == null) {
				product.setProductRamList(new ArrayList<>());
			}
			if (req.getRam() != null && !req.getRam().isEmpty()) {
				for (Ram ram : req.getRam()) {
					ram.setId(null);
					ram.setProduct(product);
					if (!product.getProductRamList().contains(ram)) {
						product.getProductRamList().add(ram);
					}
				}
			}

			if (product.getProductStorageList() == null) {
				product.setProductStorageList(new ArrayList<>());
			}
			if (req.getStorage() != null && !req.getStorage().isEmpty()) {
				for (Storage storage : req.getStorage()) {
					storage.setId(null);
					storage.setProduct(product);
					if (!product.getProductStorageList().contains(storage)) {
						product.getProductStorageList().add(storage);
					}
				}
			}

			product.setDescription(req.getDescription());
			product.setQuantityInStock(req.getQuantityInStock());
			System.out.print(product.toString());
			return productRepository.save(product);
		}

		return null;
	}

	@Override
	public String deleteProduct(Long productId) throws ProductException {
		Product product=findProductById(productId);
//		System.out.println("product - "+product);
//		System.out.println("delete product "+product.getId()+" - "+productId);
//		product.getSizes().clear();
////		productRepository.save(product);
////		product.getCategory().
		productRepository.delete(product);
		
		return "Product deleted Successfully";
	}

	@Override
	public Product updateProduct(UpdateProductRequest req) throws ProductException {
//		try {
//		Product product=findProductById(req.getId());
//		System.out.println("product da tim duoc - "+product);
//		System.out.println("request - "+req);
//		if(req.getQuantity()!=0) {
//			product.setQuantity(req.getQuantity());
//		}
//		if(req.getDescription()!=null) {
//			product.setDescription(req.getDescription());
//		}
//		if(req.getDiscountedPrice()!=0) {
//			product.setDiscountedPrice(req.getDiscountedPrice());
//		}
//		if(req.getDiscountPersent()!=0) {
//			product.setDiscountPersent(req.getDiscountPersent());
//		}
//		if(req.getImageUrl()!=null) {
//			product.setImageUrl(req.getImageUrl());
//		}
//		if(req.getBrand()!=null) {
//			product.setBrand(req.getBrand());
//		}
//		if(req.getPrice()!=0) {
//			product.setPrice(req.getPrice());
//		}
//		if(req.getColor()!=null) {
//			product.setColor(req.getColor());
//		}
//		if(req.getTitle()!=null) {
//			product.setTitle(req.getTitle());
//		}
//		if(req.getSizes()!=null) {
//			product.setSizes(req.getSizes());
//		}
//		if(req.getTopLavelCategory()!=null && req.getSecondLavelCategory()!=null && req.getThirdLavelCategory()!=null) {
//			Category topLevel = categoryRepository.findByName(req.getTopLavelCategory());
//			Category secondLevel = categoryRepository.findByNameAndParantId(req.getSecondLavelCategory(), topLevel.getId());
//			Category thirdLevel = categoryRepository.findByNameAndParantId(req.getThirdLavelCategory(), secondLevel.getId());
//			product.setCategory(thirdLevel);
//		}
//			return productRepository.save(product);
//
//		}
//		catch (Exception e) {
//			System.out.println("error - "+e);
//		}
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product findProductById(Long id) throws ProductException {
		Optional<Product> opt=productRepository.findById(id);

		if(opt.isPresent()) {
			return opt.get();
		}
		throw new ProductException("product not found with id "+id);
	}

	@Override
	public List<Product> findProductByCategory(String category) {
		System.out.println("category --- "+category);
//		Category topLevel = categoryRepository.findByName(req.getTopLavelCategory());
//		Category secondLevel = categoryRepository.findByNameAndParantId(req.getSecondLavelCategory(),topLevel.getId());
//		Category thirdLevel = categoryRepository.findByNameAndParantId(req.getThirdLavelCategory(),secondLevel.getId());
//		System.out.println("category --- "+category);
		
//		List<Product> products = productRepository.findByCategory(category);

//		return products;
		return null;
	}

	@Override
	public List<Product> searchProduct(String query) {
//		List<Product> products=productRepository.searchProduct(query);
//		return products;
		return null;
	}



	
	
	@Override
	public Page<Product> getAllProduct(String category, List<String>colors,
			List<String> sizes, Integer minPrice, Integer maxPrice,
			Integer minDiscount,String sort, String stock, Integer pageNumber, Integer pageSize ) {

//		Pageable pageable = PageRequest.of(pageNumber, pageSize);
//		List<Product> products = null;
//
//		if(category != null && category != "") {
//			System.out.println("category - "+category.split("/").length);
//			// dung cho admin
//			if(category.split("/").length == 1) {
//				products = productRepository.filterProducts3(category, minPrice, maxPrice, minDiscount, sort);
//			}
//			else {
//			try {
//				String lavelOne = category.split("/")[0];
//				String lavelTwo = category.split("/")[1];
//				String lavelThree = category.split("/")[2];
//
//				Category topLevel = categoryRepository.findByName(lavelOne);
//				Category secondLevel = categoryRepository.findByNameAndParantId(lavelTwo, topLevel.getId());
//				Category thirdLevel = categoryRepository.findByNameAndParantId(lavelThree, secondLevel.getId());
//
//				//System.out.println("top level - "+topLevel);
//				//System.out.println("second level - "+secondLevel);
//				System.out.println("third level - "+thirdLevel);
//				System.out.println(thirdLevel.getId() + "  " +  minPrice + "  " + maxPrice + "  " + minDiscount + "  " + sort);
//				products = productRepository.filterProducts(thirdLevel.getId(), minPrice, maxPrice, minDiscount, sort);
//			}
//			catch (Exception e) {
//				System.out.println("error - "+e);
//				System.out.println("loi roi em oi");
//			}
//			}
//
//		}
//		else{
//			products = productRepository.filterProducts2( minPrice, maxPrice, minDiscount, sort);
//		}
//
//		if (!colors.isEmpty()) {
//			products = products.stream()
//			        .filter(p -> colors.stream().anyMatch(c -> c.equalsIgnoreCase(p.getColor())))
//			        .collect(Collectors.toList());
//
//
//		}
//
//		if(stock!=null) {
//
//			if(stock.equals("in_stock")) {
//				products=products.stream().filter(p->p.getQuantity()>0).collect(Collectors.toList());
//			}// neu stock = in_stock thi lay nhung san pham co so luong >0
//			else if (stock.equals("out_of_stock")) {
//				products=products.stream().filter(p->p.getQuantity()<1).collect(Collectors.toList());
//			}// neu stock = out_of_stock thi lay nhung san pham co so luong <1
//
//
//		}
//		int startIndex = (int) pageable.getOffset();
//		int endIndex = Math.min(startIndex + pageable.getPageSize(), products.size());
//
//		List<Product> pageContent = products.subList(startIndex, endIndex);
//		Page<Product> filteredProducts = new PageImpl<>(pageContent, pageable, products.size());
//	    return filteredProducts; // If color list is empty, do nothing and return all products

		return null;
	}


	@Override
	public List<Product> recentlyAddedProduct() {
		
//		return productRepository.findTop10ByOrderByCreatedAtDesc();
		return null;
	}

}
