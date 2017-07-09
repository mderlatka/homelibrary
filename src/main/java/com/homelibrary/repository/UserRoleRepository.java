package com.homelibrary.repository;

import java.util.List;

import com.homelibrary.domain.UserRole;

public interface UserRoleRepository {

	UserRole findRoleByName(String rolename);

	UserRole findRoleById(Integer roleId);
	
	List<UserRole> findAllRoles();
}
