package com.homelibrary.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.homelibrary.domain.Author;
import com.homelibrary.service.AuthorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/test-applicationContext.xml" })
@Transactional
public class AuthorServiceImplTest {

	@Autowired
	private AuthorService authorService;
	
	@Test
	public void testInsertAuthor() {
		Author author = new Author();
		author.setAuthorName("Juliusz");
		author.setAuthorSurname("S³owacki");
		authorService.insertAuthor(author);
		assertEquals("Juliusz", authorService.findAuthorByName(author.getAuthorName(), author.getAuthorSurname()).getAuthorName());
	}

	@Test
	public void testGetAllAuthors() {
		
		assertEquals(11, authorService.getAllAuthors().size());
	}

	@Test
	public void testGetAuthorById() {
		Author author = new Author();
		author = authorService.findAuthorByName("Haruki", "Murakami");
		assertNotNull(authorService.getAuthorById(author.getAuthorId()));
	}

	@Test
	public void testRemoveAuthor() {
		Author author = new Author();
		String name = "Jacek";
		String surname = "Dukaj";
		author = authorService.findAuthorByName(name, surname);
		authorService.removeAuthor(author);
		assertNull(authorService.findAuthorByName(name, surname));
	}

	@Test
	public void testFindAuthorByName() {
		List<Author> authors = authorService.getAllAuthors();
		Author author = new Author();
		author = authors.get(5);
		String name = author.getAuthorName();
		String surname = author.getAuthorSurname();
		assertNotNull(authorService.findAuthorByName(name, surname));
	}

}
