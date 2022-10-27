package com.example.customwarehousetask.api.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class ReportRemnantsRequest {
    @NotNull
    private String nameWarehouse;

    @JsonCreator
    public ReportRemnantsRequest(@JsonProperty("nameWarehouse") String nameWarehouse) {
        this.nameWarehouse = nameWarehouse;
    }
}
