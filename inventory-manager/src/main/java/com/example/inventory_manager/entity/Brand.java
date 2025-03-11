package com.example.inventory_manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "brand")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Brand {

    @Id
    @Column(name = "brand_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brandId;

    @Column(name = "item_brand", length = 100, nullable = false)
    private String itemBrand;

    @OneToMany(mappedBy = "itemBrand")
    private List<Inventory> inventoryList;

}
