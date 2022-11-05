package com.example.customwarehousetask.service;

import com.example.customwarehousetask.service.DTO.ProductDTO;
import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ProductService productService;
    private final WarehouseService warehouseService;

    @Transactional
    public List<ProductDTO> getAllProductList(String name) {
        if (name == null) {
            return productService.getAll();
        }
        return productService.getAllByName(name);
    }

    @Transactional
    public List<ProductDTO> getRemnants(String warehouseName) {
        if (warehouseName == null) {
            return productService.getAll();
        }
        List<WarehouseDTO> warehouseDTOList = warehouseService.getAllByName(warehouseName);
        return productService.getAllByWarehouse(warehouseDTOList);
    }
}
