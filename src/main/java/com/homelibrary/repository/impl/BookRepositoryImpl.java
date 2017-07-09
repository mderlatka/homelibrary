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

		book = entityManager.merge(book);
	}

	@Transactional
	public void updateBook(Book book) {

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
	public List<Book> getBooksByAuthor(Author author) {
		Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.author=?1", Book.class).setParameter(1,
				author);
		@SuppressWarnings("unchecked")
		List<Book> booksOfAuthor = query.getResultList();

		return booksOfAuthor;
	}

	@Transactional
	public List<Book> getBooksByCategory(Category category) {
		Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.category=?1", Book.class).setParameter(1,
				category);
		@SuppressWarnings("unchecked")
		List<Book> booksOfCategory = query.getResultList();

		return booksOfCategory;
	}

	@Transactional
	public Book getBookById(Integer bookId) {

		Book book = entityManager.find(Book.class, bookId);
		return book;
	}

	@Transactional
	public void removeBook(Book book) {
		if (book != null) {
			entityManager.remove(entityManager.merge(book));
		}
	}

	@Transactional
	public Book getBookByTitle(String title) {
		Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.title = :title", Book.class).setParameter("title", title);
		@SuppressWarnings("unchecked")
		List<Book> books = query.getResultList();
		if(!books.isEmpty()) {
			return books.get(0);
		}else{
			return null;
		}
	}

}
