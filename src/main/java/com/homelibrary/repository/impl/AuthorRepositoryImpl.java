package com.homelibrary.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.homelibrary.domain.Author;
import com.homelibrary.repository.AuthorRepository;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public void insertAuthor(Author author) {
		author.setAuthorName(author.getAuthorName());
		author.setAuthorSurname(author.getAuthorSurname());
		author = entityManager.merge(author);
	}

	@Transactional
	public List<Author> getAllAuthors() {
		Query query = entityManager.createQuery("Select a FROM Author a", Author.class);
		@SuppressWarnings("unchecked")
		List<Author> listOfAuthors = query.getResultList();
		return listOfAuthors;
	}

	@Transactional
	public Author getAuthorById(Integer authorId) {
		Author author = entityManager.find(Author.class, authorId);
		return author;
	}

	@Transactional
	public void removeAuthorById(Integer authorId) {
		Author author = entityManager.find(Author.class, authorId);
		entityManager.remove(author);
	}

}
