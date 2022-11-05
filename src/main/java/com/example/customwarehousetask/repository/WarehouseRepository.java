package com.example.customwarehousetask.repository;

import com.example.customwarehousetask.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    List<Warehouse> findAllByName(String name);
}
