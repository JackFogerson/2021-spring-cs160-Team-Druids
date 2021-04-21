package com.feasability.FoodFinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.feasability.FoodFinder.dao.RestaurantDAO;
import com.feasability.FoodFinder.model.Restaurant;

@Service
public class RestaurantServiceImplementation implements RestaurantService{
	
	@Autowired
	private RestaurantDAO restaurantDAO;

	/*
	 * Gets the list of restaurants in the db
	 * @return a list of restaurants
	 */
	@Transactional
	@Override
	public List<Restaurant> getList() {
		return restaurantDAO.getList();
	}

	/*
	 * Gets the restaurant with the given id
	 * @return the restaurant with the given id
	 */
	@Transactional
	@Override
	public Restaurant getRestaurant(int id) {
		return restaurantDAO.getRestaurant(id);
	}

	/*
	 * Saves the given restaurant in the db
	 */
	@Transactional
	@Override
	public void save(Restaurant restaurant) {
		restaurantDAO.save(restaurant);
	}

	/*
	 * Removes the restaurant with the given id from the db
	 */
	@Transactional
	@Override
	public void deleteRestaurant(int id) {
		restaurantDAO.deleteRestaurant(id);
	}

	/*
	 * Uses JPA Repository to search for restaurants that match the given keyword
	 * @param keyrord the word being searched for
	 * @return a list of restaurants that match the keyword
	 */
	public List<Restaurant> search(String keyword) {
		return restaurantDAO.search(keyword);
	}	
}
