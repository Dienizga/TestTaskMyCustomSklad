package com.example.customwarehousetask.api.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class WarehouseRequest {
    private Long id;
    @NotBlank
    @Size(max = 255)
    private String name;

    private String newName;

    @JsonCreator
    public WarehouseRequest(@JsonProperty("id") Long id, @JsonProperty("name") String name, @JsonProperty("newName") String newName) {
        this.id = id;
        this.name = name;
        this.newName = newName;
    }
}
