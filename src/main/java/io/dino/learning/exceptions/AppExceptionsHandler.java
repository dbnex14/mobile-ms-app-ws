package io.dino.learning.exceptions;

import io.dino.learning.model.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.constraints.Null;
import java.util.Date;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
        String errorMessage = ex.getLocalizedMessage();
        if (errorMessage == null) errorMessage = ex.toString();
        ErrorMessage errorDescription = new ErrorMessage(new Date(), errorMessage);

        return new ResponseEntity<>(errorDescription, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) {
        String errorMessage = ex.getLocalizedMessage();
        if (errorMessage == null) errorMessage = ex.toString();
        ErrorMessage errorDescription = new ErrorMessage(new Date(), errorMessage);

        return new ResponseEntity<>(errorDescription, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // if you wanted to handle multiple exception types, add to @ExceptionHandler {} a comma delimited exceptions
    // and as parameter passed in, pass top Exception.
    @ExceptionHandler(value = {UserServiceException.class})
    public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest request) {
        String errorMessage = ex.getLocalizedMessage();
        if (errorMessage == null) errorMessage = ex.toString();
        ErrorMessage errorDescription = new ErrorMessage(new Date(), errorMessage);

        return new ResponseEntity<>(errorDescription, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
