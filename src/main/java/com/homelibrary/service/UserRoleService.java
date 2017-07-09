package com.homelibrary.service;

import java.util.List;

import com.homelibrary.domain.UserRole;

public interface UserRoleService {

	UserRole findRoleByName(String rolename);

	UserRole findRoleById(Integer roleId);
	
	List<UserRole> findAllRoles();
}
