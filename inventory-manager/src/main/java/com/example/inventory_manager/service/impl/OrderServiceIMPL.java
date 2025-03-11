package com.example.inventory_manager.service.impl;

import com.example.inventory_manager.dto.request.ReqOrderSaveDTO;
import com.example.inventory_manager.dto.response.ResOrderDetailsSaveDto;
import com.example.inventory_manager.dto.response.ResOrderSaveDTO;
import com.example.inventory_manager.entity.Order;
import com.example.inventory_manager.entity.OrderDetails;
import com.example.inventory_manager.repo.InventoryRepo;
import com.example.inventory_manager.repo.OrderDetailsRepo;
import com.example.inventory_manager.repo.OrderRepo;
import com.example.inventory_manager.repo.UserRepo;
import com.example.inventory_manager.service.OrderService;
import com.example.inventory_manager.utils.mappers.InventoryMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private InventoryMapper inventoryMapper;

    @Override
    @Transactional
    public ResOrderSaveDTO saveOrder(ReqOrderSaveDTO reqOrderSaveDTO) {

        Order order = new Order();
        order.setOrderDate(reqOrderSaveDTO.getOrderDate());
        order.setUser(userRepo.getById(reqOrderSaveDTO.getUserId()));

        List<OrderDetails> orderDetailsList = modelMapper.map(reqOrderSaveDTO.getReqOrderDetailsSaveDTOList(), new TypeToken<List<OrderDetails>>(){}.getType());

        float total = 0;
        for (int i = 0; i < orderDetailsList.size(); i++ ){
            orderDetailsList.get(i).setOrder(order);
            orderDetailsList.get(i).setInventory(inventoryRepo.getById(reqOrderSaveDTO.getReqOrderDetailsSaveDTOList().get(i).getInventory_id()));

            total += (orderDetailsList.get(i).getQuantity() * orderDetailsList.get(i).getPrice());
        }

        order.setTotal(total);
        orderRepo.save(order);
        orderDetailsRepo.saveAll(orderDetailsList);

        ResOrderSaveDTO resOrderSaveDTO = new ResOrderSaveDTO(
                order.getOderId(),
                order.getOrderDate(),
                order.getUser().getUserName(),
                inventoryMapper.OrderDetailsListToOrderDetailsSaveDtoList(orderDetailsList),
                order.getTotal()
        );
        return resOrderSaveDTO;
    }
}
