package com.example.inventory_manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemTypeDTO {

    private int itemTypeId;
    private String type;
}
