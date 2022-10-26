package com.example.customwarehousetask.service;

import com.example.customwarehousetask.entity.Product;
import com.example.customwarehousetask.entity.Warehouse;
import com.example.customwarehousetask.repository.ProductRepository;
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
        Product product = new Product(1L, 11, "name", BigDecimal.valueOf(10000), BigDecimal.valueOf(1000),new Warehouse());
        when(repository.save(any())).thenReturn(product);
        ProductDTO productDTO = subj.create(11, "name", BigDecimal.valueOf(10000), BigDecimal.valueOf(1000), new Warehouse(1L, "name"));

        assertEquals(productDTO, toDTOConverter.convert(product));
    }

    @Test
    void edit() {
        subj.edit(11, "name", BigDecimal.valueOf(10000), BigDecimal.valueOf(1000), new Warehouse());
        verify(repository, times(1)).findByArticle(11);
    }

    @Test
    void delete() {
        subj.delete(11);
        verify(repository, times(1)).findByArticle(11);
    }
}