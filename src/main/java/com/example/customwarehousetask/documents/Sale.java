package com.example.customwarehousetask.documents;

import com.example.customwarehousetask.entity.Product;
import com.example.customwarehousetask.entity.Warehouse;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class Sale {
    @NotNull
    private Long number;
    @NotNull
    private Warehouse warehouse;@
    NotNull
    private List<Product> productList;

    @Override
    public String toString() {
        return "Sale {" +
                "number = " + number +
                ", warehouse = " + warehouse.getName() +
                ", product list = " + productList.stream()
                .map(p -> p.getName() + ", " + p.getLastSale())
                .collect(Collectors.toList()) +
                ", product quantity = " + productList.size() +
                '}';
    }
}
