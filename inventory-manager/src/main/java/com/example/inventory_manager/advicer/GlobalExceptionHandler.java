package com.example.inventory_manager.advicer;

import com.example.inventory_manager.exceptions.EmailAlreadyExistsException;
import com.example.inventory_manager.exceptions.IncorrectUserNameException;
import com.example.inventory_manager.exceptions.NoItemFoundException;
import com.example.inventory_manager.exceptions.UserAlreadyExistsException;
import com.example.inventory_manager.utils.StandardReponse;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Hidden
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<StandardReponse> handleUserAlreadyExists(UserAlreadyExistsException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).
                body(new StandardReponse(409, "ERROR", ex.getMessage()));
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<StandardReponse> handlEmailAlreadyExists(EmailAlreadyExistsException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).
                body(new StandardReponse(409, "ERROR", ex.getMessage()));
    }

    @ExceptionHandler(IncorrectUserNameException.class)
    public ResponseEntity<StandardReponse> handleIncorrectUserNameException(IncorrectUserNameException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body(new StandardReponse(404, "ERROR", ex.getMessage()));
    }

    @ExceptionHandler(NoItemFoundException.class)
    public ResponseEntity<StandardReponse> handleNoItemFoundException(NoItemFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body(new StandardReponse(404, "ERROR", ex.getMessage()));
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardReponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        StringBuilder errorMessage = new StringBuilder("Validation failed for: ");

        ex.getBindingResult().getFieldErrors().forEach(fieldError ->
                errorMessage.append(fieldError.getField()).append(" - ").append(fieldError.getDefaultMessage()).append("; ")
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new StandardReponse(400, "ERROR", errorMessage.toString()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardReponse> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new StandardReponse(500, "ERROR", "An unexpected error occurred : " + ex.getMessage()));
    }


}
