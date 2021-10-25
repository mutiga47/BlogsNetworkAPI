package com.reagan.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/users")
	public String getUsers(Model modelUser){
	
		List<User> users = userService.getAllUsers();
		
		modelUser.addAttribute("users", users);
		
		return "users";
	}

	@RequestMapping(value="/addUser")
	public ModelAndView addNewUser() {
		User user = new User();
//		Location location = new Location();
//		
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("addLocation", location);
//		mav.addObject("addUser", user);
//		
//		return mav;
		
		return new ModelAndView("addUser", "form", user);
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveNewUser(User user) {
		userService.addUser(user);
		return ("redirect:/users");

	}
	
	@RequestMapping(value="/users/{id}")
	public Optional<User> getUser(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@RequestMapping(value="/users", method=RequestMethod.POST)
	public void insertUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.PUT)
	public void modifyUser(@PathVariable Long id,
						   @RequestBody User user) {
		userService.updateUser(id,
							   user);
	}

	@RequestMapping(value="/users/location/{id}")
	public List<User> getUserByLocation(@PathVariable Long id) {
		return userService.getUserByLocation(id);
	}
		
	@RequestMapping(value="/users/{id}", 
					method=RequestMethod.DELETE)
	public void removeUser(@PathVariable Long id) {
		userService.deleteUser(id);
		
	}
}
