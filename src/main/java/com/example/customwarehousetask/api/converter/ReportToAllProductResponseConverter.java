package com.example.customwarehousetask.api.converter;

import com.example.customwarehousetask.api.json.ReportAllProductResponse;
import com.example.customwarehousetask.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ReportToAllProductResponseConverter implements Converter<Product, ReportAllProductResponse> {
    @Override
    public ReportAllProductResponse convert(Product product) {
        return new ReportAllProductResponse(
                product.getArticle(),
                product.getName(),
                product.getLastPurchase(),
                product.getLastSale()
        );
    }
}
