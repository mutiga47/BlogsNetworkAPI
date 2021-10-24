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

	@RequestMapping(value="/users/{id}")
	public Optional<User> getUser(@PathVariable String id) {
		return userService.getUserById(id);
	}

	@RequestMapping(value="/users", method=RequestMethod.POST)
	public void insertUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.PUT)
	public void modifyUser(@PathVariable String id,
						   @RequestBody User user) {
		userService.updateUser(id,
							   user);
	}

	@RequestMapping(value="/users/location/{id}")
	public List<User> getUserByLocation(@PathVariable String id) {
		return userService.getUserByLocation(id);
	}
		
	@RequestMapping(value="/users/{id}", 
					method=RequestMethod.DELETE)
	public void removeUser(@PathVariable String id) {
		userService.deleteUser(id);
		
	}
}
