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
public class ReqInventorySaveDTO {

    @NotNull(message = "Item Type is a required field")
    private int itemType;

    @NotBlank(message = "Item Name is a required field")
    private String itemName;

    @NotNull(message = "Item Brand is a required field")
    private int itemBrand;

    private String description;

    @NotNull(message = "Item Price is a required field")
    private float price;

    private LocalDate expireDate;

}
