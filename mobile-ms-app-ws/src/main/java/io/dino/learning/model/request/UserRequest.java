package io.dino.learning.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequest {

	// Field names must match the field names in Json body and in order for
	// Spring framework to be able to map Json to this class, we need to 
	// provide getters and setters.
	// In postman, the request needs header Content-Type which is the type
	// of content sent from client, and Accept header which is what client
	// excepts to get back.
	
	// For enable validation, do following:
	//  1. add spring starter validation dependency
	//  2. in application.properties, add:
	//          server.error.include-message=always and
	//  		server.error.include-binding-errors=always
	//  3. In controller, add @Valid before @RequestBody to kick in validation
	//     on the request body
	//  4. Then annotate here using hybernate annotations 
	
	@NotNull(message="First name cannot be null")
	@Size(min=2, message="First name must be minimum 2 characters")
	private String firstName;
	
	@NotNull(message="Last name cannot be null")
	@Size(min=2, message="Last name must be minimum 2 characters")
	private String lastName;
	
	@NotNull(message="Email cannot be null")
	@Email
	private String email;
	
	@NotNull(message="Password cannot be null")
	@Size(min=8, max=16, message="Password must be btw 8 and 16 characters")
	private String password;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
