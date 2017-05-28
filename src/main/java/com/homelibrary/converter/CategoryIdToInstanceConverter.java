package com.homelibrary.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.homelibrary.domain.Category;
import com.homelibrary.service.CategoryService;

public class CategoryIdToInstanceConverter implements Converter<String, Category> {

	@Autowired
	CategoryService categoryService;

	@Override
	public Category convert(String categoryIdStr) {
		return categoryService.getCategoryById(Integer.valueOf(categoryIdStr));
	}

}
