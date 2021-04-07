package com.feasability.FoodFinder.dao;

import java.util.List;
import com.feasability.FoodFinder.model.User;

// an interface for a database
public interface UserDAO {
	
	List<User> getList();		// A list of users
	
	User getUser(int id);  		// Returns the user with the given id
	
	void save(User user);  		// Saves the user to the list
	
	void deleteUser(int id);	// Deletes the user from the list
	
	public User findByEmailAndPassword(String email, String password); // Returns a user with given email
}
