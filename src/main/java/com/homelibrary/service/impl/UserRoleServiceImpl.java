package com.homelibrary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homelibrary.domain.UserRole;
import com.homelibrary.repository.UserRoleRepository;
import com.homelibrary.service.UserRoleService;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	UserRoleRepository userRoleRepository;

	@Override
	public UserRole findRoleIdByName(String rolename) {
		return userRoleRepository.findRoleByName(rolename);
	}

	@Override
	public UserRole findRoleById(Integer roleId) {
		return userRoleRepository.findRoleById(roleId);
	}
}
