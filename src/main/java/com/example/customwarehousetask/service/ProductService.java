package com.example.customwarehousetask.service;

import com.example.customwarehousetask.entity.Product;
import com.example.customwarehousetask.entity.Warehouse;
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

    public ProductDTO create(Integer article, String name, BigDecimal lastPurchase) {
        if (repository.findByArticle(article) != null) {
            throw new CustomUserException("Such a product already exists!");
        }
        Product product = new Product();
        product.setArticle(article);
        product.setName(name);
        product.setLastPurchase(lastPurchase);
        repository.save(product);
        return converter.convert(product);
    }

    public ProductDTO addWarehouseDTOList(Integer article, List<WarehouseDTO> warehouseDTOList) {
        Product product = repository.findByArticle(article);
        product.setWarehouseList(convertToWarehouseList(warehouseDTOList));
        return converter.convert(product);
    }

    public ProductDTO edit(Integer article, String name, BigDecimal lastPurchase, BigDecimal lastSale, List<WarehouseDTO> warehouseDTOList) {
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
        if (warehouseDTOList != null) {
            product.setWarehouseList(convertToWarehouseList(warehouseDTOList));
        }
        repository.saveAndFlush(product);
        return converter.convert(product);
    }

    public ProductDTO move(Integer article, List<WarehouseDTO> warehouseDTOList) {
        Product product = repository.findByArticle(article);
        if (product == null) {
            throw new CustomUserException("Not found!");
        }
        product.setWarehouseList(convertToWarehouseList(warehouseDTOList));
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

    public List<ProductDTO> getAllByWarehouse(List<WarehouseDTO> warehouseDTOList) {
        return repository.findAllByWarehouseListIn(convertToWarehouseList(warehouseDTOList)).stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getAllByName(String name) {
        return repository.findAllByName(name).stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    private List<Warehouse> convertToWarehouseList(List<WarehouseDTO> warehouseDTOList) {
        return warehouseDTOList.stream()
                .map(toWarehouseConverter::convert)
                .collect(Collectors.toList());
    }
}
