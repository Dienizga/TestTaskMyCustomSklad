package com.example.customwarehousetask.service;

import com.example.customwarehousetask.entity.Product;
import com.example.customwarehousetask.entity.Warehouse;
import com.example.customwarehousetask.service.converter.DTOToWarehouseConverter;
import com.example.customwarehousetask.service.objects.ProductDTO;
import com.example.customwarehousetask.service.objects.WarehouseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReportServiceTest {
    @InjectMocks ReportService subj;
    @Mock ProductService productService;
    @Mock WarehouseService warehouseService;
    @Mock DTOToWarehouseConverter dtoToWarehouseConverter;

    @Test
    void getAllProductList() {
        List<ProductDTO> productDTOList = Collections.singletonList(new ProductDTO(1L, 11, "name", BigDecimal.valueOf(10000), BigDecimal.valueOf(1000), new WarehouseDTO(1L, "name")));
        when(productService.getAllByName("name")).thenReturn(productDTOList);

        List<ProductDTO> finalList = subj.getAllProductList("name");

        assertEquals(productDTOList, finalList);
    }

    @Test
    void getRemnants() {
        WarehouseDTO warehouseDTO = new WarehouseDTO(1L, "name");
        when(warehouseService.getByName("name")).thenReturn(warehouseDTO);

        List<ProductDTO> productDTOList = Collections.singletonList(new ProductDTO(1L, 11, "name", BigDecimal.valueOf(10000), BigDecimal.valueOf(1000), new WarehouseDTO(1L, "name")));
        when(productService.getAllByWarehouse(dtoToWarehouseConverter.convert(warehouseDTO))).thenReturn(productDTOList);

        List<ProductDTO> finalList = subj.getRemnants("name");

        assertEquals(productDTOList, finalList);
    }
}