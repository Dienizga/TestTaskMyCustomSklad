package com.example.customwarehousetask.api.json;

import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductRequest {
    @NotNull
    private Integer article;
    @NotBlank
    @Size(max = 255)
    private String name;
    @NotNull
    private BigDecimal lastPurchase;
    private BigDecimal lastSale;
    private List<WarehouseDTO> warehouseDTOList;

    @JsonCreator
    public ProductRequest(@JsonProperty("article") Integer article,
                          @JsonProperty("name") String name,
                          @JsonProperty("lastPurchase") BigDecimal lastPurchase,
                          @JsonProperty("lastSale") BigDecimal lastSale,
                          @JsonProperty("warehouse") List<WarehouseDTO> warehouseDTOList) {
        this.article = article;
        this.name = name;
        this.lastPurchase = lastPurchase;
        this.lastSale = lastSale;
        this.warehouseDTOList = warehouseDTOList;
    }
}
