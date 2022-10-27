package com.example.customwarehousetask.api.json;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class ReportRemnantsRequest {
    @NotNull
    private String nameWarehouse;
}
