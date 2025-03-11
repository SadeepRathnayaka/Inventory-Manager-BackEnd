package com.example.inventory_manager.dto;

import jakarta.persistence.Column;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

    private int userId;
    private String userName;
    private String email;
    private String password;
    private String displayName;

}
