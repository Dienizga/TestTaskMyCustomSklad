package com.example.customwarehousetask.service.converter;

import com.example.customwarehousetask.entity.Product;
import com.example.customwarehousetask.entity.Warehouse;
import com.example.customwarehousetask.service.DTO.ProductDTO;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DTOToProductConverter implements Converter<ProductDTO, Product> {
    private DTOToWarehouseConverter toWarehouseConverter;

    @Override
    public Product convert(ProductDTO productDTO) {
        Warehouse warehouse = toWarehouseConverter.convert(productDTO.getWarehouseDTO());
        return new Product(
                productDTO.getId(),
                productDTO.getArticle(),
                productDTO.getName(),
                productDTO.getLastPurchase(),
                productDTO.getLastSale(),
                warehouse
        );
    }
}
