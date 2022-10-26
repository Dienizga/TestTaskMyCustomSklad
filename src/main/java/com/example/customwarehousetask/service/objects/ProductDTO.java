package com.example.customwarehousetask.service.objects;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private Integer article;
    private String name;
    private BigDecimal lastPurchase;
    private BigDecimal lastSale;
    private WarehouseDTO warehouseDTO;
}
