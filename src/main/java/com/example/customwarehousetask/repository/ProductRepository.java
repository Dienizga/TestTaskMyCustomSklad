package com.example.customwarehousetask.repository;

import com.example.customwarehousetask.entity.Product;
import com.example.customwarehousetask.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByArticle(Integer article);
    List<Product> findAllByName(String name);
    List<Product> findAllByWarehouseListIn(List<Warehouse> warehouseList);
}
