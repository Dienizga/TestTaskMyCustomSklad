package com.example.customwarehousetask.api.json;

import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import com.sun.istack.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    @NotNull
    private Integer article;
    @NotNull
    private String name;
    @NotNull
    private BigDecimal lastPurchase;
    private BigDecimal lastSale;
    @NotNull
    private WarehouseDTO warehouseDTO;
}
