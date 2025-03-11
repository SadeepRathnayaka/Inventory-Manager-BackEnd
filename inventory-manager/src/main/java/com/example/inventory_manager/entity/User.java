package com.example.inventory_manager.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "user_name", length = 255, nullable = false)
    private String userName;

    @Column(name = "email", length = 255, nullable = false)
    private String email;

    @Setter(AccessLevel.NONE)
    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "display_name", length = 255, nullable = false)
    private String displayName;

    @OneToMany(mappedBy = "user")
    private List<Order> orderList;

    public void setPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);
    }


}
