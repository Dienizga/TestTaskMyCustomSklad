package com.example.customwarehousetask.api.converter;

import com.example.customwarehousetask.api.json.ReportRemnantsResponse;
import com.example.customwarehousetask.service.objects.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ReportToRemnantsResponseConverter implements Converter<ProductDTO, ReportRemnantsResponse> {
    @Override
    public ReportRemnantsResponse convert(ProductDTO product) {
        return new ReportRemnantsResponse(
                product.getArticle(),
                product.getName(),
                product.getWarehouseDTO()
        );
    }
}
