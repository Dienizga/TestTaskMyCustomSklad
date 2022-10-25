package com.example.customwarehousetask.service;

import com.example.customwarehousetask.entity.Warehouse;
import com.example.customwarehousetask.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarehouseService {
    private final WarehouseRepository repository;

    public List<Warehouse> getAll() {
        return repository.findAll();
    }

    public Warehouse getByName(String name) {
        return repository.findByName(name);
    }

    public Warehouse create(String name) {
        if (repository.findAll().stream().anyMatch(w -> w.getName().equalsIgnoreCase(name))) {
            return null;
        }
        Warehouse warehouse = new Warehouse();
        warehouse.setName(name);
        repository.save(warehouse);
        return warehouse;
    }

    public Warehouse edit(String lastName, String newName) {
        Warehouse warehouse = repository.findByName(lastName);
        if (warehouse == null) {
            return null;
        }
        warehouse.setName(newName);
        repository.saveAndFlush(warehouse);
        return warehouse;
    }

    public void delete(String name) {
        Warehouse warehouse = repository.findByName(name);
        repository.delete(warehouse);
    }
}
