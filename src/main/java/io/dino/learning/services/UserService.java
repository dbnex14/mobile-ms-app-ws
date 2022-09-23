package io.dino.learning.services;

import io.dino.learning.model.request.UserRequest;
import io.dino.learning.model.response.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
}
