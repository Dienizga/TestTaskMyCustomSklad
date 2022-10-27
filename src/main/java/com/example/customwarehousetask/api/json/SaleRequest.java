package com.example.customwarehousetask.api.json;

import com.example.customwarehousetask.service.DTO.ProductDTO;
import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class SaleRequest {
    @NotNull
    private Long number;
    @NotNull
    private WarehouseDTO warehouseDTO;
    @NotNull
    private List<ProductDTO> productDTOList;

    @JsonCreator
    public SaleRequest(@JsonProperty("number") Long number,
                          @JsonProperty("warehouseDTO") WarehouseDTO warehouseDTO,
                          @JsonProperty("productDTOList") List<ProductDTO> productDTOList) {
        this.number = number;
        this.warehouseDTO = warehouseDTO;
        this.productDTOList = productDTOList;
    }
}
