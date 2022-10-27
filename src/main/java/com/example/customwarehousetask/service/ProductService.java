package com.example.customwarehousetask.service;

import com.example.customwarehousetask.entity.Product;
import com.example.customwarehousetask.exception.CustomUserException;
import com.example.customwarehousetask.repository.ProductRepository;
import com.example.customwarehousetask.service.DTO.ProductDTO;
import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import com.example.customwarehousetask.service.converter.DTOToWarehouseConverter;
import com.example.customwarehousetask.service.converter.ProductToDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final ProductToDTOConverter converter;
    private final DTOToWarehouseConverter toWarehouseConverter;

    public List<ProductDTO> getAll() {
        return repository.findAll().stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    public ProductDTO create(Integer article, String name, BigDecimal lastPurchase, WarehouseDTO warehouseDTO) {
        if (repository.findByArticle(article) != null) {
            throw new CustomUserException("Such a product already exists!");
        }
        Product product = new Product();
        product.setArticle(article);
        product.setName(name);
        product.setLastPurchase(lastPurchase);
        product.setWarehouse(toWarehouseConverter.convert(warehouseDTO));
        repository.save(product);
        return converter.convert(product);
    }

    public ProductDTO edit(Integer article, String name, BigDecimal lastPurchase, BigDecimal lastSale, WarehouseDTO warehouseDTO) {
        Product product = repository.findByArticle(article);
        if (product == null) {
            throw new CustomUserException("Not found!");
        }
        if (name != null) {
            product.setName(name);
        }
        if (lastPurchase != null) {
            product.setLastPurchase(lastPurchase);
        }
        if (lastSale != null) {
            product.setLastSale(lastSale);
        }
        if (warehouseDTO != null) {
            product.setWarehouse(toWarehouseConverter.convert(warehouseDTO));
        }
        repository.saveAndFlush(product);
        return converter.convert(product);
    }

    public ProductDTO move(Integer article, WarehouseDTO warehouseDTO) {
        Product product = repository.findByArticle(article);

        product.setWarehouse(toWarehouseConverter.convert(warehouseDTO));
        repository.saveAndFlush(product);
        return converter.convert(product);
    }

    public void delete(Integer article) {
        Product product = repository.findByArticle(article);
        repository.delete(product);
    }

    public ProductDTO writeOff(Integer article, BigDecimal lastSale) {
        Product product = repository.findByArticle(article);
        product.setLastSale(lastSale);
        repository.saveAndFlush(product);
        return converter.convert(product);
    }

    public List<ProductDTO> getAllByWarehouse(WarehouseDTO warehouseDTO) {
        return repository.findAllByWarehouse(toWarehouseConverter.convert(warehouseDTO)).stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getAllByName(String name) {
        return repository.findAllByName(name).stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }
}
