package com.example.customwarehousetask.api.json;

import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReportRemnantsResponse {
    private Integer article;
    private String name;
    private WarehouseDTO warehouseDTO;
}
