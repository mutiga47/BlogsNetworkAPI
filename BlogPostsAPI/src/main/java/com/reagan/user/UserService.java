package com.reagan.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		
		userRepository.findAll().forEach(users::add);
		
		return users;
	}

	public Optional<User> getUserById(String id) {
		return userRepository.findById(id);		
	}
	
	public List<User> getUserByLocation(String id) {
		
		return userRepository.findByLocationId(id);
		
	}

	public void addUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(String id, 
						   User user) {
		userRepository.save(user);		
	}

	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}
	
}
