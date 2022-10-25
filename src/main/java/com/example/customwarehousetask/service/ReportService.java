package com.example.customwarehousetask.service;

import com.example.customwarehousetask.entity.Product;
import com.example.customwarehousetask.entity.Warehouse;
import com.example.customwarehousetask.repository.ProductRepository;
import com.example.customwarehousetask.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ProductRepository productRepository;
    private final WarehouseRepository warehouseRepository;

    public List<Product> getAllProductList(String name) {
        if (name == null) {
            return productRepository.findAll();
        }
        return productRepository.findAllByName(name);
    }

    public List<Product> getRemnants(String warehouseName) {
        if (warehouseName == null) {
            return productRepository.findAll();
        }
        Warehouse warehouse = warehouseRepository.findByName(warehouseName);
        return productRepository.findAllByWarehouse(warehouse);
    }
}
