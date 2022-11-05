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
public class DTOToProductConverter implements Converter<ProductDTO, Product> {
    private DTOToWarehouseConverter toWarehouseConverter;

    @Override
    public Product convert(ProductDTO productDTO) {
        return new Product(
                productDTO.getId(),
                productDTO.getArticle(),
                productDTO.getName(),
                productDTO.getLastPurchase(),
                productDTO.getLastSale(),
                convertToWarehouseList(productDTO.getWarehouseDTOList())
        );
    }

    private List<Warehouse> convertToWarehouseList(List<WarehouseDTO> warehouseDTOList) {
        return warehouseDTOList.stream().map(toWarehouseConverter::convert).collect(Collectors.toList());
    }
}
