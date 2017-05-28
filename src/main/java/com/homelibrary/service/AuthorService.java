package com.homelibrary.service;

import java.util.List;

import com.homelibrary.domain.Author;

public interface AuthorService {

	void insertAuthor(Author author);

	List<Author> getAllAuthors();

	Author getAuthorById(Integer authorId);

	void removeAuthorById(Integer authorId);
}
