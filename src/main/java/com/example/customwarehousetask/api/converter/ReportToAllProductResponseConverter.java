package com.example.customwarehousetask.api.converter;

import com.example.customwarehousetask.api.json.ReportAllProductResponse;
import com.example.customwarehousetask.service.DTO.ProductDTO;
import org.springframework.core.convert.converter.Converter;
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
