package io.dino.learning.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import io.dino.learning.exceptions.UserServiceException;
import io.dino.learning.model.request.UpdateUserRequest;
import io.dino.learning.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.dino.learning.model.request.UserRequest;
import io.dino.learning.model.response.UserResponse;

@RestController
@RequestMapping("users")  //http://localhost:8080/users
public class UserController {
	@Autowired
	UserService userService;

	Map<String, UserResponse> users;

	@GetMapping(path="/{userId}",
			produces = { MediaType.APPLICATION_XML_VALUE, 
						 MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserResponse> getUser(@PathVariable String userId) {
		if (true) throw new UserServiceException("UserServiceException throws");

		if (users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		} else {
			// return 204 (no content) if no user found (so request is good but nothing to return)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping
	public String getUsers(
			@RequestParam(value="page", defaultValue="1") int page, 
			@RequestParam(value="limit", defaultValue="50") int limit,
			@RequestParam(value="sort", defaultValue="desc", required=false) String sort) {
		
		return "getUsers was called with page = " + page + " "
				+ "and limit = " + limit + " "
				+ "and sort = " + sort;
	}
	
	@PostMapping(
			consumes = { MediaType.APPLICATION_XML_VALUE, 
						 MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_XML_VALUE, 
					 	 MediaType.APPLICATION_JSON_VALUE })
	// To enable validation add @Valid.  To temporarily stop it, remove it
	public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) {
		
		UserResponse response = userService.createUser(userRequest);
		
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}
	
	@PutMapping(path="/{userId}",
			consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserResponse updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserRequest userRequest) {
		UserResponse storedUserDetails = users.get(userId);
		storedUserDetails.setFirstName(userRequest.getFirstName());
		storedUserDetails.setLastName(userRequest.getLastName());

		users.put(userId, storedUserDetails);
		return storedUserDetails;
	}
	
	@DeleteMapping(path="/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		users.remove(userId);
		// returns 204 (no content) since we are returning nothing
		return ResponseEntity.noContent().build();
	}
}
