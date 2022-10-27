package com.example.customwarehousetask.api.json;

import com.example.customwarehousetask.service.DTO.ProductDTO;
import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class AdmissionResponse {
    private Long number;
    private WarehouseDTO warehouseDTO;
    private List<ProductDTO> productList;

    @Override
    public String toString() {
        return "Sale {" +
                "number = " + number +
                ", warehouse = " + warehouseDTO.getName() +
                ", product list = " + productList.stream()
                .map(p -> p.getName() + ", " + p.getLastPurchase())
                .collect(Collectors.toList()) +
                ", product quantity = " + productList.size() +
                '}';
    }
}
