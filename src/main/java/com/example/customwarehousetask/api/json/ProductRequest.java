package com.example.customwarehousetask.api.json;

import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    @NotNull
    private Integer article;
    @NotNull
    private String name;
    @NotNull
    private BigDecimal lastPurchase;
    private BigDecimal lastSale;
    @NotNull
    private WarehouseDTO warehouseDTO;

    @JsonCreator
    public ProductRequest(@JsonProperty("article") Integer article,
                          @JsonProperty("name") String name,
                          @JsonProperty("lastPurchase") BigDecimal lastPurchase,
                          @JsonProperty("lastSale") BigDecimal lastSale,
                          @JsonProperty("warehouseDTO") WarehouseDTO warehouseDTO) {
        this.article = article;
        this.name = name;
        this.lastPurchase = lastPurchase;
        this.lastSale = lastSale;
        this.warehouseDTO = warehouseDTO;
    }
}
