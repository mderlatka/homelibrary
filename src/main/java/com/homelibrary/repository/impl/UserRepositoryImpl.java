package com.homelibrary.repository.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.homelibrary.domain.Book;
import com.homelibrary.domain.User;
import com.homelibrary.domain.UserRole;
import com.homelibrary.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public void insertUser(User user) {

		user = entityManager.merge(user);
	}

	@Transactional
	public List<User> findAll() {

		Query query = entityManager.createQuery("SELECT u FROM User u", User.class);
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		return users;
	}

	@Transactional
	public User getUserById(Integer userId) {

		User user = entityManager.find(User.class, userId);
		return user;
	}

	@Transactional
	public List<UserRole> findRolesByUserId(Integer userId) {
		Query query = entityManager
				.createQuery("SELECT ur FROM User u JOIN u.userRoles ur WHERE u.userId = ?", UserRole.class)
				.setParameter(1, userId);
		@SuppressWarnings("unchecked")
		List<UserRole> roles = query.getResultList();
		return roles;
	}

	@Transactional
	public void removeUser(User user) {
		if (user != null) {
			entityManager.remove(entityManager.merge(user));
		}
	}

	@Transactional
	public User findUserByName(String userName) {

		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.userName =:userName", User.class)
				.setParameter("userName", userName);
		@SuppressWarnings("unchecked")
		List<User> user = query.getResultList();
		if(user.isEmpty()){
			return null;
		}else{
		return user.get(0);
		}
	}
	
	@Transactional
	public List<Book> getFavoriteUserBooks(Integer userId){
		Query query = entityManager.createQuery("SELECT ub FROM User u JOIN u.favouriteUserBooks ub WHERE u.userId = ?", Book.class).setParameter(1, userId);
		@SuppressWarnings("unchecked")
		List<Book>	favouriteUserBooks = query.getResultList();
		return favouriteUserBooks;
	}
	
	@Transactional
	public void saveFavoriteUserBook(User user){
		user = entityManager.merge(user);
		
	}
}
