package io.dino.learning.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserRequest {

    @NotNull(message="First name cannot be null")
    @Size(min=2, message="First name must be minimum 2 characters")
    private String firstName;

    @NotNull(message="Last name cannot be null")
    @Size(min=2, message="Last name must be minimum 2 characters")
    private String lastName;

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
}
