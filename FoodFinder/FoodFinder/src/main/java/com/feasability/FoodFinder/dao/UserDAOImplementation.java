package com.feasability.FoodFinder.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.feasability.FoodFinder.model.User;

@Repository
@Table(name = "users")
public class UserDAOImplementation implements UserDAO{

	@Autowired
	private EntityManager entityManager;
	
	
	/*
	 * Gets the current list of users
	 * @return the current list of users
	 */
	@Override
	public List<User> getList() {
		Session currentSession = entityManager.unwrap(Session.class);  		// Gets the current session
		Query<User> query = currentSession.createQuery("from User", User.class); 	// Create a query
		List<User> list = query.getResultList();  	// Get a list of Users 
		return list;
		
	}

	@Override
	public User getUser(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		User userObj = currentSession.get(User.class, id);
		return userObj;
	}

	@Override
	public void save(User user) {
		Session currentSession = entityManager.unwrap(Session.class);  // Gives the current session
		currentSession.saveOrUpdate(user);
	}

	@Override
	public void deleteUser(int id) {
		Session currentSession = entityManager.unwrap(Session.class);  // Gets the current session
		User userObj = currentSession.get(User.class, id);
		currentSession.delete(userObj);
	}

	@Override
	public User findByEmailAndPassword(String emailInput, String passwordInput) {
		Session currentSession = entityManager.unwrap(Session.class);  		// Gets the current session
		Query<User> query = currentSession.createQuery("from User", User.class); 	// Create a query
		List<User> list = query.getResultList();  	// Get a list of Users 
		User user = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getEmail() == emailInput) {
				user = list.get(i);
				return user;
			}
		}
		return user;
	}
}
