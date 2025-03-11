package com.example.inventory_manager.repo;

import com.example.inventory_manager.entity.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ItemTypeRepo extends JpaRepository<ItemType, Integer> {
}
