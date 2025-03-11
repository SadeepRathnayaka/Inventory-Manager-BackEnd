package com.example.inventory_manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "item_type")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemType {

    @Id
    @Column(name = "item_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemTypeId;

    @Column(name = "type", length = 255, nullable = false)
    private String type;

    @OneToMany(mappedBy = "itemType")
    private List<Inventory> inventoryList;
}
