package com.homelibrary.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.homelibrary.domain.UserRole;
import com.homelibrary.repository.UserRoleRepository;

@Repository
public class UserRoleRepositoryImpl implements UserRoleRepository {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public UserRole findRoleByName(String rolename) {
		Query query = entityManager.createQuery("SELECT u FROM UserRole u WHERE u.rolename = :rolename", UserRole.class)
				.setParameter("rolename", rolename);
		UserRole userRole = (UserRole) query.getSingleResult();
		return userRole;
	}

	@Transactional
	public UserRole findRoleById(Integer roleId) {
		UserRole userRole = entityManager.find(UserRole.class, roleId);
		return userRole;
	}
	@Transactional
	public List<UserRole> findAllRoles(){
		Query query = entityManager.createQuery("SELECT u FROM UserRole u", UserRole.class);
		@SuppressWarnings("unchecked")
		List<UserRole> userRoles = query.getResultList();
		return userRoles;
	}

}
