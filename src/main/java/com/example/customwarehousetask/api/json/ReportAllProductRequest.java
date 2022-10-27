package com.example.customwarehousetask.api.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class ReportAllProductRequest {
    @NotNull
    private String nameProduct;

    @JsonCreator
    public ReportAllProductRequest(@JsonProperty("nameProduct") String nameProduct) {
        this.nameProduct = nameProduct;
    }
}
