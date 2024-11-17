package com.example.ecommerce.controller;


import com.example.ecommerce.model.Category;
import com.example.ecommerce.request.CreateCategoryRequest;
import com.example.ecommerce.request.UpdateCategoryRequest;
import com.example.ecommerce.service.CategoryService;
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
import com.example.ecommerce.response.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/api/admin/categories")
public class AdminCategoryController {

	private CategoryService categoryService;

	public AdminCategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping("/")
	public ResponseEntity<Category> createCategoryHandler(@RequestBody CreateCategoryRequest req){
		Category createdCategory = categoryService.createCategory(req);

		return new ResponseEntity<Category>(createdCategory, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/{CategoryId}/delete")
	public ResponseEntity<ApiResponse> deleteCategoryHandler(@PathVariable Long CategoryId){

		System.out.println("delete Category controller .... ");
		String msg=categoryService.deleteCategory(CategoryId);
		System.out.println("delete Category controller .... msg "+msg);
		ApiResponse res=new ApiResponse(msg,true);

		return new ResponseEntity<ApiResponse>(res,HttpStatus.ACCEPTED);

	}

	@GetMapping("/all")
	public ResponseEntity<List<Category>> findAllCategory(){

		List<Category> categories = categoryService.getAllCategory();

		return new ResponseEntity<List<Category>>(categories,HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Category> updateCategoryHandler(@RequestBody UpdateCategoryRequest req){
		System.out.println("create Category controller .... " + req);
		Category updatedCategory=categoryService.updateCategory(req);

		return new ResponseEntity<Category>(updatedCategory,HttpStatus.OK);
	}

}