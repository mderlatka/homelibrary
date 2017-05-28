package com.homelibrary.service;

import java.util.List;

import com.homelibrary.domain.User;
import com.homelibrary.domain.UserRole;

public interface UserService {

	void insertUser(User user);

	List<User> findAll();

	User getUserById(Integer userId);

	void removeUserById(Integer userId);

	List<UserRole> findUserRoles(Integer userId);

	User findUserByName(String userName);
}
