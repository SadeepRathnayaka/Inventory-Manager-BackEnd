package com.example.inventory_manager.repo;

import com.example.inventory_manager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, Integer> {
    boolean existsByUserName(String userName);

    boolean existsByEmail(String email);

    User getByUserName(String userName);
}
