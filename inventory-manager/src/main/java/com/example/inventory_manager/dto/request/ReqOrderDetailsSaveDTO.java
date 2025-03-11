package com.example.inventory_manager.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReqOrderDetailsSaveDTO {

    private int inventory_id;
    private int quantity;
    private float price;

}
