package com.example.customwarehousetask.service;

import com.example.customwarehousetask.entity.Product;
import com.example.customwarehousetask.entity.Warehouse;
import com.example.customwarehousetask.repository.ProductRepository;
import com.example.customwarehousetask.service.converter.ProductToDTOConverter;
import com.example.customwarehousetask.service.objects.ProductDTO;
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

    public List<ProductDTO> getAll() {
        return repository.findAll().stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    public ProductDTO create(Integer article, String name, BigDecimal lastPurchase, BigDecimal lastSale, Warehouse warehouse) {
        if (repository.findByArticle(article) != null) {
            return null;
        }
        Product product = new Product();
        product.setArticle(article);
        product.setName(name);
        product.setLastPurchase(lastPurchase);
        product.setLastSale(lastSale);
        product.setWarehouse(warehouse);
        repository.save(product);
        return converter.convert(product);
    }

    public ProductDTO edit(Integer article, String name, BigDecimal lastPurchase, BigDecimal lastSale, Warehouse warehouse) {
        Product product = repository.findByArticle(article);
        if (product == null) {
            return null;
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
        if (warehouse != null) {
            product.setWarehouse(warehouse);
        }
        repository.saveAndFlush(product);
        return converter.convert(product);
    }

    public void delete(Integer article) {
        Product product = repository.findByArticle(article);
        repository.delete(product);
    }

    public List<ProductDTO> getAllByWarehouse(Warehouse warehouse) {
        return repository.findAllByWarehouse(warehouse).stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getAllByName(String name) {
        return repository.findAllByName(name).stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }
}
