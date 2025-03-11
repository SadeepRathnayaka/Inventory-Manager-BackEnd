package com.example.inventory_manager.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResOrderSaveDTO {

    private int orderId;
    private Date orderDate;
    private String userName;
    private List<ResOrderDetailsSaveDto> resOrderDetailsSaveDtoList;
    private float total;
}
