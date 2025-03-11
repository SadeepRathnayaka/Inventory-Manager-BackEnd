package com.example.inventory_manager.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResOrderDetailsSaveDto {

    private String itemName;
    private int quantity;
}
