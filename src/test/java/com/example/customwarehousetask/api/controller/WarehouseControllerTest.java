package com.example.customwarehousetask.api.controller;

import com.example.customwarehousetask.api.converter.WarehouseToResponseConverter;
import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import com.example.customwarehousetask.service.WarehouseService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WarehouseController.class)
@RunWith(SpringRunner.class)
class WarehouseControllerTest {
    @Autowired MockMvc mvc;
    @MockBean WarehouseService service;
    @SpyBean WarehouseToResponseConverter converter;

    @Test
    void getList() throws Exception {
        List<WarehouseDTO> warehouseDTOList = Collections.singletonList(new WarehouseDTO(1L, "name"));
        when(service.getAll()).thenReturn(warehouseDTOList);

        mvc.perform(get("/api/warehouses"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"name\":\"name\"}]"));
    }

    @Test
    void create() throws Exception {
        WarehouseDTO warehouseDTO = new WarehouseDTO(1L, "name");
        when(service.create("name")).thenReturn(warehouseDTO);

        mvc.perform(post("/api/create/warehouse")
                        .content("{\"id\":1,\"name\":\"name\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"name\"}"));
    }
}