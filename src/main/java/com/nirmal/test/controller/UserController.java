/**
 * 
 */
package com.nirmal.test.controller;

import java.net.URI;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nirmal.test.model.User;
import com.nirmal.test.repository.UserRepository;

/**
 * @author muthu_m
 *
 */
@RestController
public class UserController {

	private static final Logger LOGGER = LogManager.getLogger(UserController.class);
	
	// This means to get the bean called userRepository. Which is auto-generated by Spring, we will use it to handle the data
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String welcome() {
		LOGGER.info("This logger generated to test the root webservices {}");
		return "welcome";
	}

	@PostMapping("/add") // Map ONLY GET Requests
	public ResponseEntity<Void> addNewUser (@RequestBody User user) {
		User user2 = userRepository.findOne(user.getId());
		if(user2 == null) {
			return ResponseEntity.noContent().build();
		}
		userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(user2.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/list")
	public Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}