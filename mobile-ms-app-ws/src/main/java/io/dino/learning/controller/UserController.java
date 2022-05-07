package io.dino.learning.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.dino.learning.response.UserResponse;

@RestController
@RequestMapping("users")  //http://localhost:8080/users
public class UserController {

	@GetMapping(path="/{userId}",
			produces = { MediaType.APPLICATION_XML_VALUE, 
						 MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserResponse> getUser(@PathVariable String userId) {
		
		UserResponse response = new UserResponse();
		response.setFirstName("mike");
		response.setLastName("biker");
		response.setEmail("mike.biker@blahblah.com");
		
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
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
	
	@PostMapping
	public String createUser() {
		return "createUser was called";
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
