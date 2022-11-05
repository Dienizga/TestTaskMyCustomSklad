package com.example.customwarehousetask.service;

import com.example.customwarehousetask.entity.Product;
import com.example.customwarehousetask.entity.Warehouse;
import com.example.customwarehousetask.repository.ProductRepository;
import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import com.example.customwarehousetask.service.converter.DTOToWarehouseConverter;
import com.example.customwarehousetask.service.converter.ProductToDTOConverter;
import com.example.customwarehousetask.service.DTO.ProductDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @InjectMocks ProductService subj;
    @Mock ProductRepository repository;
    @Mock ProductToDTOConverter toDTOConverter;
    @Mock DTOToWarehouseConverter toWarehouseConverter;

    @Test
    void getAll() {
        List<Product> productList = Collections.singletonList(new Product());
        when(repository.findAll()).thenReturn(productList);

        List<ProductDTO> productDTOS = subj.getAll();
        assertNotNull(productDTOS);

        verify(repository, times(1)).findAll();
    }

    @Test
    void create() {
        List<Warehouse> warehouseList = Collections.singletonList(new Warehouse());
        Product product = new Product(1L, 11, "name", BigDecimal.valueOf(10000), BigDecimal.valueOf(1000), warehouseList);
        when(repository.save(any())).thenReturn(product);
//        Warehouse warehouse = new Warehouse(1L, "name");
//        when(toWarehouseConverter.convert(any())).thenReturn(warehouse);
        ProductDTO productDTO = subj.create(11, "name", BigDecimal.valueOf(10000));

        assertEquals(productDTO, toDTOConverter.convert(product));
    }

    @Test
    void edit() {
        List<Warehouse> warehouseList = Collections.singletonList(new Warehouse());
        Product product = new Product(1L, 11, "name", BigDecimal.valueOf(10000), BigDecimal.valueOf(1000), warehouseList);
        when(repository.findByArticle(any())).thenReturn(product);
        Warehouse warehouse = new Warehouse(1L, "name");
        List<WarehouseDTO> warehouseDTOList = Collections.singletonList(new WarehouseDTO(1L, "name"));
        when(toWarehouseConverter.convert(any())).thenReturn(warehouse);
        ProductDTO productDTO = subj.edit(11, "name", BigDecimal.valueOf(10000), BigDecimal.valueOf(1000), warehouseDTOList);

        assertEquals(productDTO, toDTOConverter.convert(product));
        verify(repository, times(1)).saveAndFlush(product);
    }

    @Test
    void delete() {
        subj.delete(11);
        verify(repository, times(1)).findByArticle(11);
    }

    @Test
    void move() {
        List<Warehouse> warehouseList = Collections.singletonList(new Warehouse());
        Product product = new Product(1L, 11, "name", BigDecimal.valueOf(10000), BigDecimal.valueOf(1000), warehouseList);
        when(repository.findByArticle(any())).thenReturn(product);
        Warehouse warehouse = new Warehouse(1L, "name");
        List<WarehouseDTO> warehouseDTOList = Collections.singletonList(new WarehouseDTO(1L, "name"));
        when(toWarehouseConverter.convert(any())).thenReturn(warehouse);
        ProductDTO productDTO = subj.move(11, warehouseDTOList);

        assertEquals(productDTO, toDTOConverter.convert(product));
        verify(repository, times(1)).saveAndFlush(product);
    }

    @Test
    void writeOff() {
        List<Warehouse> warehouseList = Collections.singletonList(new Warehouse());
        Product product = new Product(1L, 11, "name", BigDecimal.valueOf(10000), BigDecimal.valueOf(1000), warehouseList);
        when(repository.findByArticle(any())).thenReturn(product);
        ProductDTO productDTO = subj.writeOff(11, BigDecimal.valueOf(1000));

        assertEquals(productDTO, toDTOConverter.convert(product));
        verify(repository, times(1)).saveAndFlush(product);
    }

    @Test
    void getAllByWarehouse() {
        List<Warehouse> warehouseList = Collections.singletonList(new Warehouse(1L, "name"));
        List<Product> productList = Collections.singletonList(new Product(1L, 11, "name", BigDecimal.valueOf(10000), BigDecimal.valueOf(1000), warehouseList));
        when(repository.findAllByWarehouseListIn(warehouseList)).thenReturn(productList);
        when(toWarehouseConverter.convert(any())).thenReturn(warehouseList.get(0));

        List<WarehouseDTO> warehouseDTOList = Collections.singletonList(new WarehouseDTO(1L, "name"));
        List<ProductDTO> productDTOS = subj.getAllByWarehouse(warehouseDTOList);
        assertNotNull(productDTOS);

        verify(repository, times(1)).findAllByWarehouseListIn(warehouseList);
    }

    @Test
    void getAllByName() {
        List<Warehouse> warehouseList = Collections.singletonList(new Warehouse());
        List<Product> productList = Collections.singletonList(new Product(1L, 11, "name", BigDecimal.valueOf(10000), BigDecimal.valueOf(1000), warehouseList));
        when(repository.findAllByName("name")).thenReturn(productList);

        List<ProductDTO> productDTOS = subj.getAllByName("name");
        assertNotNull(productDTOS);

        verify(repository, times(1)).findAllByName("name");
    }
}