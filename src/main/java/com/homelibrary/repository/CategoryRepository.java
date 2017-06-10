package com.homelibrary.repository;

import java.util.List;

import com.homelibrary.domain.Category;

public interface CategoryRepository {

	void insertCategory(Category category);

	List<Category> getAllCategories();

	Category getCategoryById(Integer categoryId);

	void removeCategory(Category category);
	
	Category findCategoryByName(String categoryName);
}
