package com.feasability.FoodFinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  //Might be wrong import
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.feasability.FoodFinder.model.User;
import com.feasability.FoodFinder.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"/", "/index"})
	public ModelAndView get() {
		ModelAndView mav = new ModelAndView("userList");
		mav.addObject("userList", userService.getList());
		return mav;
	}
	
	@RequestMapping("/home")
		public ModelAndView showHomepage() {
		ModelAndView mav = new ModelAndView("homepage");
		return mav;
	}
	
	@RequestMapping("/save")
	public ModelAndView save(@ModelAttribute("user") User userObj) {
		ModelAndView mav = new ModelAndView("userList");
		userService.save(userObj);
		mav.addObject("userList", userService.getList());
		return mav;
	}
	
	@RequestMapping("/user/{id}")
	public ModelAndView getUser(@PathVariable("id") int getID) {
		ModelAndView mav = new ModelAndView("userAdd");
		User userObj =  userService.getUser(getID);
		if (userObj == null) {
			throw new RuntimeException("User with id: " + getID + " was not found");
		}
		mav.addObject("user", userObj);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteUser(@PathVariable("id") int deleteID) {
		ModelAndView mav = new ModelAndView("userList");
		userService.deleteUser(deleteID);
		mav.addObject("userList", userService.getList());
		return mav;
	}
	
	//@PutMapping("/user")
	//public User updateUser(@RequestBody User userObj) {
	//	userService.save(userObj);
	//	return userObj;
	//}
	
	@RequestMapping("/userReg")
	public ModelAndView showUserRegistration() {
		ModelAndView mav = new ModelAndView("userReg");
		mav.addObject("user", new User());
		return mav;
	}
}
