package com.feasability.FoodFinder.service;

import java.util.List;

import com.feasability.FoodFinder.model.Restaurant;

public interface RestaurantService {
	List<Restaurant> getList();							// Gets a list of Restaurants
	
	Restaurant getRestaurant(int id);					// Returns the restaurant with the given id
	
	void save(Restaurant restaurant);					// Saves the restaurant to the list
		
	void deleteRestaurant(int id);						// Deletes the restaurant from the list
			
	public List<Restaurant> search(String keyword);		// Gets a list of restaurants that match the keyword
	
	public List<Restaurant> filterByLocation(String keyword, String location);  // Gets a list of restaurants that match the keyword and location

}
