package com.homelibrary.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.homelibrary.service.UserRoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/test-applicationContext.xml"})
@Transactional
public class UserRoleServiceImplTest {
	
	@Autowired
	private UserRoleService userRoleService;

	@Test
	public void testFindRoleByName() {
		String name = "ROLE_ADMIN";
		assertEquals(name, userRoleService.findRoleByName(name).getRolename());
	}

	@Test
	public void testFindRoleById() {
		String name = "ROLE_USER";
		Integer roleId = userRoleService.findRoleByName(name).getRoleId();
		assertEquals(name, userRoleService.findRoleById(roleId).getRolename());
	}

	@Test
	public void testFindAllRoles() {
		assertEquals(2, userRoleService.findAllRoles().size());
	}

}
