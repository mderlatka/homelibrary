package com.homelibrary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.homelibrary.domain.Category;
import com.homelibrary.repository.CategoryRepository;
import com.homelibrary.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void insertCategory(Category category) {
		categoryRepository.insertCategory(category);
	}

	public List<Category> getAllCategories() {
		return categoryRepository.getAllCategories();
	}

	public Category getCategoryById(Integer categoryId) {
		return categoryRepository.getCategoryById(categoryId);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void removeCategory(Category category) {
		categoryRepository.removeCategory(category);
	}
	
	public Category findCategoryByName(String categoryName){
		return categoryRepository.findCategoryByName(categoryName);
	}
}
