package com.feasability.FoodFinder.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.feasability.FoodFinder.model.Restaurant;

@Repository
public class RestaurantDAOImplementation implements RestaurantDAO {
	@Autowired
	private EntityManager entityManager;  // used to get the current session
	
	@Autowired
	private RestaurantRepository repo;
	
	/*
	 * Gets the current list of restaurants
	 * @return the current list of restaurants
	 */
	@Override
	public List<Restaurant> getList() {
		Session currentSession = entityManager.unwrap(Session.class);								// Gets the current session
		Query<Restaurant> query = currentSession.createQuery("from Restaurant", Restaurant.class);	// Create a query
		List<Restaurant> list = query.getResultList();												// Get a list of restaurants
		return list;
	}

	/*
	 * Gets the restaurant with the given id
	 * @param id the restaurant's id
	 * @return the restaurant with the given id
	 */
	@Override
	public Restaurant getRestaurant(int id) {
		Session currentSession = entityManager.unwrap(Session.class);			// Get the current session
		Restaurant restaurantObj = currentSession.get(Restaurant.class, id);	// Get the restaurant with the given id
		return restaurantObj;													// Return the restaurant
	}

	/*
	 * Saves the given restaurant to the list of restaurants
	 * @param restaurant the restaurant you want to save 
	 */
	@Override
	public void save(Restaurant restaurant) {
		Session currentSession = entityManager.unwrap(Session.class);  	// Get the current session
		currentSession.saveOrUpdate(restaurant);  						// Save the given restaurant		
	}

	/*
	 * Deletes the given restaurant from the list of restaurants
	 * @param id the id of the restaurant you want to delete
	 */
	@Override
	public void deleteRestaurant(int id) {
		Session currentSession = entityManager.unwrap(Session.class);  			// Get the current session
		Restaurant restaurantObj = currentSession.get(Restaurant.class, id);	// Get the restaurant with the given id
		currentSession.delete(restaurantObj);									// Delete the restaurant
	}
	
	/*
	 * Uses JPA Repository to search for restaurants that match the given keyword
	 * @param keyrord the word being searched for
	 * @return a list of restaurants that match the keyword
	 */
	public List<Restaurant> search(String keyword) {
		return repo.search(keyword);
	}
}
