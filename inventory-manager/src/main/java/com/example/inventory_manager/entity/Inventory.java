package com.example.inventory_manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "inventory")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Inventory {

    @Id
    @Column(name = "inventory_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inventoryId;

    @Column(name = "item_name", length = 50, nullable = false)
    private String itemName;

    @Lob
    @Column(name = "description", columnDefinition = "TEXT", nullable = true)
    private String description;

    @Column(name = "item_price", nullable = false)
    private float price;

    @Column(name = "expire_date", nullable = true)
    private LocalDate expireDate;

    @ManyToOne
    @JoinColumn(name = "item_type_id", nullable = false)
    private ItemType itemType;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand itemBrand;

    @OneToMany(mappedBy = "inventory")
    private List<OrderDetails> orderDetailsList_;
}
