package com.example.customwarehousetask.api.json;

import com.example.customwarehousetask.entity.Warehouse;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReportRemnantsResponse {
    private Integer article;
    private String name;
    private Warehouse warehouse;
}
