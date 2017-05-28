package com.homelibrary.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class CategoryDTO {

	@NotEmpty(message = "{categoryDto.name.validation}")
	private String CategoryName;

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
}
