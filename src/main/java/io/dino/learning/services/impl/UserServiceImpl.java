package io.dino.learning.services.impl;

import io.dino.learning.model.request.UserRequest;
import io.dino.learning.model.response.UserResponse;
import io.dino.learning.services.UserService;
import io.dino.learning.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    Map<String, UserResponse> users;

    Utils utils;

    public UserServiceImpl(){}

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    public UserResponse createUser(UserRequest userRequest) {
        UserResponse response = new UserResponse();
        response.setFirstName(userRequest.getFirstName());
        response.setLastName(userRequest.getLastName());
        response.setEmail(userRequest.getEmail());

        String userId = utils.generateUserId();
        response.setUserId(userId);

        if (users == null) {
            users = new HashMap<>();
        }
        users.put(userId, response);

        return response;
    }
}
