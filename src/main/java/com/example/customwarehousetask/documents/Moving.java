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
public class Moving {
    @NotNull
    private Long number;
    @NotNull
    private String warehouse1;
    @NotNull
    private String warehouse2;
    @NotNull
    private List<Product> productList;

    @Override
    public String toString() {
        return "Moving { " +
                "number = " + number +
                ", warehouse 1 = " + warehouse1 +
                ", warehouse 2 = " + warehouse2 +
                ", product list = " + productList.stream()
                .map(Product::getName)
                .collect(Collectors.toList()) +
                ", product quantity = " + productList.size() +
                '}';
    }
}
