package com.example.customwarehousetask.api.converter;

import com.example.customwarehousetask.api.json.ProductResponse;
import com.example.customwarehousetask.service.DTO.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductToResponseConverter implements Converter<ProductDTO, ProductResponse> {
    @Override
    public ProductResponse convert(ProductDTO product) {
        return new ProductResponse(
                product.getId(),
                product.getArticle(),
                product.getName(),
                product.getLastPurchase(),
                product.getLastSale(),
                product.getWarehouseDTO()
        );
    }
}
