package com.example.inventory_manager.repo;

import com.example.inventory_manager.entity.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface InventoryRepo extends JpaRepository<Inventory, Integer> {

    @Query(value =
            "SELECT i FROM Inventory i " +
            "WHERE (:itemName IS NULL OR i.itemName LIKE %:itemName%) " +
            "AND (:itemType IS NULL OR i.itemType.itemTypeId = :itemType) " +
            "AND (:brands IS NULL OR i.itemBrand.brandId IN :brands)")
    List<Inventory> searchInventory(
            @Param("itemName") String itemName,
            @Param("itemType") Integer itemType,
            @Param("brands") List<Integer> brands
    );

    @Query(value =
            "SELECT i FROM Inventory i " +
            "WHERE (:itemName IS NULL OR i.itemName LIKE %:itemName%) " +
            "AND (:itemType IS NULL OR i.itemType.itemTypeId = :itemType) " +
            "AND (:brands IS NULL OR i.itemBrand.brandId IN :brands)")
    Page<Inventory> searchInventory(
            @Param("itemName") String itemName,
            @Param("itemType") Integer itemType,
            @Param("brands") List<Integer> brands,
            Pageable pageable
    );

    @Query(value =
            "SELECT COUNT(*) FROM Inventory i " +
            "WHERE (:itemName IS NULL OR i.itemName LIKE %:itemName%) " +
            "AND (:itemType IS NULL OR i.itemType.itemTypeId = :itemType) " +
            "AND (:brands IS NULL OR i.itemBrand.brandId IN :brands)")
    long countInventory(
            @Param("itemName") String itemName,
            @Param("itemType") Integer itemType,
            @Param("brands") List<Integer> brands
    );

}
