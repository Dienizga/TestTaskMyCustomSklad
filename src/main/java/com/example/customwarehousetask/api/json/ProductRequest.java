package com.example.customwarehousetask.api.json;

import com.example.customwarehousetask.entity.Warehouse;
import com.sun.istack.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    @NotNull
    private Integer article;
    private String name;
    private BigDecimal lastPurchase;
    private BigDecimal lastSale;
    private Warehouse warehouse;
}
