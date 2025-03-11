package com.example.inventory_manager.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReqOrderSaveDTO {

    private Date orderDate;
    private int userId;
    private List<ReqOrderDetailsSaveDTO> reqOrderDetailsSaveDTOList;
}
