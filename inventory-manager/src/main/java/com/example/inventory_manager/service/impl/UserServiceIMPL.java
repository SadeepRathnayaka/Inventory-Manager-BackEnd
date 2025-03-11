package com.example.inventory_manager.service.impl;

import com.example.inventory_manager.dto.request.ReqUserLogDTO;
import com.example.inventory_manager.dto.request.ReqUserRegisterDTO;
import com.example.inventory_manager.entity.User;
import com.example.inventory_manager.exceptions.EmailAlreadyExistsException;
import com.example.inventory_manager.exceptions.IncorrectUserNameException;
import com.example.inventory_manager.exceptions.UserAlreadyExistsException;
import com.example.inventory_manager.repo.UserRepo;
import com.example.inventory_manager.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String registerUser(ReqUserRegisterDTO reqUserRegisterDTO) {

        if (userRepo.existsByUserName(reqUserRegisterDTO.getUserName())){
            throw new UserAlreadyExistsException("Username is already exists");
        } else if (userRepo.existsByEmail(reqUserRegisterDTO.getEmail())) {
            throw new EmailAlreadyExistsException("This email has an user account, try another email");
        }
        else {
            User user = modelMapper.map(reqUserRegisterDTO, User.class);
            user.setPassword(reqUserRegisterDTO.getPassword());
            userRepo.save(user);
            return "User added successfully";
        }
    }

    @Override
    public String logInUser(ReqUserLogDTO reqUserLogDTO) {

        if (userRepo.existsByUserName(reqUserLogDTO.getUserName())){

            User user = userRepo.getByUserName(reqUserLogDTO.getUserName());
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            if (encoder.matches(reqUserLogDTO.getPassword(), user.getPassword())){
                return "User log in successfully";
            }
            else{
                return "Incorrect password";
            }
        }
        else {
            throw new IncorrectUserNameException("Invalid username");
        }
    }
}
