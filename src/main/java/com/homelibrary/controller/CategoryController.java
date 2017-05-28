package com.homelibrary.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.homelibrary.domain.Category;
import com.homelibrary.dto.CategoryDTO;
import com.homelibrary.service.BookService;
import com.homelibrary.service.CategoryService;

@RequestMapping("/categories")
@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	BookService bookService;

	@RequestMapping
	public String getListOfCategories(Model model) {
		model.addAttribute("categories", categoryService.getAllCategories());
		return "categories";
	}

	@RequestMapping("/delete/category")
	public String deleteCategory(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
		categoryService.removeCategoryById(id);
		redirectAttributes.addFlashAttribute("deleteCatSuccess", true);
		return "redirect:/categories";
	}

	@RequestMapping(value = "/addCategory", method = RequestMethod.GET)
	public String getAddNewCategoryForm(Model model) {
		CategoryDTO categoryDto = new CategoryDTO();
		model.addAttribute("categoryDto", categoryDto);
		return "addCategory";
	}

	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public String processAddNewCategoryForm(@ModelAttribute("categoryDto") @Valid CategoryDTO categoryDto,
			BindingResult result, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		Category category = new Category();

		if (result.hasErrors()) {
			return "addCategory";
		}
		category.setCategoryName(categoryDto.getCategoryName());
		categoryService.insertCategory(category);
		redirectAttributes.addFlashAttribute("addCatSuccess", true);
		return "redirect:/categories";
	}

	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("categoryName");
	}
}
