package com.example.customwarehousetask.api.json;

import com.example.customwarehousetask.service.DTO.ProductDTO;
import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class MovingResponse {
    private Long number;
    private WarehouseDTO warehouseFrom;
    private WarehouseDTO warehouseTo;
    private List<ProductDTO> productList;

    @Override
    public String toString() {
        return "Moving { " +
                "number = " + number +
                ", warehouse from = " + warehouseFrom +
                ", warehouse to = " + warehouseTo +
                ", product list = " + productList.stream()
                .map(ProductDTO::getName)
                .collect(Collectors.toList()) +
                ", product quantity = " + productList.size() +
                '}';
    }
}
