package com.example.customwarehousetask.api.json;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class WarehouseRequest {
    @NotNull
    private String name;

    private String newName;
}
