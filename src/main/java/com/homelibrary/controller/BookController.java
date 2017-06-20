package com.homelibrary.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.homelibrary.domain.Author;
import com.homelibrary.domain.Book;
import com.homelibrary.domain.Category;
import com.homelibrary.dto.BookDTO;
import com.homelibrary.service.AuthorService;
import com.homelibrary.service.BookService;
import com.homelibrary.service.CategoryService;

@RequestMapping("/books")
@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;
	@Autowired
	private CategoryService categoryService;

	@RequestMapping
	public String list(Model model) {
		model.addAttribute("books", bookService.getAllBooks());
		return "books";
	}

	@RequestMapping("/all")
	public String allProducts(Model model) {
		model.addAttribute("books", bookService.getAllBooks());
		return "books";
	}

	@RequestMapping("/latest")
	public String getLatestBooks(Model model) {
		List<Book> latestBooks = bookService.getLatestBooks();
		if (latestBooks.isEmpty()) {
			model.addAttribute("emptyLatestBooksList", true);
		}
		model.addAttribute("latestBooks", latestBooks);
		return "latestBooks";
	}

	@RequestMapping("/book")
	public String getBookById(@RequestParam("id") Integer id, Model model) {
		model.addAttribute("book", bookService.getBookById(id));
		return "book";
	}

	@RequestMapping("/author")
	public String getAllBooksOfAuthor(@RequestParam("id") Integer authorId, Model model) {
		Author author = new Author();
		author = authorService.getAuthorById(authorId);
		List<Book> authorBooks = bookService.getBookByAuthor(author);
		if (authorBooks.isEmpty()) {
			model.addAttribute("emptyListOfAuthorBooks", true);
		}
		model.addAttribute("books", authorBooks);
		return "books";
	}

	@RequestMapping("/categories/{categoryId}")
	public String getAllBooksOfCategory(Model model, @PathVariable("categoryId") Integer categoryId) {
		Category category = new Category();
		category = categoryService.getCategoryById(categoryId);
		List<Book> categoryBooks = bookService.getBooksByCategory(category);
		model.addAttribute("books", categoryBooks);
		if (categoryBooks.isEmpty()) {
			model.addAttribute("emptyListOfCategoryBooks", true);
		}
		return "books";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewBookForm(Model model) {
		BookDTO bookDto = new BookDTO();

		model.addAttribute("bookDto", bookDto);
		model.addAttribute("authors", authorService.getAllAuthors());
		model.addAttribute("categories", categoryService.getAllCategories());
		return "addBook";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewBookForm(@ModelAttribute("bookDto") @Valid BookDTO bookDto, BindingResult result,
			Model model, RedirectAttributes redirectAttributes) throws ParseException {

		Book book = new Book();

		if (result.hasErrors()) {
			if (bookDto.getAuthor() != null) {
				Author author = bookDto.getAuthor();
				model.addAttribute("author", authorService.getAuthorById(author.getAuthorId()));
			}
			if (bookDto.getCategory() != null) {
				Category category = bookDto.getCategory();
				model.addAttribute("category", categoryService.getCategoryById(category.getCategoryId()));
			}
			model.addAttribute("authors", authorService.getAllAuthors());
			model.addAttribute("categories", categoryService.getAllCategories());
			return "addBook";
		}

		MultipartFile bookImage = bookDto.getBookImage();

		if (bookImage != null && !bookImage.isEmpty()) {
			try {
				book.setBookImage(bookImage.getBytes());
			} catch (Exception e) {
				throw new RuntimeException("Niepowodzenie podczas próby zapisu obrazka produktu", e);
			}
		}
		book.setTitle(bookDto.getTitle());

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		book.setReleaseDate(dateFormat.parse(bookDto.getReleaseDate()));
		book.setCategory(bookDto.getCategory());
		book.setNumOfPages(bookDto.getNumOfPages());
		book.setDescription(bookDto.getDescription());
		book.setAuthor(bookDto.getAuthor());
		bookService.insertBook(book);
		redirectAttributes.addFlashAttribute("addSuccess", true);
		return "redirect:/books";
	}// end of processAddNewBookForm

	@RequestMapping(value = "/update/book", method = RequestMethod.GET)
	public String getUpdateBookForm(@RequestParam("id") Integer bookId, Model model) {

		Book book = bookService.getBookById(bookId);

		Author bookAuthor = book.getAuthor();
		model.addAttribute("author", authorService.getAuthorById(bookAuthor.getAuthorId()));
		model.addAttribute("authors", authorService.getAllAuthors());

		Category categoryBookAuthor = book.getCategory();
		model.addAttribute("category", categoryService.getCategoryById(categoryBookAuthor.getCategoryId()));
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("book", book);

		return "updateBookForm";
	}// end of getUpdateBookForm

	@RequestMapping(value = "/update/book", method = RequestMethod.POST)
	public String processUpdateBookForm(@RequestParam("id") Integer bookId,
			@ModelAttribute("bookDto") @Valid BookDTO bookDto, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) throws ParseException {
		Book book = bookService.getBookById(bookId);

		if (result.hasErrors()) {
			if (bookDto.getAuthor() != null) {
				Author author = bookDto.getAuthor();
				model.addAttribute("author", authorService.getAuthorById(author.getAuthorId()));
			}
			if (bookDto.getCategory() != null) {
				Category category = bookDto.getCategory();
				model.addAttribute("category", categoryService.getCategoryById(category.getCategoryId()));
			}
			model.addAttribute("authors", authorService.getAllAuthors());
			model.addAttribute("categories", categoryService.getAllCategories());
			return "addBook";
		}

		MultipartFile bookImage = bookDto.getBookImage();

		if (bookImage != null && !bookImage.isEmpty()) {
			try {
				book.setBookImage(bookImage.getBytes());
			} catch (Exception e) {
				throw new RuntimeException("Niepowodzenie podczas próby zapisu obrazka produktu", e);
			}
		}
		book.setTitle(bookDto.getTitle());

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		book.setReleaseDate(dateFormat.parse(bookDto.getReleaseDate()));
		book.setCategory(bookDto.getCategory());
		book.setNumOfPages(bookDto.getNumOfPages());
		book.setDescription(bookDto.getDescription());
		book.setAuthor(bookDto.getAuthor());
		bookService.insertBook(book);
		redirectAttributes.addFlashAttribute("addSuccess", true);
		return "redirect:/books/book?id=" + book.getBookId();
	}// end of processUpdateBookForm

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public String deleteBook(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
		bookService.removeBook(bookService.getBookById(id));
		redirectAttributes.addFlashAttribute("deleteSuccess", true);
		return "redirect:/books";
	}

	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("author", "title", "releaseDate", "category", "numOfPages", "description", "bookImage",
				"id");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		dateFormat.setLenient(false);
		CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, orderDateEditor);
	}

}
