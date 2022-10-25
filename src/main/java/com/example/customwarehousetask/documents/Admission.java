package com.example.customwarehousetask.documents;

import com.example.customwarehousetask.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class Admission {
    private Long number;
    private String warehouseName;
    private List<Product> productList;

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
