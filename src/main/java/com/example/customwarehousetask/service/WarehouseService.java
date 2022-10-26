package com.example.customwarehousetask.service;

import com.example.customwarehousetask.entity.Warehouse;
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

    public WarehouseDTO getByName(String name) {
        if (repository.findByName(name) == null) {
            return converter.convert(add(name));
        }
        return converter.convert(repository.findByName(name));
    }

    public WarehouseDTO create(String name) {
        if (repository.findByName(name) != null) {
            return null;
        }
        return converter.convert(add(name));
    }

    public WarehouseDTO edit(String lastName, String newName) {
        Warehouse warehouse = repository.findByName(lastName);
        if (warehouse == null) {
            return null;
        }
        warehouse.setName(newName);
        repository.saveAndFlush(warehouse);
        return converter.convert(warehouse);
    }

    public void delete(String name) {
        Warehouse warehouse = repository.findByName(name);
        repository.delete(warehouse);
    }

    private Warehouse add(String name) {
        Warehouse warehouse = new Warehouse();
        warehouse.setName(name);
        repository.save(warehouse);
        return warehouse;
    }
}
