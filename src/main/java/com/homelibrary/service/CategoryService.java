package com.homelibrary.service;

import java.util.List;

import com.homelibrary.domain.Category;

public interface CategoryService {

	void insertCategory(Category category);

	List<Category> getAllCategories();

	Category getCategoryById(Integer categoryId);

	void removeCategory(Category category);
	
	Category findCategoryByName(String categoryName);
}
