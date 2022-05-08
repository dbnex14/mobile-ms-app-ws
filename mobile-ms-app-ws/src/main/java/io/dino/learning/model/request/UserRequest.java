package io.dino.learning.model.request;

public class UserRequest {

	// Field names must match the field names in Json body and in order for
	// Spring framework to be able to map Json to this class, we need to 
	// provide getters and setters.
	// In postman, the request needs header Content-Type which is the type
	// of content sent from client, and Accept header which is what client
	// excepts to get back.
	private String firstName;
	private String lastName;
	private String email;
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
