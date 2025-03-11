package com.example.inventory_manager.dto.response;

import com.example.inventory_manager.dto.BrandDTO;
import com.example.inventory_manager.dto.ItemTypeDTO;
import com.example.inventory_manager.entity.Brand;
import com.example.inventory_manager.entity.ItemType;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResInventoryDTO {

    private String itemName;
    private String description;
    private float price;
    private LocalDate expireDate;
    private ItemTypeDTO itemTypeDTO;
    private BrandDTO itemBrandDTO;
}
