package io.dino.learning.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

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
	
	Map<String, UserResponse> users;

	@GetMapping(path="/{userId}",
			produces = { MediaType.APPLICATION_XML_VALUE, 
						 MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserResponse> getUser(@PathVariable String userId) {
		
		if (users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		} else {
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
		
		UserResponse response = new UserResponse();
		response.setFirstName(userRequest.getFirstName());
		response.setLastName(userRequest.getLastName());
		response.setEmail(userRequest.getEmail());
		
		String userId = UUID.randomUUID().toString();
		response.setUserId(userId);
		
		if (users == null) {
			users = new HashMap<>();
		}
		users.put(userId, response);
		
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}
	
	@PutMapping
	public String updateUser() {
		
		return "updateUser was called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "deleteUser was called";
	}
}
