package com.example.inventory_manager.exceptions;

import org.apache.tomcat.websocket.server.WsHttpUpgradeHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)  // 409 Conflict
public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException(String message){
        super(message);
    }
}
