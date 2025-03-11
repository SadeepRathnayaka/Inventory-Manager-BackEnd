package com.example.inventory_manager.utils.mappers;

import com.example.inventory_manager.dto.BrandDTO;
import com.example.inventory_manager.dto.ItemTypeDTO;
import com.example.inventory_manager.dto.response.ResInventoryDTO;
import com.example.inventory_manager.dto.response.ResInventorySearchDTO;
import com.example.inventory_manager.dto.response.ResOrderDetailsSaveDto;
import com.example.inventory_manager.entity.Brand;
import com.example.inventory_manager.entity.Inventory;
import com.example.inventory_manager.entity.ItemType;
import com.example.inventory_manager.entity.OrderDetails;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-10T20:55:50+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class InventoryMapperImpl implements InventoryMapper {

    @Override
    public ResInventoryDTO InventoryToInventoryDto(Inventory inventory) {
        if ( inventory == null ) {
            return null;
        }

        ResInventoryDTO resInventoryDTO = new ResInventoryDTO();

        resInventoryDTO.setItemTypeDTO( itemTypeToItemTypeDTO( inventory.getItemType() ) );
        resInventoryDTO.setItemBrandDTO( brandToBrandDTO( inventory.getItemBrand() ) );
        resInventoryDTO.setItemName( inventory.getItemName() );
        resInventoryDTO.setDescription( inventory.getDescription() );
        resInventoryDTO.setPrice( inventory.getPrice() );
        resInventoryDTO.setExpireDate( inventory.getExpireDate() );

        return resInventoryDTO;
    }

    @Override
    public List<ResInventoryDTO> InventoryListToInventoryDtoList(List<Inventory> inventoryList) {
        if ( inventoryList == null ) {
            return null;
        }

        List<ResInventoryDTO> list = new ArrayList<ResInventoryDTO>( inventoryList.size() );
        for ( Inventory inventory : inventoryList ) {
            list.add( InventoryToInventoryDto( inventory ) );
        }

        return list;
    }

    @Override
    public ResInventorySearchDTO InventoryToInventorySearchDto(Inventory inventory) {
        if ( inventory == null ) {
            return null;
        }

        ResInventorySearchDTO resInventorySearchDTO = new ResInventorySearchDTO();

        resInventorySearchDTO.setInventoryId( inventory.getInventoryId() );
        resInventorySearchDTO.setItemType( inventoryItemTypeType( inventory ) );
        resInventorySearchDTO.setItemBrand( inventoryItemBrandItemBrand( inventory ) );
        resInventorySearchDTO.setItemName( inventory.getItemName() );
        resInventorySearchDTO.setDescription( inventory.getDescription() );
        resInventorySearchDTO.setPrice( inventory.getPrice() );
        resInventorySearchDTO.setExpireDate( inventory.getExpireDate() );

        return resInventorySearchDTO;
    }

    @Override
    public List<ResInventorySearchDTO> InventoryToInventorySearchDtoList(List<Inventory> inventoryList) {
        if ( inventoryList == null ) {
            return null;
        }

        List<ResInventorySearchDTO> list = new ArrayList<ResInventorySearchDTO>( inventoryList.size() );
        for ( Inventory inventory : inventoryList ) {
            list.add( InventoryToInventorySearchDto( inventory ) );
        }

        return list;
    }

    @Override
    public List<ResInventorySearchDTO> PageToInventorySearchDtoList(Page<Inventory> inventoryPage) {
        if ( inventoryPage == null ) {
            return null;
        }

        List<ResInventorySearchDTO> list = new ArrayList<ResInventorySearchDTO>();
        for ( Inventory inventory : inventoryPage ) {
            list.add( InventoryToInventorySearchDto( inventory ) );
        }

        return list;
    }

    @Override
    public ResOrderDetailsSaveDto OrderDetailsToOrderDetailsSaveDto(OrderDetails orderDetails) {
        if ( orderDetails == null ) {
            return null;
        }

        ResOrderDetailsSaveDto resOrderDetailsSaveDto = new ResOrderDetailsSaveDto();

        resOrderDetailsSaveDto.setItemName( orderDetailsInventoryItemName( orderDetails ) );
        resOrderDetailsSaveDto.setQuantity( orderDetails.getQuantity() );

        return resOrderDetailsSaveDto;
    }

    @Override
    public List<ResOrderDetailsSaveDto> OrderDetailsListToOrderDetailsSaveDtoList(List<OrderDetails> orderDetailsList) {
        if ( orderDetailsList == null ) {
            return null;
        }

        List<ResOrderDetailsSaveDto> list = new ArrayList<ResOrderDetailsSaveDto>( orderDetailsList.size() );
        for ( OrderDetails orderDetails : orderDetailsList ) {
            list.add( OrderDetailsToOrderDetailsSaveDto( orderDetails ) );
        }

        return list;
    }

    protected ItemTypeDTO itemTypeToItemTypeDTO(ItemType itemType) {
        if ( itemType == null ) {
            return null;
        }

        ItemTypeDTO itemTypeDTO = new ItemTypeDTO();

        itemTypeDTO.setType( itemType.getType() );
        itemTypeDTO.setItemTypeId( itemType.getItemTypeId() );

        return itemTypeDTO;
    }

    protected BrandDTO brandToBrandDTO(Brand brand) {
        if ( brand == null ) {
            return null;
        }

        BrandDTO brandDTO = new BrandDTO();

        brandDTO.setItemBrand( brand.getItemBrand() );
        brandDTO.setBrandId( brand.getBrandId() );

        return brandDTO;
    }

    private String inventoryItemTypeType(Inventory inventory) {
        if ( inventory == null ) {
            return null;
        }
        ItemType itemType = inventory.getItemType();
        if ( itemType == null ) {
            return null;
        }
        String type = itemType.getType();
        if ( type == null ) {
            return null;
        }
        return type;
    }

    private String inventoryItemBrandItemBrand(Inventory inventory) {
        if ( inventory == null ) {
            return null;
        }
        Brand itemBrand = inventory.getItemBrand();
        if ( itemBrand == null ) {
            return null;
        }
        String itemBrand1 = itemBrand.getItemBrand();
        if ( itemBrand1 == null ) {
            return null;
        }
        return itemBrand1;
    }

    private String orderDetailsInventoryItemName(OrderDetails orderDetails) {
        if ( orderDetails == null ) {
            return null;
        }
        Inventory inventory = orderDetails.getInventory();
        if ( inventory == null ) {
            return null;
        }
        String itemName = inventory.getItemName();
        if ( itemName == null ) {
            return null;
        }
        return itemName;
    }
}
