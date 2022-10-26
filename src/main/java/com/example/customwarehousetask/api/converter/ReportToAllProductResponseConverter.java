package com.example.customwarehousetask.api.converter;

import com.example.customwarehousetask.api.json.ReportAllProductResponse;
import com.example.customwarehousetask.entity.Product;
import com.example.customwarehousetask.service.objects.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ReportToAllProductResponseConverter implements Converter<ProductDTO, ReportAllProductResponse> {
    @Override
    public ReportAllProductResponse convert(ProductDTO product) {
        return new ReportAllProductResponse(
                product.getArticle(),
                product.getName(),
                product.getLastPurchase(),
                product.getLastSale()
        );
    }
}
