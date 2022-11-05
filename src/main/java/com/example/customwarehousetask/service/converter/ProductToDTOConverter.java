package com.example.customwarehousetask.service.converter;

import com.example.customwarehousetask.entity.Product;
import com.example.customwarehousetask.entity.Warehouse;
import com.example.customwarehousetask.service.DTO.ProductDTO;
import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProductToDTOConverter implements Converter<Product, ProductDTO> {
    private WarehouseToDTOConverter warehouseToDTOConverter;

    @Override
    public ProductDTO convert(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getArticle(),
                product.getName(),
                product.getLastPurchase(),
                product.getLastSale(),
                convertToWarehouseDTOList(product.getWarehouseList())
        );
    }

    private List<WarehouseDTO> convertToWarehouseDTOList(List<Warehouse> warehouseList) {
        return warehouseList.stream().map(warehouseToDTOConverter::convert).collect(Collectors.toList());
    }
}
