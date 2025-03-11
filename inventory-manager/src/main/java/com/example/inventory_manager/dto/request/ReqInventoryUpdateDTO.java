package com.example.inventory_manager.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReqInventoryUpdateDTO {

    private int inventoryId;
    private int itemType;
    private String itemName;
    private int itemBrand;
    private String description;
    private float price;
    private LocalDate expireDate;
}
