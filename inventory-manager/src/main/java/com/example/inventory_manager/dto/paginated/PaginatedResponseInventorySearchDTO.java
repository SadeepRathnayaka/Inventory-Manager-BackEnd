package com.example.inventory_manager.dto.paginated;

import com.example.inventory_manager.dto.response.ResInventorySearchDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseInventorySearchDTO {

    private List<ResInventorySearchDTO> inventorySearchDTOList ;
    private long count;
}
