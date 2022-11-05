package com.example.customwarehousetask.api.controller;

import com.example.customwarehousetask.api.converter.ProductToResponseConverter;
import com.example.customwarehousetask.service.DTO.ProductDTO;
import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import com.example.customwarehousetask.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
@RunWith(SpringRunner.class)
class ProductControllerTest {
    @Autowired MockMvc mvc;
    @MockBean ProductService service;
    @SpyBean ProductToResponseConverter converter;

    @Test
    void getList() throws Exception {
        List<WarehouseDTO> warehouseDTOList = Collections.singletonList(new WarehouseDTO(1L, "name"));
        List<ProductDTO> productDTOList = Collections.singletonList(new ProductDTO(1L, 11, "name", BigDecimal.valueOf(10000), BigDecimal.valueOf(1000), warehouseDTOList));
        when(service.getAll()).thenReturn(productDTOList);

        mvc.perform(get("/api/products"))
                .andExpect(status().isOk());
    }
}