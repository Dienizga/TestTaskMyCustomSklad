package com.example.customwarehousetask.documents;

import com.example.customwarehousetask.service.objects.ProductDTO;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class Admission {
    @NotNull
    private Long number;
    @NotNull
    private String warehouseName;
    @NotNull
    private List<ProductDTO> productList;

    @Override
    public String toString() {
        return "Sale {" +
                "number = " + number +
                ", warehouse = " + warehouseName +
                ", product list = " + productList.stream()
                .map(p -> p.getName() + ", " + p.getLastPurchase())
                .collect(Collectors.toList()) +
                ", product quantity = " + productList.size() +
                '}';
    }
}
