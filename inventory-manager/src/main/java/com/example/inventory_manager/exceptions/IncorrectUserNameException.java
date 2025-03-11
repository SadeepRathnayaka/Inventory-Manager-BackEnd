package com.example.inventory_manager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IncorrectUserNameException extends RuntimeException{
    public IncorrectUserNameException(String message){
        super(message);
    }
}
