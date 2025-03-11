package com.example.inventory_manager.controller;

import com.example.inventory_manager.dto.paginated.PaginatedResponseInventorySearchDTO;
import com.example.inventory_manager.dto.request.ReqInventorySaveDTO;
import com.example.inventory_manager.dto.request.ReqInventoryUpdateDTO;
import com.example.inventory_manager.dto.response.ResInventoryDTO;
import com.example.inventory_manager.dto.response.ResInventorySearchDTO;
import com.example.inventory_manager.service.InventoryService;
import com.example.inventory_manager.utils.StandardReponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping(path = "/save-inventory")
    public ResponseEntity<StandardReponse> saveInventory(@Valid @RequestBody ReqInventorySaveDTO reqInventorySaveDTO){
        String status = inventoryService.saveInventory(reqInventorySaveDTO);
        return ResponseEntity.ok(new StandardReponse(200, "SUCCESS", status));
    }

    @GetMapping(path = "/search-inventory")
    public ResponseEntity<StandardReponse> searchInventory(
            @RequestParam(required = false) String itemName,
            @RequestParam(required = false) Integer itemType,
            @RequestParam(required = false) List<Integer> brands
            ){
        List<ResInventorySearchDTO> inventorySearchDTOList = inventoryService.searchInventory(itemName, itemType, brands);
        return ResponseEntity.ok(new StandardReponse(200, "SUCCESS", inventorySearchDTOList));
    }

    @GetMapping(
            path = {"/search-inventory-page"},
            params = {"page", "size"}
    )
    public ResponseEntity<StandardReponse> searchInventoryPage(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size,
            @RequestParam(required = false) String itemName,
            @RequestParam(required = false) Integer itemType,
            @RequestParam(required = false) List<Integer> brands
    ){
        PaginatedResponseInventorySearchDTO paginatedResponseInventorySearchDTO = inventoryService.searchInventoryPage(
                itemName, itemType, brands, page, size
        );
        return ResponseEntity.ok(new StandardReponse(200, "SUCCESS", paginatedResponseInventorySearchDTO));
    }

    @PutMapping(path = "/update-inventory")
    public ResponseEntity<StandardReponse> updateInventory(@RequestBody ReqInventoryUpdateDTO reqInventoryUpdateDTO){
        String status = inventoryService.updateInventory(reqInventoryUpdateDTO);
        return ResponseEntity.ok(new StandardReponse(200, "SUCCESS", status));
    }

    @GetMapping(path = "/get-all-inventory")
    public ResponseEntity<StandardReponse> getAllInventory(){
        List<ResInventorySearchDTO> inventorySearchDTOList = inventoryService.getAllInventory();
        return ResponseEntity.ok(new StandardReponse(200, "SUCCESS", inventorySearchDTOList));
    }

    @DeleteMapping(
            path = "delete-inventory",
            params = "inventoryId"
    )
    public ResponseEntity<StandardReponse> deleteInventory(@RequestParam(value = "inventoryId") int inventoryId){
        ResInventorySearchDTO resInventorySearchDTO = inventoryService.deleteInventory(inventoryId);
        return ResponseEntity.ok(new StandardReponse(200, "SUCCESS", resInventorySearchDTO));
    }

}
