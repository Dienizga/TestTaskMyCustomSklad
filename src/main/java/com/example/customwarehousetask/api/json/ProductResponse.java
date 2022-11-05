package com.example.customwarehousetask.api.json;

import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    private Integer article;
    private String name;
    private BigDecimal lastPurchase;
    private BigDecimal lastSale;
    private List<WarehouseDTO> warehouseDTOList;
}
