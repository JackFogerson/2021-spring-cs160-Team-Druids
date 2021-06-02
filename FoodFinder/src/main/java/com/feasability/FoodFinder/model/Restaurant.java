package com.feasability.FoodFinder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurants")
public class Restaurant {
	
	@Id  //The primary key of the table
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //The id is auto-generated
	@Column
	private Integer id;
	
	@Column(name = "restaurant_name")  // If the column in the db doesn't match the variable, indicate the column name
	private String restaurantName;
	
	@Column
	private String street;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column
	private String cuisine;
	
	@Column
	private String budget;
	
	/*
	 * Gets the restaurant's id
	 * @return the restaurant's id
	 */
	public Integer getId() {
		return id;
	}

	/*
	 * Sets the restaurant's id
	 * @param id the restaurant's id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/*
	 * Gets the restaurant's name
	 * @return the restaurant's name
	 */
	public String getRestaurantName() {
		return restaurantName;
	}

	/*
	 * Sets the name of the restaurant
	 * @param restaurantName the restaurant's name
	 */
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	/*
	 * Gets the restaurant's street address
	 * @return the restaurant's street address
	 */
	public String getStreet() {
		return street;
	}

	/*
	 * Sets the street address of the restaurant
	 * @param street the restaurant's street address
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/*
	 * Gets the city the restaurant is located in
	 * @return the restaurant's city
	 */
	public String getCity() {
		return city;
	}

	/*
	 * Sets the city the restaurant is located in
	 * @param city the restaurant's city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/*
	 * Gets the state the restaurant is located in
	 * @return the restaurant's state
	 */
	public String getState() {
		return state;
	}

	/*
	 * Sets the state the restaurant is located in
	 * @param state the restaurant's state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/*
	 * Gets the type of cuisine offered at the restaurant
	 * @return the restaurant cuisine
	 */
	public String getCuisine() {
		return cuisine;
	}

	/*
	 * Sets the type of cuisine offered at the restaurant
	 * @param cuisine the restaurant's cuisine
	 */
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	/*
	 * Gets the budget of the restaurant
	 * @return the restaurant's budget
	 */
	public String getBudget() {
		return budget;
	}

	/*
	 * Sets the budget of the restaurant
	 * @param budget the restaurant's budget
	 */
	public void setBudget(String budget) {
		this.budget = budget;
	}
		
	/*
	 * A string representation of the restaurant
	 * @return a string composed of the restaurant's instance variables
	 */
	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", restaurantName=" + restaurantName + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", cuisine=" + cuisine + ", budget=" + budget + "]";
	}
}
