package com.homelibrary.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional
	public User getUserById(Integer userId) {
		User user = userRepository.getUserById(userId);
		List<UserRole> roles = user.getUserRoles();
		user.setUserRoles(roles);
		return user;
	}

	@Transactional
	public List<UserRole> findUserRoles(Integer userId) {
		return userRepository.findRolesByUserId(userId);
	}

	public void removeUserById(Integer userId) {
		userRepository.removeUserById(userId);
	}

	public User findUserByName(String userName) {
		return userRepository.findUserByName(userName);
	}
}
