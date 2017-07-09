package com.homelibrary.service.impl;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.homelibrary.domain.Author;
import com.homelibrary.domain.Book;
import com.homelibrary.domain.Category;
import com.homelibrary.service.AuthorService;
import com.homelibrary.service.BookService;
import com.homelibrary.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/test-applicationContext.xml"})
@Transactional
public class BooksServiceImplTest {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;
	@Autowired
	private CategoryService categoryService;

	@Test
	public void testGetAllBooks() {
		List<Book> listOfBooks = bookService.getAllBooks();
		assertEquals(5, listOfBooks.size());
	}

	@Test
	public void testGetBookById() {
		assertEquals("Taksim", bookService.getBookById(16).getTitle());
	}

	@Test
	public void testInsertBook() throws ParseException {
		Book book = new Book();
		book.setTitle("Lód");
		book.setAuthor(authorService.findAuthorByName("Jacek", "Dukaj"));
		book.setCategory(categoryService.findCategoryByName("Fantastyka"));
		book.setNumOfPages(1045);
		book.setDescription("adsncfvudjnf");
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		book.setReleaseDate(sdf.parse("03.11.2006"));
		bookService.insertBook(book);
		assertEquals("Lód", bookService.getBookByTitle(book.getTitle()).getTitle());
	}

	@Test
	public void testUpdateBook() {
		String newTitle = "Taksim1";
		Book book = new Book();
		book = bookService.getBookByTitle("Taksim");
		Integer id = book.getBookId();
		book.setTitle(newTitle);
		bookService.updateBook(book);
		assertEquals(newTitle, bookService.getBookById(id).getTitle());
	}

	@Test
	public void testRemoveBook() {
		Book book = new Book();
		String title = "Taksim";
		book = bookService.getBookByTitle(title);
		Integer id = book.getBookId();
		bookService.removeBook(book);
		assertNull(bookService.getBookById(id));
	}

	@Test
	public void testGetBooksByAuthor() {
		Author author = authorService.getAllAuthors().get(0);
		assertEquals(1, bookService.getBooksByAuthor(author).size());
		
	}

	@Test
	public void testGetBooksByCategory() {
		Category category = categoryService.findCategoryByName("Literatura polska");
		assertEquals(2, bookService.getBooksByCategory(category).size());
		
	}

	@Test
	public void testGetLatestBooks() {
		assertEquals(3, bookService.getLatestBooks().size());
	}

}
