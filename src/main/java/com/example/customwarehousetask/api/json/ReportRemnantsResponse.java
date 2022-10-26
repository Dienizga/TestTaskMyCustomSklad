package com.example.customwarehousetask.api.json;

import com.example.customwarehousetask.service.objects.WarehouseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReportRemnantsResponse {
    private Integer article;
    private String name;
    private WarehouseDTO warehouseDTO;
}
