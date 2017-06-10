package com.homelibrary.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.homelibrary.domain.Book;
import com.homelibrary.domain.User;
import com.homelibrary.domain.UserRole;
import com.homelibrary.repository.UserRepository;
import com.homelibrary.repository.UserRoleRepository;
import com.homelibrary.service.UserService;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserRoleRepository userRoleRepository;

	public void insertUser(User user) {
		user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		List<UserRole> roles = new ArrayList<>();
		roles.add(userRoleRepository.findRoleByName("ROLE_USER"));
		user.setUserRoles(roles);
		userRepository.insertUser(user);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User getUserById(Integer userId) {
		User user = userRepository.getUserById(userId);
		List<UserRole> roles = user.getUserRoles();
		user.setUserRoles(roles);
		return user;
	}


	public List<UserRole> findUserRoles(Integer userId) {
		return userRepository.findRolesByUserId(userId);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void removeUser(User user) {
		userRepository.removeUser(user);
	}

	public User findUserByName(String userName) {
		return userRepository.findUserByName(userName);
	}

	public List<Book> getFavoriteUserBooks(Integer userId) {
		return userRepository.getFavoriteUserBooks(userId);
	}

	public void saveFavoriteUserBook(Book book, User user) {
		Integer userId = user.getUserId();
		List<Book> userBooks = userRepository.getFavoriteUserBooks(userId);
		userBooks.add(book);
		user.setFavouriteUsersBooks(userBooks);
		userRepository.saveFavoriteUserBook(user);
	}
	
	@PreAuthorize("#user.userName == authentication.name or hasRole('ROLE_ADMIN')")
	public void removeFavoriteUserBook(Book book, User user){
		Integer userId = user.getUserId();
		List<Book> userBooks = userRepository.getFavoriteUserBooks(userId);
		userBooks.remove(book);
		user.setFavouriteUsersBooks(userBooks);
		userRepository.saveFavoriteUserBook(user);
	}
}
