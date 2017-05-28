package com.homelibrary.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.homelibrary.domain.Author;
import com.homelibrary.domain.Book;
import com.homelibrary.domain.Category;
import com.homelibrary.repository.BookRepository;

@Repository
public class BookRepositoryImpl implements BookRepository {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public void insertBook(Book book) {

		book.setTitle(book.getTitle());
		book.setAuthor(book.getAuthor());
		book.setReleaseDate(book.getReleaseDate());
		book.setCategory(book.getCategory());
		book.setNumOfPages(book.getNumOfPages());
		book.setDescription(book.getDescription());
		book = entityManager.merge(book);
	}

	@Transactional
	public List<Book> getAllBooks() {

		Query query = entityManager.createQuery("SELECT b FROM Book b", Book.class);
		@SuppressWarnings("unchecked")
		List<Book> listOfBooks = query.getResultList();

		return listOfBooks;

	}

	@Transactional
	public List<Book> getBookByAuthor(Author author) {
		Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.author=?", Book.class).setParameter(1,
				author);
		@SuppressWarnings("unchecked")
		List<Book> booksOfAuthor = query.getResultList();

		return booksOfAuthor;
	}

	@Transactional
	public List<Book> getBooksByCategory(Category category) {
		Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.category=?", Book.class).setParameter(1,
				category);
		@SuppressWarnings("unchecked")
		List<Book> booksOfCategory = query.getResultList();

		return booksOfCategory;
	}

	@Transactional
	public Book getBookById(Integer bookId) {

		Book book = entityManager.find(Book.class, bookId);
		return book;// TODO throw Exception
	}

	@Transactional
	public void removeBookById(Integer bookId) {
		Book book = entityManager.find(Book.class, bookId);
		if (book != null) {
			entityManager.remove(book);
		}

	}

}
