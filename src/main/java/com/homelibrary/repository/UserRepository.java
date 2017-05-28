package com.homelibrary.repository;

import java.util.List;

import com.homelibrary.domain.User;
import com.homelibrary.domain.UserRole;

public interface UserRepository {

	void insertUser(User user);

	User getUserById(Integer userId);

	List<User> findAll();

	void removeUserById(Integer userId);

	List<UserRole> findRolesByUserId(Integer userId);

	User findUserByName(String userName);
}
