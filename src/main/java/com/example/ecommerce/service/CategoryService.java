package com.example.ecommerce.service;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.request.CreateCategoryRequest;
import com.example.ecommerce.request.UpdateCategoryRequest;

import java.util.List;

public interface CategoryService {

    public Category createCategory(CreateCategoryRequest req) ;

	public String deleteCategory(Long CategoryId) ;

	public Category updateCategory(UpdateCategoryRequest req);

	public List<Category> getAllCategory();

	// for user and admin both
	public Category findCategoryById(Long id) ;

	public List<Category> searchCategory(String query);
}
