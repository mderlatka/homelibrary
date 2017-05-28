package com.homelibrary.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.homelibrary.domain.Category;
import com.homelibrary.repository.CategoryRepository;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public void insertCategory(Category category) {
		category.setCategoryName(category.getCategoryName());
		category = entityManager.merge(category);
	}

	@Transactional
	public List<Category> getAllCategories() {
		Query query = entityManager.createQuery("Select c FROM Category c", Category.class);
		@SuppressWarnings("unchecked")
		List<Category> listOfCategories = query.getResultList();

		return listOfCategories;
	}

	@Transactional
	public Category getCategoryById(Integer categoryId) {
		Category category = entityManager.find(Category.class, categoryId);
		return category;
	}

	@Transactional
	public void removeAuthorById(Integer categoryId) {
		Category category = entityManager.find(Category.class, categoryId);
		entityManager.remove(category);
	}
}
