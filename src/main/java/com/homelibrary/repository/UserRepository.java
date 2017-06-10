package com.homelibrary.repository;

import java.util.List;

import com.homelibrary.domain.Book;
import com.homelibrary.domain.User;
import com.homelibrary.domain.UserRole;

public interface UserRepository {

	void insertUser(User user);

	User getUserById(Integer userId);

	List<User> findAll();

	void removeUser(User user);

	List<UserRole> findRolesByUserId(Integer userId);

	User findUserByName(String userName);
	
	List<Book> getFavoriteUserBooks(Integer userId);
	
	void saveFavoriteUserBook(User user);
}
