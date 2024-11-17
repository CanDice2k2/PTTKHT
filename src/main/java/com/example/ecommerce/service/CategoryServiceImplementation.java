package com.example.ecommerce.service;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.request.CreateCategoryRequest;
import com.example.ecommerce.request.UpdateCategoryRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImplementation implements CategoryService{
    private CategoryRepository categoryRepository;


	public CategoryServiceImplementation(CategoryRepository categoryRepository) {
		this.categoryRepository=categoryRepository;
	}


	@Override
    public Category createCategory(CreateCategoryRequest req) {

        Category category = new Category();
        category.setName(req.getName());

        return categoryRepository.save(category);
    }

	@Override
    public String deleteCategory(Long categoryId) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);

        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            categoryRepository.delete(category);

            return "Category with ID " + categoryId + " has been successfully deleted.";
        } else {
            return "Category with ID " + categoryId + " not found.";
        }
    }

	@Override
    public Category updateCategory(UpdateCategoryRequest req) {
        Optional<Category> categoryOptional = categoryRepository.findById(req.getId());

        if (!categoryOptional.isPresent()) {
            throw new RuntimeException("Category with ID " + req.getId() + " not found.");
        }

        Category category = categoryOptional.get();

        category.setName(req.getName());

        return categoryRepository.save(category);
    }

	@Override
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category with ID " + id + " not found."));
    }



	@Override
	public List<Category> searchCategory(String query) {
		List<Category> categories =categoryRepository.searchCategory(query);
		return categories;
	}
}
