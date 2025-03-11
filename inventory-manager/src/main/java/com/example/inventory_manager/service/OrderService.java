package com.example.inventory_manager.service;

import com.example.inventory_manager.dto.request.ReqOrderSaveDTO;
import com.example.inventory_manager.dto.response.ResOrderSaveDTO;

public interface OrderService {
    ResOrderSaveDTO saveOrder(ReqOrderSaveDTO reqOrderSaveDTO);
}
