package com.example.customwarehousetask.api.json;

import com.example.customwarehousetask.service.DTO.ProductDTO;
import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class MovingRequest {
    @NotNull
    private Long number;
    @NotNull
    private WarehouseDTO warehouseFrom;
    @NotNull
    private WarehouseDTO warehouseTo;
    @NotNull
    private List<ProductDTO> productList;

    @JsonCreator
    public MovingRequest(@JsonProperty("number") Long number,
                       @JsonProperty("warehouseFrom") WarehouseDTO warehouseFrom,
                       @JsonProperty("warehouseTo") WarehouseDTO warehouseTo,
                       @JsonProperty("productDTOList") List<ProductDTO> productDTOList) {
        this.number = number;
        this.warehouseFrom = warehouseFrom;
        this.warehouseTo = warehouseTo;
        this.productList = productDTOList;
    }
}
