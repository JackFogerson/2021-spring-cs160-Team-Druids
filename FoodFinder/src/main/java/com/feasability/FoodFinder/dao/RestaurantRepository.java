package com.feasability.FoodFinder.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.feasability.FoodFinder.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	
	/*
	 * Utilizes the native query to search the database for restaurants that match the keyword
	 * @param keyrord the word being searched for
	 * @return a list of restaurants that match the keyword
	 */
	@Query(value= "SELECT * FROM restaurants WHERE \r\n"
			+ "MATCH (restaurant_name, cuisine, city, state, street)\r\n"
			+ "AGAINST (?1)",
			nativeQuery = true)
	public List<Restaurant> search(String keyword);
	
	/*
	 * Utilizes the native query to search the database for restaurants that match the keyword
	 * @param keyword the word being searched for
	 * @param location the desired location of the restaurant
	 * @return a list of restaurants the match the keyword and location
	 */
	@Query(value= "SELECT * FROM restaurants WHERE MATCH (restaurant_name, cuisine, city, state, street) AGAINST (?1) AND (street LIKE ?2 OR city LIKE ?2 OR state LIKE ?2)",
			nativeQuery = true)
	public List<Restaurant> filterByLocation(String keyword, String location);
}
