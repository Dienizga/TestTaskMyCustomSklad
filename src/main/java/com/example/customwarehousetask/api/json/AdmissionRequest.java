package com.example.customwarehousetask.api.json;

import com.example.customwarehousetask.service.DTO.ProductDTO;
import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class AdmissionRequest {
    @NotNull
    private Long number;
    @NotNull
    private WarehouseDTO warehouseDTO;
    @NotNull
    private List<ProductDTO> productList;

    @JsonCreator
    public AdmissionRequest(@JsonProperty("number") Long number,
                       @JsonProperty("warehouseDTO") WarehouseDTO warehouseDTO,
                       @JsonProperty("productDTOList") List<ProductDTO> productDTOList) {
        this.number = number;
        this.warehouseDTO = warehouseDTO;
        this.productList = productDTOList;
    }
}
