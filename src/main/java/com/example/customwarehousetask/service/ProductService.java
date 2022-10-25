package com.example.customwarehousetask.service;

import com.example.customwarehousetask.entity.Product;
import com.example.customwarehousetask.entity.Warehouse;
import com.example.customwarehousetask.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product create(Integer article, String name, BigDecimal lastPurchase, BigDecimal lastSale, Warehouse warehouse) {
        if (repository.findAll().stream().anyMatch(p -> p.getArticle().equals(article))) {
            return null;
        }
        Product product = new Product();
        product.setArticle(article);
        product.setName(name);
        product.setLastPurchase(lastPurchase);
        product.setLastSale(lastSale);
        product.setWarehouse(warehouse);
        repository.save(product);
        return product;
    }

    public Product edit(Integer article, String name, BigDecimal lastPurchase, BigDecimal lastSale, Warehouse warehouse) {
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
        return product;
    }

    public void delete(Integer article) {
        Product product = repository.findByArticle(article);
        repository.delete(product);
    }
}
