package com.example.customwarehousetask.repository;

import com.example.customwarehousetask.entity.Product;
import com.example.customwarehousetask.entity.Warehouse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@RunWith(SpringRunner.class)
class ProductRepositoryTest {
    @Autowired ProductRepository subj;

    @Test
    void findByArticle() {
        Product product = subj.findByArticle(11);
        assertNotNull(product);
        assertEquals(11, product.getArticle());
    }

    @Test
    void findAllByName() {
        List<Product> productList = subj.findAllByName("name");
        assertNotNull(productList);
        assertEquals(1, productList.size());

    }

    @Test
    void findAllByWarehouse() {
        Warehouse warehouse = new Warehouse(1L, "name");
        List<Product> productList = subj.findAllByWarehouse(warehouse);
        assertNotNull(productList);
        assertEquals(1, productList.size());
    }
}