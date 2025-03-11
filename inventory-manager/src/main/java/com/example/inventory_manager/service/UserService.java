package com.example.inventory_manager.service;

import com.example.inventory_manager.dto.request.ReqUserLogDTO;
import com.example.inventory_manager.dto.request.ReqUserRegisterDTO;

public interface UserService {
    String registerUser(ReqUserRegisterDTO reqUserRegisterDTO);

    String logInUser(ReqUserLogDTO reqUserLogDTO);
}
