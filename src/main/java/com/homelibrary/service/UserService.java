package com.homelibrary.service;

import java.util.List;

import com.homelibrary.domain.Book;
import com.homelibrary.domain.User;
import com.homelibrary.domain.UserRole;

public interface UserService {

	void insertUser(User user);

	List<User> findAll();

	User getUserById(Integer userId);

	void removeUser(User user);

	List<UserRole> findUserRoles(Integer userId);

	User findUserByName(String userName);
	
	List<Book> getFavoriteUserBooks(Integer userId);
	
	void saveFavoriteUserBook(Book book, User user);
	
	void removeFavoriteUserBook(Book book, User user);
}
