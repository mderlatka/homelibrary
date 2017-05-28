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

import com.homelibrary.domain.Author;
import com.homelibrary.dto.AuthorDTO;
import com.homelibrary.service.AuthorService;
import com.homelibrary.service.BookService;

@RequestMapping("/authors")
@Controller
public class AuthorController {

	@Autowired
	AuthorService authorService;
	@Autowired
	BookService bookService;

	@RequestMapping
	public String getListOfAuthors(Model model) {
		model.addAttribute("authors", authorService.getAllAuthors());
		return "authors";
	}

	@RequestMapping("/author")
	public String getAuthorById(@RequestParam("id") Integer id, Model model) {
		model.addAttribute("author", authorService.getAuthorById(id));
		return "author";
	}

	@RequestMapping(value = "/delete/author", method = RequestMethod.POST)
	public String deleteAuthor(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
		authorService.removeAuthorById(id);
		redirectAttributes.addFlashAttribute("deleteSuccess", true);
		return "redirect:/authors";
	}

	@RequestMapping(value = "/addAuthor", method = RequestMethod.GET)
	public String getAddNewAuthorForm(Model model) {
		AuthorDTO authorDto = new AuthorDTO();
		model.addAttribute("authorDto", authorDto);
		return "addAuthor";
	}

	@RequestMapping(value = "/addAuthor", method = RequestMethod.POST)
	public String processAddNewAuthorForm(@ModelAttribute("authorDto") @Valid AuthorDTO authorDto, BindingResult result,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {

		Author author = new Author();
		if (result.hasErrors()) {
			return "addAuthor";
		}
		author.setAuthorName(authorDto.getAuthorName());
		author.setAuthorSurname(authorDto.getAuthorSurname());
		authorService.insertAuthor(author);
		redirectAttributes.addFlashAttribute("insertSuccess", true);

		return "redirect:/authors";
	}

	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("authorSurname", "authorName");
	}

}
