package com.example.customwarehousetask.api.json;

import com.example.customwarehousetask.service.DTO.ProductDTO;
import com.example.customwarehousetask.service.DTO.WarehouseDTO;
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
}
