package com.example.customwarehousetask.service;

import com.example.customwarehousetask.service.DTO.ProductDTO;
import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReportServiceTest {
    @InjectMocks ReportService subj;
    @Mock ProductService productService;
    @Mock WarehouseService warehouseService;

    @Test
    void getAllProductList() {
        List<WarehouseDTO> warehouseDTOList = Collections.singletonList(new WarehouseDTO(1L, "name"));
        List<ProductDTO> productDTOList = Collections.singletonList(new ProductDTO(1L, 11, "name", BigDecimal.valueOf(10000), BigDecimal.valueOf(1000), warehouseDTOList));
        when(productService.getAllByName("name")).thenReturn(productDTOList);

        List<ProductDTO> finalList = subj.getAllProductList("name");

        assertEquals(productDTOList, finalList);
    }

    @Test
    void getRemnants() {
        List<WarehouseDTO> warehouseDTOList = Collections.singletonList(new WarehouseDTO(1L, "name"));
        when(warehouseService.getAllByName("name")).thenReturn(warehouseDTOList);

        List<ProductDTO> productDTOList = Collections.singletonList(new ProductDTO(1L, 11, "name", BigDecimal.valueOf(10000), BigDecimal.valueOf(1000), warehouseDTOList));
        when(productService.getAllByWarehouse(warehouseDTOList)).thenReturn(productDTOList);

        List<ProductDTO> finalList = subj.getRemnants("name");

        assertEquals(productDTOList, finalList);
    }
}