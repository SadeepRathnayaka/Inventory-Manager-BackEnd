package com.example.inventory_manager.dto.response;

import com.example.inventory_manager.dto.BrandDTO;
import com.example.inventory_manager.dto.ItemTypeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResInventorySearchDTO {

    private int inventoryId;
    private String itemName;
    private String description;
    private float price;
    private LocalDate expireDate;
    private String itemType;
    private String itemBrand;

}
