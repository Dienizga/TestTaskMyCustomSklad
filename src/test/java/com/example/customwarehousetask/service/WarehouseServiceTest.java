package com.example.customwarehousetask.service;

import com.example.customwarehousetask.entity.Warehouse;
import com.example.customwarehousetask.repository.WarehouseRepository;
import com.example.customwarehousetask.service.converter.WarehouseToDTOConverter;
import com.example.customwarehousetask.service.objects.WarehouseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

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
        List<Warehouse> warehouseList = Collections.singletonList(new Warehouse(1L,"name"));
        when(repository.findAll()).thenReturn(warehouseList);

        List<WarehouseDTO> warehouseDTOList = subj.getAll();
        assertNotNull(warehouseDTOList);

        verify(repository, times(1)).findAll();
    }

    @Test
    void getByName() {
        Warehouse warehouse = new Warehouse();
        warehouse.setName("name");
        when(repository.findByName("name")).thenReturn(warehouse);

        WarehouseDTO warehouseDTO = subj.getByName("name");
        assertEquals(warehouseDTO, toDTOConverter.convert(warehouse));
    }

    @Test
    void create() {
        Warehouse warehouse = new Warehouse(1L, "name");
        when(repository.save(any())).thenReturn(warehouse);

        WarehouseDTO warehouseDTO = subj.create("name");

        assertEquals(warehouseDTO, toDTOConverter.convert(warehouse));
    }

    @Test
    void edit() {
        Warehouse warehouse = new Warehouse();
        warehouse.setName("name1");
        subj.edit("name1", "Name2");

        verify(repository, times(1)).findByName("name1");
    }

    @Test
    void delete() {
        Warehouse warehouse = new Warehouse();
        warehouse.setName("name1");
        subj.delete("name1");

        verify(repository, times(1)).findByName("name1");
    }
}