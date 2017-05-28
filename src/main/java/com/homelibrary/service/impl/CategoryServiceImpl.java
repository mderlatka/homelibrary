package com.homelibrary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homelibrary.domain.Category;
import com.homelibrary.repository.CategoryRepository;
import com.homelibrary.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public void insertCategory(Category category) {
		categoryRepository.insertCategory(category);
	}

	public List<Category> getAllCategories() {
		return categoryRepository.getAllCategories();
	}

	public Category getCategoryById(Integer categoryId) {
		return categoryRepository.getCategoryById(categoryId);
	}

	public void removeCategoryById(Integer categoryId) {
		categoryRepository.removeAuthorById(categoryId);
	}
}
