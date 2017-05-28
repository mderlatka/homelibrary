package com.homelibrary.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.homelibrary.domain.UserRole;
import com.homelibrary.service.UserRoleService;

public class UserRolesIdToInstanceConverter implements Converter<String, UserRole> {

	@Autowired
	UserRoleService userRoleService;

	public UserRole convert(String userRoleIdStr) {
		return userRoleService.findRoleById(Integer.valueOf(userRoleIdStr));
	}

}
