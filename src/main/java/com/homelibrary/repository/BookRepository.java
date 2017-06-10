package com.homelibrary.repository;

import java.util.List;

import com.homelibrary.domain.Author;
import com.homelibrary.domain.Book;
import com.homelibrary.domain.Category;

public interface BookRepository {

	void insertBook(Book book);

	List<Book> getAllBooks();

	Book getBookById(Integer bookId);

	void removeBook(Book book);

	List<Book> getBookByAuthor(Author author);

	List<Book> getBooksByCategory(Category category);
}
