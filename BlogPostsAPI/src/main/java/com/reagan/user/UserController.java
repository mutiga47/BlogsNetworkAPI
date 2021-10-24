package com.reagan.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/users")
	public List<User> getUsers(){
		return userService.getAllUsers();
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
