package com.homelibrary.service;

import com.homelibrary.domain.UserRole;

public interface UserRoleService {

	UserRole findRoleIdByName(String rolename);

	UserRole findRoleById(Integer roleId);
}
