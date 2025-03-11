package com.example.inventory_manager.controller;

import com.example.inventory_manager.dto.request.ReqUserLogDTO;
import com.example.inventory_manager.dto.request.ReqUserRegisterDTO;
import com.example.inventory_manager.service.UserService;
import com.example.inventory_manager.utils.StandardReponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/register-user")
    public ResponseEntity<StandardReponse> registerUser(@Valid @RequestBody ReqUserRegisterDTO reqUserRegisterDTO){
        String status = userService.registerUser(reqUserRegisterDTO);
        return ResponseEntity.ok(new StandardReponse(200, "SUCCESS", status));
    }

    @PostMapping(path = "/log-in-user")
    public ResponseEntity<StandardReponse> loginUser(@Valid @RequestBody ReqUserLogDTO reqUserLogDTO){
        String status = userService.logInUser(reqUserLogDTO);
        return ResponseEntity.ok(new StandardReponse(200, "SUCCESS", status));
    }
}
