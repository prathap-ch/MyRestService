package com.skillUp.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skillUp.exceptions.UserNotFoundException;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable int id) throws UserNotFoundException{
		Optional<User> user=userRepository.findById(id);
		if(user.isEmpty()) {
		 throw new  UserNotFoundException("USER NOT FOUND FOR ID ="+id);
		}
		return user;
	}
	@PostMapping("/users/save")
	public User saveUser(@RequestBody User user){
		return userRepository.save(user);
	}
	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable int id) throws UserNotFoundException{
		if(!userRepository.findById(id).isEmpty()) {
		userRepository.deleteById(id);
		return "Record (ID: "+id+") deleted successfully";
		}else {
			throw new UserNotFoundException("USER NOT FOUND FOR ID = "+id);
		}
	}
}
