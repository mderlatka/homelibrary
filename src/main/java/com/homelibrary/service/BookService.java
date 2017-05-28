package com.homelibrary.service;

import java.util.List;

import com.homelibrary.domain.Author;
import com.homelibrary.domain.Book;
import com.homelibrary.domain.Category;

public interface BookService {

	List<Book> getAllBooks();

	Book getBookById(Integer bookId);

	void insertBook(Book book);

	void removeBookById(Integer bookId);

	List<Book> getBookByAuthor(Author author);

	List<Book> getBooksByCategory(Category category);

	List<Book> getLatestBooks();
}