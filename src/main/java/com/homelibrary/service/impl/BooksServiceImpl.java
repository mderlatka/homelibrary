package com.homelibrary.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.homelibrary.domain.Author;
import com.homelibrary.domain.Book;
import com.homelibrary.domain.Category;
import com.homelibrary.repository.BookRepository;
import com.homelibrary.service.BookService;

@Service
public class BooksServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks() {
		return bookRepository.getAllBooks();
	}

	public Book getBookById(Integer bookId) {
		return bookRepository.getBookById(bookId);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void insertBook(Book book) {
		bookRepository.insertBook(book);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void updateBook(Book book) {
		bookRepository.updateBook(book);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void removeBook(Book book) {
		bookRepository.removeBook(book);
	}

	public List<Book> getBookByAuthor(Author author) {
		return bookRepository.getBookByAuthor(author);
	}

	public List<Book> getBooksByCategory(Category category) {
		return bookRepository.getBooksByCategory(category);
	}

	public List<Book> getLatestBooks() {
		List<Book> books = bookRepository.getAllBooks();
		List<Book> latestBooks = new ArrayList<>();
		if (!books.isEmpty()) {
			if (books.size() > 3) {
				for(int i=0; i<3; i++){
					latestBooks.add(books.get(books.size()-(i+1)));
				}
			} else {
				for (Book book : books)
					latestBooks.add(book);
			}
		}
		return latestBooks;
	}

}
