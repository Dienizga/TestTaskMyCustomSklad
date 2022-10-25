package com.example.customwarehousetask.api.converter;

import com.example.customwarehousetask.api.json.ProductResponse;
import com.example.customwarehousetask.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductToResponseConverter implements Converter<Product, ProductResponse> {
    @Override
    public ProductResponse convert(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getArticle(),
                product.getName(),
                product.getLastPurchase(),
                product.getLastSale(),
                product.getWarehouse()
        );
    }
}
