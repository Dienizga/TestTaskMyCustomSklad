package com.example.customwarehousetask.service;

import com.example.customwarehousetask.entity.Warehouse;
import com.example.customwarehousetask.repository.WarehouseRepository;
import com.example.customwarehousetask.service.converter.WarehouseToDTOConverter;
import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WarehouseServiceTest {
    @InjectMocks WarehouseService subj;
    @Mock WarehouseRepository repository;
    @Mock WarehouseToDTOConverter toDTOConverter;

    @Test
    void getAll() {
        List<Warehouse> warehouseList = getWarehouseList();
        when(repository.findAll()).thenReturn(warehouseList);

        List<WarehouseDTO> warehouseDTOList = subj.getAll();
        assertNotNull(warehouseDTOList);

        verify(repository, times(1)).findAll();
    }

    @Test
    void getByName() {
        List<Warehouse> warehouseList = getWarehouseList();
        when(repository.findAllByName("name")).thenReturn(warehouseList);

        List<WarehouseDTO> warehouseDTOList = subj.getAllByName("name");
        assertEquals(warehouseDTOList, warehouseList.stream().map(toDTOConverter::convert).collect(Collectors.toList()));
    }

    @Test
    void create() {
        Warehouse warehouse = getWarehouse();
        when(repository.save(any())).thenReturn(warehouse);

        WarehouseDTO warehouseDTO = subj.create("name");

        assertEquals(warehouseDTO, toDTOConverter.convert(warehouse));
    }

    @Test
    void edit() {
        Warehouse warehouse = getWarehouse();
        when(repository.findById(1L)).thenReturn(Optional.of(warehouse));
        subj.edit(1L, "Name2");

        verify(repository, times(1)).findById(1L);
    }

    @Test
    void delete() {
        Warehouse warehouse = getWarehouse();
        when(repository.findById(1L)).thenReturn(Optional.of(warehouse));
        subj.delete(1L);

        verify(repository, times(1)).findById(1L);
    }

    private List<Warehouse> getWarehouseList() {
        return Collections.singletonList(new Warehouse(1L,"name"));
    }

    private Warehouse getWarehouse() {
        return new Warehouse(1L, "name");
    }
}