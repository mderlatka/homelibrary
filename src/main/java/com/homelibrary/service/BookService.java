package com.homelibrary.service;

import java.util.List;

import com.homelibrary.domain.Author;
import com.homelibrary.domain.Book;
import com.homelibrary.domain.Category;

public interface BookService {

	List<Book> getAllBooks();

	Book getBookById(Integer bookId);

	void insertBook(Book book);
	
	void updateBook(Book book);

	void removeBook(Book book);

	List<Book> getBooksByAuthor(Author author);

	List<Book> getBooksByCategory(Category category);

	List<Book> getLatestBooks();
	
	Book getBookByTitle(String title);
}
