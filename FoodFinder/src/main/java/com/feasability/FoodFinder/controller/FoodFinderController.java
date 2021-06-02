package com.feasability.FoodFinder.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.feasability.FoodFinder.model.Restaurant;
import com.feasability.FoodFinder.model.SearchFilter;
import com.feasability.FoodFinder.model.User;
import com.feasability.FoodFinder.service.RestaurantService;
import com.feasability.FoodFinder.service.UserService;

@Controller
public class FoodFinderController {
	
	private String initialSearch = "";						// save the initial search result for filtering
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	/*
	 * Displays the home page
	 */
	@RequestMapping(value = {"/", "/home"})
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("homepage");	// Create a new MAV for the page
		//mav.addObject("home");							// Add the list of users to the MAV
		return mav;											// Return the MAV
	}
	
	/*
	 * Displays the list of users
	 */
	@RequestMapping(value = {"/users"})
	public ModelAndView getUserList() {
		ModelAndView mav = new ModelAndView("userList");	// Create a new MAV for the page
		mav.addObject("userList", userService.getList());	// Add the list of users to the MAV
		return mav;											// Return the MAV
	}
	
	/*
	 * Creates and saves a User from the form
	 * Displays the list of users
	 */
	@RequestMapping("/saveUser")
	public ModelAndView saveUser(@ModelAttribute("user") User userObj) {	// @ModelAttribute creates a user from the form's values
		ModelAndView mav = new ModelAndView("userList");					// Create a new MAV for the page
		userService.save(userObj);											// Save the given user
		mav.addObject("userList", userService.getList());					// Add the list of users to the MAV
		return mav;															// Return the MAV
	}
	
	/*
	 * Gets the user with the given id
	 * Displays the userAdd page
	 */
	@RequestMapping("/users/{id}")
	public ModelAndView getUser(@PathVariable("id") int getID) {
		ModelAndView mav = new ModelAndView("userAdd");		// Create a new MAV for the page
		User userObj =  userService.getUser(getID);			// Get the user with the given id
		if (userObj == null) {								// If the user doesn't exist
			throw new RuntimeException("User with id: " 
		    + getID + " was not found");					// Throw an exception
		}
		mav.addObject("user", userObj);						// Add the user to the MAV
		return mav;											// Return the MAV
	}
	
	/*
	 * Deletes the user with the given id 
	 * Displays the list of users
	 */
	@RequestMapping("/deleteUser/{id}")
	public ModelAndView deleteUser(@PathVariable("id") int deleteID) {
		ModelAndView mav = new ModelAndView("userList");	// Create a new MAV for the page
		userService.deleteUser(deleteID);					// Delete the user with the given id
		mav.addObject("userList", userService.getList());	// Add the list of users to the MAV
		return mav;											// Return the MAV
	}
	
	
	@RequestMapping("/registration")
	public ModelAndView showUserRegistration() {
		ModelAndView mav = new ModelAndView("userReg");
		mav.addObject("user", new User());
		return mav;
	}
	
	/*
	 * Displays the userAdd page
	 */
	@RequestMapping("/showUserForm")
	public ModelAndView showUserForm() {
		ModelAndView mav = new ModelAndView("userAdd");		// Create a new MAV for the page
		mav.addObject("user", new User());					// Add a new user to the MAV
		return mav;											// Returns the MAV
	}
	
	@RequestMapping("/login")
	public ModelAndView showUserLogin(User user) {
		ModelAndView mav = new ModelAndView("userLogin");
		mav.addObject("user", new User());
		return mav;
	}
	
	@PostMapping("/login/user")
	public ModelAndView loginUser(@ModelAttribute("user") User user) {
		ModelAndView mav = new ModelAndView();
		User u = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if (u != null) {
			mav.setViewName("userHome");
			mav.addObject(u);
		}
		else {
			mav.setViewName("userList");
		}
		return mav;
	}
	
	/*
	 * Displays the list of restaurants
	 */
	@RequestMapping(value = {"/restaurants"})
	public ModelAndView getRestaurantList() {
		ModelAndView mav = new ModelAndView("restaurantList");			// Create a new MAV for the page
		mav.addObject("restaurantList", restaurantService.getList());	// Add the list of users to the MAV
		return mav;														// Return the MAV
	}
	
	/*
	 * Creates and saves a restaurant from the form
	 * Displays the list of restaurants
	 */
	@RequestMapping("/saveRestaurant")
	public ModelAndView saveRestaurant(@ModelAttribute("restaurant") Restaurant restaurantObj) {
		ModelAndView mav = new ModelAndView("restaurantList");			// Create a new MAV for the page
		restaurantService.save(restaurantObj);							// Save the given user
		mav.addObject("restaurantList", restaurantService.getList());	// Add the list of users to the MAV
		return mav;														// Return the MAV
	}
	
	/*
	 * Gets the user with the given id
	 * Displays the userAdd page
	 */
	@RequestMapping("/restaurants/{id}")
	public ModelAndView getRestaurant(@PathVariable("id") int getID) {
		ModelAndView mav = new ModelAndView("restaurantAdd");					// Create a new MAV for the page
		Restaurant restaurantObj =  restaurantService.getRestaurant(getID);		// Get the user with the given id
		if (restaurantObj == null) {											// If the user doesn't exist
			throw new RuntimeException("User with id: " 
		    + getID + " was not found");										// Throw an exception
		}
		mav.addObject("restaurant", restaurantObj);								// Add the user to the MAV
		return mav;																// Return the MAV
	}
	
	/*
	 * Deletes the user with the given id 
	 * Displays the list of users
	 */
	@RequestMapping("/deleteRestaurant/{id}")
	public ModelAndView deleteRestaurant(@PathVariable("id") int deleteID) {
		ModelAndView mav = new ModelAndView("restaurantList");			// Create a new MAV for the page
		restaurantService.deleteRestaurant(deleteID);					// Delete the user with the given id
		mav.addObject("restaurantList", restaurantService.getList());	// Add the list of users to the MAV
		return mav;														// Return the MAV
	}
	
	/*
	 * Displays the restaurantAdd page
	 */
	@RequestMapping("/showRestaurantForm")
	public ModelAndView showRestaurantForm() {
		ModelAndView mav = new ModelAndView("restaurantAdd");	// Create a new MAV for the page
		mav.addObject("restaurant", new Restaurant());			// Add a new restaurant to the MAV
		return mav;												// Return the MAV
	}
	
	@RequestMapping("/searchRestaurant")
	public ModelAndView search(@Param("keyword") String keyword, @ModelAttribute("searchFilter") SearchFilter filter) {
		//List<Restaurant> searchResult = restaurantService.search(keyword);
		ModelAndView mav = new ModelAndView("restaurantSearchResult");					// Create a new MAV for the page
		mav.addObject("keyword", keyword);												// Add the keyword to the MAV
		mav.addObject("restaurantSearchResult", restaurantService.search(keyword));		// Add the list of search results to the MAV
		
		initialSearch = keyword;														// Save the keyword
		return mav;																		// Return the MAV
		}
	
	@RequestMapping("/filterRestaurantSearch")
	public ModelAndView filterSearch(@ModelAttribute("searchFilter") SearchFilter filter) {
		ModelAndView mav = new ModelAndView("filterRestaurantSearch");											// Create a new MAV for the page
		String keyword = initialSearch;
		mav.addObject("keyword", keyword);																		// Add the keyword to the MAV
		
		if (filter.totalSize() == 0) {																			// If no filters have been selected
			mav.addObject("restaurantSearchResult", restaurantService.search(keyword));							// Add the list of search results to the MAV 
		} else {
			List<Restaurant> searchResults = new ArrayList<>();													// Create a new list for the search results
			if (filter.getLocation() == "") {																	// If the filter doesn't have a location
				searchResults = restaurantService.search(keyword);												// Get the list of restaurants that match the search keyword
			} else {
				String location = "%" + filter.getLocation() + "%";												// Get the location from the filter
				searchResults = restaurantService.filterByLocation(keyword, location);							// Get the list of restaurants that match the search keyword and the location
			}
			
			List<Restaurant> budgetResults = new ArrayList<>();													// Create a list to hold the restaurants filtered by budget
			List<Restaurant> finalResults = new ArrayList<>();													// Create a list to hold the final restaurants filtered by budget and cuisine
			
			if (filter.getSelectedBudgets().length == 0) {														// If no budgets have been selected for filtering
				budgetResults = searchResults;																	// Set budgetResults equal to searchResults
			} else {
				for (int i = 0; i < filter.getSelectedBudgets().length; i++) {									// Iterate through the list of budgets in the filter
					String budget = filter.getSelectedBudgets()[i];												// Get the budget at index i
					for (int j = 0; j < searchResults.size(); j++) {											// Iterate through the search results
						if (searchResults.get(j).getBudget().toLowerCase().equals(budget.toLowerCase())) {		// If the budget in the search matches the budget for the filter
							budgetResults.add(searchResults.get(j));											// Add the restaurant to budgetResults
						}
					}
				}
			}
			
			if (filter.getSelectedCuisines().length == 0) {														// If no cuisines have been selected for filtering
				finalResults = budgetResults;																	// Set finalResults equal to budgetResults
			} else {
				for (int i = 0; i < filter.getSelectedCuisines().length; i++) {									// Iterate through the list of cuisines in the filter
					String cuisine = filter.getSelectedCuisines()[i];											// Get the cuisine at index i
					for (int j = 0; j < budgetResults.size(); j++) {											// Iterate through budgetResults
						if (budgetResults.get(j).getCuisine().toLowerCase().equals(cuisine.toLowerCase())) {	// If the cuisine in budgetResults matches the cuisine for the filter
							finalResults.add(budgetResults.get(j));												// Add the restaurant to finalResults
						}
					}
				}
			}
			mav.addObject("restaurantSearchResult", finalResults);
		}
		return mav;
	}
}
