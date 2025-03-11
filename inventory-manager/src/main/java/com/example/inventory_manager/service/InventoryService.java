package com.example.inventory_manager.service;

import com.example.inventory_manager.dto.paginated.PaginatedResponseInventorySearchDTO;
import com.example.inventory_manager.dto.request.ReqInventorySaveDTO;
import com.example.inventory_manager.dto.request.ReqInventoryUpdateDTO;
import com.example.inventory_manager.dto.response.ResInventoryDTO;
import com.example.inventory_manager.dto.response.ResInventorySearchDTO;

import java.util.List;

public interface InventoryService {
    String saveInventory(ReqInventorySaveDTO reqInventorySaveDTO);

    List<ResInventorySearchDTO> searchInventory(String itemName, Integer itemType, List<Integer> brands);

    PaginatedResponseInventorySearchDTO searchInventoryPage(String itemName, Integer itemType, List<Integer> brands, int page, int size);

    String updateInventory(ReqInventoryUpdateDTO reqInventoryUpdateDTO);

    List<ResInventorySearchDTO> getAllInventory();

    ResInventorySearchDTO deleteInventory(int inventoryId);
}
