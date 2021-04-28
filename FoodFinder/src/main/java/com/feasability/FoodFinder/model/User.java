package com.feasability.FoodFinder.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id  //The primary key of the table
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //The id is auto-generated
	@Column
	private Integer id;
	
	@Column(name = "first_name")  // If the column in the db doesn't match the variable, indicate the column name
	private String firstName;
	
	@Column(name = "last_name") 
	private String lastName;
	
	@Column
	private String username;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private String location;
	
	@Column
	private String budget;

	@Column(name = "dob")		
	private Date dateOfBirth;
	
	@Column(name = "favorite_cuisine")	
	private String favoriteCuisine;
	
	
	/*
	 * Gets the user's id
	 * @return the user's id
	 */
	public Integer getId() {
		return id;
	}

	/*
	 * Sets the user's id
	 * @param id the user's id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/*
	 * Gets the user's first name
	 * @return the user's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/*
	 * Sets the user's first name
	 * @param id the user's first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/*
	 * Gets the user's last name
	 * @return the user's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/*
	 * Sets the user's last name
	 * @param id the user's last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/*
	 * Gets the user's username
	 * @return the user's username
	 */
	public String getUsername() {
		return username;
	}
	
	/*
	 * Sets the user's username
	 * @param username the user's username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/*
	 * Gets the user's email
	 * @return the user's email
	 */
	public String getEmail() {
		return email;
	}

	/*
	 * Sets the user's email
	 * @param id the user's email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * Gets the user's password
	 * @return the user's password
	 */
	public String getPassword() {
		return password;
	}

	/*
	 * Sets the user's password
	 * @param id the user's password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * Gets the user's location
	 * @return the user's location
	 */
	public String getLocation() {
		return location;
	}

	/*
	 * Sets the user's location
	 * @param id the user's location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/*
	 * Gets the user's budget
	 * @return the user's budget
	 */
	public String getBudget() {
		return budget;
	}

	/*
	 * Sets the user's budget
	 * @param id the user's budget
	 */
	public void setBudget(String budget) {
		this.budget = budget;
	}
	
	/*
	 * Gets the user's date of birth
	 * @return the user's date of birth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/*
	 * Sets the user's date of birth
	 * @param id the user's date of birth
	 */
	public void setDateOfBirth(Date dob) {
		this.dateOfBirth = dob;
	}

	/*
	 * Gets the user's favorite cuisine
	 * @return the user's favorite cuisine
	 */
	public String getfavoriteCuisine() {
		return favoriteCuisine;
	}

	/*
	 * Sets the user's favorite cuisine
	 * @param id the user's favorite cuisine
	 */
	public void setfavoriteCuisine(String cuisine) {
		this.favoriteCuisine = cuisine;
	}

	/*
	 * A string representation of the user
	 * @return a string composed of the user's instance variables
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", email=" + email + ", password=" + password + ", location=" + location + ", budget=" + budget
				+ ", dateOfBirth=" + dateOfBirth + ", favoriteCuisine=" + favoriteCuisine + "]";
	}
}
