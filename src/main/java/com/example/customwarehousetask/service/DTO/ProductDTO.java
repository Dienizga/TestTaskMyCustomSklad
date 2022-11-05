package com.example.customwarehousetask.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private Integer article;
    private String name;
    private BigDecimal lastPurchase;
    private BigDecimal lastSale;
    private List<WarehouseDTO> warehouseDTOList;
}
