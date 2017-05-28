package com.homelibrary.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	public void insertBook(Book book) {
		bookRepository.insertBook(book);
	}

	public void removeBookById(Integer bookId) {
		bookRepository.removeBookById(bookId);
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
			for (int i = 0; i < 3; i++) {
				latestBooks.add(books.get(books.size() - (i + 1)));
			}
		}
		return latestBooks;
	}

}
