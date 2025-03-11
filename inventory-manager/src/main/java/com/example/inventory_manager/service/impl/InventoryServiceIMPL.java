package com.example.inventory_manager.service.impl;

import com.example.inventory_manager.dto.paginated.PaginatedResponseInventorySearchDTO;
import com.example.inventory_manager.dto.request.ReqInventorySaveDTO;
import com.example.inventory_manager.dto.request.ReqInventoryUpdateDTO;
import com.example.inventory_manager.dto.response.ResInventoryDTO;
import com.example.inventory_manager.dto.response.ResInventorySearchDTO;
import com.example.inventory_manager.entity.Inventory;
import com.example.inventory_manager.exceptions.NoItemFoundException;
import com.example.inventory_manager.repo.BrandRepo;
import com.example.inventory_manager.repo.InventoryRepo;
import com.example.inventory_manager.repo.ItemTypeRepo;
import com.example.inventory_manager.service.InventoryService;
import com.example.inventory_manager.utils.mappers.InventoryMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceIMPL implements InventoryService {

    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private BrandRepo brandRepo;

    @Autowired
    private ItemTypeRepo itemTypeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private InventoryMapper inventoryMapper;

    @Override
    public String saveInventory(ReqInventorySaveDTO reqInventorySaveDTO) {
        Inventory inventory = modelMapper.map(reqInventorySaveDTO, Inventory.class);

        inventory.setItemType(itemTypeRepo.getById(reqInventorySaveDTO.getItemType()));
        inventory.setItemBrand(brandRepo.getById(reqInventorySaveDTO.getItemBrand()));
        inventoryRepo.save(inventory);
        return "Inventory Item added successfully";
    }

    @Override
    public List<ResInventorySearchDTO> searchInventory(String itemName, Integer itemType, List<Integer> brands) {
        List<Inventory> inventoryList = inventoryRepo.searchInventory(itemName, itemType, brands);
        List<ResInventorySearchDTO> inventorySearchDTOList = inventoryMapper.InventoryToInventorySearchDtoList(inventoryList);

        if (inventorySearchDTOList.size() > 0){
            return inventorySearchDTOList;
        }else {
            throw new NoItemFoundException("No items found");
        }
    }

    @Override
    public PaginatedResponseInventorySearchDTO searchInventoryPage(String itemName, Integer itemType, List<Integer> brands, int page, int size) {
        Page<Inventory> inventoryPage = inventoryRepo.searchInventory(itemName, itemType, brands, PageRequest.of(page, size));
        List<ResInventorySearchDTO> inventorySearchDTOList = inventoryMapper.PageToInventorySearchDtoList(inventoryPage);
        long count = inventoryRepo.countInventory(itemName, itemType, brands);

        if (count > 0){
            return new PaginatedResponseInventorySearchDTO(
                    inventorySearchDTOList,
                    count
            );
        }else{
            throw new NoItemFoundException("No items found");
        }
    }

    @Override
    public String updateInventory(ReqInventoryUpdateDTO reqInventoryUpdateDTO) {

        if (inventoryRepo.existsById(reqInventoryUpdateDTO.getInventoryId())){

            Inventory inventory = inventoryRepo.getById(reqInventoryUpdateDTO.getInventoryId());

            inventory.setItemType(itemTypeRepo.getById(reqInventoryUpdateDTO.getItemType()));
            inventory.setItemName(reqInventoryUpdateDTO.getItemName());
            inventory.setItemBrand(brandRepo.getById(reqInventoryUpdateDTO.getItemBrand()));
            inventory.setDescription(reqInventoryUpdateDTO.getDescription());
            inventory.setPrice(reqInventoryUpdateDTO.getPrice());
            inventory.setExpireDate(reqInventoryUpdateDTO.getExpireDate());

            inventoryRepo.save(inventory);
            return "Inventory updated successfully";
        }else {
            throw new NoItemFoundException("No inventory found");
        }

    }

    @Override
    public List<ResInventorySearchDTO> getAllInventory() {
        List<Inventory> inventoryList = inventoryRepo.findAll();
        List<ResInventorySearchDTO> inventorySearchDTOList = inventoryMapper.InventoryToInventorySearchDtoList(inventoryList);

        if (inventorySearchDTOList.size() > 0){
            return inventorySearchDTOList;
        }else {
            throw new NoItemFoundException("No inventory found");
        }
    }

    @Override
    public ResInventorySearchDTO deleteInventory(int inventoryId) {

        if (inventoryRepo.existsById(inventoryId)){
            Inventory inventory = inventoryRepo.getById(inventoryId);
            ResInventorySearchDTO resInventorySearchDTO = inventoryMapper.InventoryToInventorySearchDto(inventory);
            inventoryRepo.deleteById(inventoryId);
            return resInventorySearchDTO;
        }else {
            throw new NoItemFoundException("No inventory found");
        }
    }
}
