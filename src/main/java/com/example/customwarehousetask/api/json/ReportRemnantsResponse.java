package com.example.customwarehousetask.api.json;

import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ReportRemnantsResponse {
    private Integer article;
    private String name;
    private List<WarehouseDTO> warehouseDTOList;
}
