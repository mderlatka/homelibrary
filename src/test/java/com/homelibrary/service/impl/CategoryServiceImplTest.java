package com.homelibrary.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.homelibrary.domain.Category;
import com.homelibrary.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/test-applicationContext.xml" })
@Transactional
public class CategoryServiceImplTest {

	@Autowired
	private CategoryService categoryService;

	@Test
	public void testInsertCategory() {
		Category category = new Category();
		category.setCategoryName("Bajki");
		categoryService.insertCategory(category);
		assertEquals("Bajki", categoryService.findCategoryByName(category.getCategoryName()).getCategoryName());
	}

	@Test
	public void testGetAllCategories() {
		assertEquals(7, categoryService.getAllCategories().size());
	}

	@Test
	public void testGetCategoryById() {
		Category category = new Category();
		String name = "Krymina³";
		category = categoryService.findCategoryByName(name);
		assertNotNull(categoryService.getCategoryById(category.getCategoryId()));
	}

	@Test
	public void testRemoveCategory() {
		String name = "Poezja";
		Category category = categoryService.findCategoryByName(name);
		categoryService.removeCategory(category);
		assertNull(categoryService.findCategoryByName(name));
	}

	@Test
	public void testFindCategoryByName() {
		String name = "Horror";
		assertNotNull(categoryService.findCategoryByName(name));
	}

}
