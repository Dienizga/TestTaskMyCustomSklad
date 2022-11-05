package com.example.customwarehousetask.api.converter;

import com.example.customwarehousetask.api.json.ReportRemnantsResponse;
import com.example.customwarehousetask.service.DTO.ProductDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReportToRemnantsResponseConverter implements Converter<ProductDTO, ReportRemnantsResponse> {
    @Override
    public ReportRemnantsResponse convert(ProductDTO product) {
        return new ReportRemnantsResponse(
                product.getArticle(),
                product.getName(),
                product.getWarehouseDTOList()
        );
    }
}
