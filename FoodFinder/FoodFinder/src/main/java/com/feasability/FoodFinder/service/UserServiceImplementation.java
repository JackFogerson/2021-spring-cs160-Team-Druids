package com.feasability.FoodFinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.feasability.FoodFinder.dao.UserDAO;
import com.feasability.FoodFinder.model.User;

@Service
public class UserServiceImplementation implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	/*
	 * Gets the list of users in the db
	 * @return a list of users
	 */
	@Transactional
	@Override
	public List<User> getList() {
		return userDAO.getList();
	}

	/*
	 * Gets the user with the given id
	 * @return the user with the given id
	 */
	@Transactional
	@Override
	public User getUser(int id) {
		return userDAO.getUser(id);
	}

	/*
	 * Saves the given user in the db
	 */
	@Transactional
	@Override
	public void save(User user) {  
		userDAO.save(user);
		
	}

	/*
	 * Removes the user with the given id from the db
	 */
	@Transactional
	@Override
	public void deleteUser(int id) {  
		userDAO.deleteUser(id);
	}

}
