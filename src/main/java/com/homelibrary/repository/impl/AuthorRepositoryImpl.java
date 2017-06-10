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
	public void removeAuthor(Author author) {
		entityManager.remove(entityManager.merge(author));
	}

	@Transactional
	public Author findAuthorByName(String authorName, String authorSurname) {

		Query query = entityManager
				.createQuery(
						"SELECT a FROM Author a WHERE a.authorName =:authorName AND a.authorSurname =:authorSurname ",
						Author.class)
				.setParameter("authorSurname", authorSurname).setParameter("authorName", authorName);
		@SuppressWarnings("unchecked")
		List<Author> author = query.getResultList();
		if (author.isEmpty()) {
			return null;
		} else {
			return author.get(0);
		}
	}
}
