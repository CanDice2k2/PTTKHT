package com.example.ecommerce.controller;

import java.util.List;

import com.example.ecommerce.request.UpdateProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.exception.ProductException;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.request.CreateProductRequest;
import com.example.ecommerce.response.ApiResponse;
import com.example.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/admin/products")
public class AdminProductController {

	private ProductService productService;

	public AdminProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("/")
	public ResponseEntity<Product> createProductHandler(@RequestBody CreateProductRequest req) throws ProductException{
		Product createdProduct = productService.createProduct(req);

		return new ResponseEntity<Product>(createdProduct,HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/{productId}/delete")
	public ResponseEntity<ApiResponse> deleteProductHandler(@PathVariable Long productId) throws ProductException{

		System.out.println("delete product controller .... ");
		String msg=productService.deleteProduct(productId);
		System.out.println("delete product controller .... msg "+msg);
		ApiResponse res=new ApiResponse(msg,true);

		return new ResponseEntity<ApiResponse>(res,HttpStatus.ACCEPTED);

	}

	@GetMapping("/all")
	public ResponseEntity<List<Product>> findAllProduct(){

		List<Product> products = productService.getAllProducts();

		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}

//	@GetMapping("/recent")
//	public ResponseEntity<List<Product>> recentlyAddedProduct(){
//
//		List<Product> products = productService.recentlyAddedProduct();
//
//		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
//	}


	@PutMapping("/update")
	public ResponseEntity<Product> updateProductHandler(@RequestBody UpdateProductRequest req) throws ProductException{
		System.out.println("create product controller .... " + req);
		Product updatedProduct=productService.updateProduct(req);

		return new ResponseEntity<Product>(updatedProduct,HttpStatus.OK);
	}

	@PostMapping("/creates")
	public ResponseEntity<ApiResponse> createMultipleProduct(@RequestBody CreateProductRequest[] reqs) throws ProductException{

		for(CreateProductRequest product:reqs) {
			productService.createProduct(product);
		}

		ApiResponse res=new ApiResponse("products created successfully",true);
		return new ResponseEntity<ApiResponse>(res,HttpStatus.ACCEPTED);
	}

}
