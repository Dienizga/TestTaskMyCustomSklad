package com.example.customwarehousetask.api.json;

import com.example.customwarehousetask.entity.Product;
import com.example.customwarehousetask.entity.Warehouse;
import com.sun.istack.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class SaleRequest {
    @NotNull
    private Long number;
    @NotNull
    private Warehouse warehouse;
    @NotNull
    private List<Product> productList;
}
