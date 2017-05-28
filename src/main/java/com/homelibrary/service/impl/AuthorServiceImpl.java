package com.homelibrary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homelibrary.domain.Author;
import com.homelibrary.repository.AuthorRepository;
import com.homelibrary.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository authorRepository;

	public void insertAuthor(Author author) {
		authorRepository.insertAuthor(author);
	}

	public List<Author> getAllAuthors() {
		return authorRepository.getAllAuthors();
	}

	public Author getAuthorById(Integer authorId) {
		return authorRepository.getAuthorById(authorId);
	}

	public void removeAuthorById(Integer authorId) {
		authorRepository.removeAuthorById(authorId);
	}

}
