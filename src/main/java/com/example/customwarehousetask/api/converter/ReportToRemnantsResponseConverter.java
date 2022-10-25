package com.example.customwarehousetask.api.converter;

import com.example.customwarehousetask.api.json.ReportRemnantsResponse;
import com.example.customwarehousetask.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ReportToRemnantsResponseConverter implements Converter<Product, ReportRemnantsResponse> {
    @Override
    public ReportRemnantsResponse convert(Product product) {
        return new ReportRemnantsResponse(
                product.getArticle(),
                product.getName(),
                product.getWarehouse()
        );
    }
}
