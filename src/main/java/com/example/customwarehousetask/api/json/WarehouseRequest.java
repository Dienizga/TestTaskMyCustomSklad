package com.example.customwarehousetask.api.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class WarehouseRequest {
    @NotNull
    private String name;
    private String newName;

    @JsonCreator
    public WarehouseRequest(@JsonProperty("name") String name, @JsonProperty("newName") String newName) {
        this.name = name;
        this.newName = newName;
    }
}
