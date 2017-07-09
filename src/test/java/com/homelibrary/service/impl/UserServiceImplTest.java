package com.homelibrary.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.homelibrary.domain.Book;
import com.homelibrary.domain.User;
import com.homelibrary.domain.UserRole;
import com.homelibrary.service.BookService;
import com.homelibrary.service.UserRoleService;
import com.homelibrary.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/test-applicationContext.xml"})
@Transactional
public class UserServiceImplTest {
	
	@Autowired
	private UserService userService;
	@Autowired 
	UserRoleService userRoleService;
	@Autowired
	BookService bookService;

	@Test
	public void testInsertUser() {
		User user = new User();
		user.setUserName("Jarek");
		user.setEmail("jarek@gmail.com");
		user.setPassword("jarek123");
		user.setEnabled(true);
		List<UserRole> roles = new ArrayList<>();
		roles.add(userRoleService.findRoleByName("ROLE_USER"));
		user.setUserRoles(roles);
		userService.insertUser(user);
		assertEquals("Jarek", userService.findUserByName(user.getUserName()).getUserName());
	}

	@Test
	public void testFindAll() {
		assertEquals(2, userService.findAll().size());
	}

	@Test
	public void testGetUserById() {
		User user = new User();
		List<User> users = userService.findAll();
		user = users.get(1);
		assertNotNull(userService.getUserById(user.getUserId()));
	}

	@Test
	public void testFindUserRoles() {
		User user = new User();
		user = userService.findUserByName("Kaja");
		assertEquals(1, userService.findUserRoles(user.getUserId()).size());
	}

	@Test
	public void testRemoveUser() {
		User user = new User();
		List<User> users = userService.findAll();
		user = users.get(1);
		Integer userId = user.getUserId();
		userService.removeUser(user);
		assertNull(userService.getUserById(userId));
	}

	@Test
	public void testFindUserByName() {
		User user = new User();
		List<User> users = userService.findAll();
		user = users.get(1);
		String name = user.getUserName();
		assertEquals(name, userService.findUserByName(name).getUserName());
	}

	@Test
	public void testGetFavoriteUserBooks() {
		User user = userService.findUserByName("Marcin");
		assertEquals(1, userService.getFavoriteUserBooks(user.getUserId()).size());
	}

	@Test
	public void testSaveFavoriteUserBook() {
		User user = userService.findAll().get(0);
		Book book = bookService.getAllBooks().get(0);
		userService.saveFavoriteUserBook(book, user);
		List<Book> userBooks = userService.getFavoriteUserBooks(user.getUserId());
		assertTrue(userBooks.contains(book));
	}

	@Test
	public void testRemoveFavoriteUserBook() {
		User user = userService.findAll().get(0);
		Book book = userService.getFavoriteUserBooks(user.getUserId()).get(0);
		userService.removeFavoriteUserBook(book, user);
		List<Book> userBooks = userService.getFavoriteUserBooks(user.getUserId());
		assertFalse(userBooks.contains(book));
	}

}
