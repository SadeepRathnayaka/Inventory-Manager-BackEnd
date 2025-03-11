package com.example.inventory_manager.utils.mappers;

import com.example.inventory_manager.dto.response.ResInventoryDTO;
import com.example.inventory_manager.dto.response.ResInventorySearchDTO;
import com.example.inventory_manager.dto.response.ResOrderDetailsSaveDto;
import com.example.inventory_manager.entity.Inventory;
import com.example.inventory_manager.entity.OrderDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InventoryMapper {

    @Mapping(source = "itemType.type", target = "itemTypeDTO.type")
    @Mapping(source = "itemBrand.itemBrand", target = "itemBrandDTO.itemBrand")
    ResInventoryDTO InventoryToInventoryDto(Inventory inventory);

    List<ResInventoryDTO> InventoryListToInventoryDtoList(List<Inventory> inventoryList);

    @Mapping(source = "inventoryId", target = "inventoryId")
    @Mapping(source = "itemType.type", target = "itemType")
    @Mapping(source = "itemBrand.itemBrand", target = "itemBrand")
    ResInventorySearchDTO InventoryToInventorySearchDto(Inventory inventory);

    List<ResInventorySearchDTO> InventoryToInventorySearchDtoList(List<Inventory> inventoryList);
    List<ResInventorySearchDTO> PageToInventorySearchDtoList(Page<Inventory> inventoryPage);

    @Mapping(source = "inventory.itemName", target = "itemName")
    @Mapping(source = "quantity", target = "quantity")
    ResOrderDetailsSaveDto OrderDetailsToOrderDetailsSaveDto(OrderDetails orderDetails);

    List<ResOrderDetailsSaveDto> OrderDetailsListToOrderDetailsSaveDtoList(List<OrderDetails> orderDetailsList);
}
