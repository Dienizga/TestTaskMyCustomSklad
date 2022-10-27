package com.example.customwarehousetask.api.json;

import com.example.customwarehousetask.entity.Product;
import com.example.customwarehousetask.entity.Warehouse;
import com.example.customwarehousetask.service.DTO.ProductDTO;
import com.example.customwarehousetask.service.DTO.WarehouseDTO;
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
}
