package com.example.customwarehousetask.service.converter;

import com.example.customwarehousetask.api.converter.Converter;
import com.example.customwarehousetask.entity.Product;
import com.example.customwarehousetask.service.DTO.ProductDTO;
import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductToDTOConverter implements Converter<Product, ProductDTO> {
    private WarehouseToDTOConverter warehouseToDTOConverter;

    @Override
    public ProductDTO convert(Product product) {
        WarehouseDTO warehouseDTO = warehouseToDTOConverter.convert(product.getWarehouse());
        return new ProductDTO(
                product.getId(),
                product.getArticle(),
                product.getName(),
                product.getLastPurchase(),
                product.getLastSale(),
                warehouseDTO
        );
    }
}
