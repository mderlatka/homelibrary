package com.homelibrary.repository;

import java.util.List;

import com.homelibrary.domain.Author;

public interface AuthorRepository {

	void insertAuthor(Author author);

	List<Author> getAllAuthors();

	Author getAuthorById(Integer authorId);

	void removeAuthorById(Integer authorId);
}
