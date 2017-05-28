package com.homelibrary.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.homelibrary.domain.Author;
import com.homelibrary.service.AuthorService;

public class AuthorIdToInstanceConverter implements Converter<String, Author> {

	@Autowired
	AuthorService authorService;

	@Override
	public Author convert(String authorIdStr) {
		return authorService.getAuthorById(Integer.valueOf(authorIdStr));
	}
}
