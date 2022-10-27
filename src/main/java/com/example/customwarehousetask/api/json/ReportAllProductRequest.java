package com.example.customwarehousetask.api.json;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class ReportAllProductRequest {
    @NotNull
    private String nameProduct;
}
