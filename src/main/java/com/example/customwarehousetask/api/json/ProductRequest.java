package com.example.customwarehousetask.api.json;

import com.example.customwarehousetask.entity.Warehouse;
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
    @NotNull
    private BigDecimal lastSale;
    @NotNull
    private Warehouse warehouse;
}
