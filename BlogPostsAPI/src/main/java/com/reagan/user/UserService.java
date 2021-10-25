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

	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);		
	}
	
	public List<User> getUserByLocation(Long id) {
		
		return userRepository.findByLocationId(id);
		
	}

	public void addUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(Long id, 
						   User user) {
		userRepository.save(user);		
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
}
