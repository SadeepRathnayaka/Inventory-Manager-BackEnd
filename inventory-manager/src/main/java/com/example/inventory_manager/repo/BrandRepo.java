package com.example.inventory_manager.repo;

import com.example.inventory_manager.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
@EnableJpaRepositories
public interface BrandRepo extends JpaRepository<Brand, Integer> {
}
