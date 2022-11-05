package com.example.customwarehousetask.service;

import com.example.customwarehousetask.entity.Warehouse;
import com.example.customwarehousetask.exception.CustomUserException;
import com.example.customwarehousetask.repository.WarehouseRepository;
import com.example.customwarehousetask.service.converter.WarehouseToDTOConverter;
import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WarehouseService {
    private final WarehouseRepository repository;
    private final WarehouseToDTOConverter converter;

    public List<WarehouseDTO> getAll() {
        return repository.findAll().stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    public List<WarehouseDTO> getAllByName(String name) {
        List<Warehouse> warehouseList = repository.findAllByName(name);
        if (warehouseList.isEmpty()) {
            warehouseList.add(add(name));
        }
        return warehouseList.stream().map(converter::convert).collect(Collectors.toList());
    }

    public WarehouseDTO getById(Long id) {
        Warehouse warehouse = repository.findById(id).orElse(null);
        if (warehouse == null) {
            throw new CustomUserException("Not found!");
        }
        return converter.convert(warehouse);
    }

    public WarehouseDTO create(String name) {
        return converter.convert(add(name));
    }

    public WarehouseDTO edit(Long id, String newName) {
        Warehouse warehouse = repository.findById(id).orElse(null);
        if (warehouse == null) {
            throw new CustomUserException("Not found!");
        }
        warehouse.setName(newName);
        repository.saveAndFlush(warehouse);
        return converter.convert(warehouse);
    }

    public void delete(Long id) {
        Warehouse warehouse = repository.findById(id).orElse(null);
        if (warehouse == null) {
            throw new CustomUserException("Not found!");
        }
        repository.delete(warehouse);
    }

    private Warehouse add(String name) {
        Warehouse warehouse = new Warehouse();
        warehouse.setName(name);
        repository.save(warehouse);
        return warehouse;
    }
}
