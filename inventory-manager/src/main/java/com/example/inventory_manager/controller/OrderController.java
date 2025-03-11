package com.example.inventory_manager.controller;

import com.example.inventory_manager.dto.request.ReqOrderSaveDTO;
import com.example.inventory_manager.dto.response.ResOrderSaveDTO;
import com.example.inventory_manager.service.OrderService;
import com.example.inventory_manager.utils.StandardReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "save-order")
    public ResponseEntity<StandardReponse> saveOrder(@RequestBody ReqOrderSaveDTO reqOrderSaveDTO){
        ResOrderSaveDTO resOrderSaveDTO = orderService.saveOrder(reqOrderSaveDTO);
        return ResponseEntity.ok(new StandardReponse(200, "SUCCESS", resOrderSaveDTO));
    }
}
