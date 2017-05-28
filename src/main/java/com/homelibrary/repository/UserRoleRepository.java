package com.homelibrary.repository;

import com.homelibrary.domain.UserRole;

public interface UserRoleRepository {

	UserRole findRoleByName(String rolename);

	UserRole findRoleById(Integer roleId);
}
