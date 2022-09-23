package io.dino.learning.exceptions;

public class UserServiceException extends RuntimeException {

    private static final long serialVersionUID = -540467588175727995L;

    public UserServiceException(String message) {
        super(message);
    }
}
