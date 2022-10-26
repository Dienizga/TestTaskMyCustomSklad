package com.example.customwarehousetask.repository;

import com.example.customwarehousetask.entity.Warehouse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@RunWith(SpringRunner.class)
class WarehouseRepositoryTest {
    @Autowired WarehouseRepository subj;

    @Test
    void findByName() {
        Warehouse warehouse = subj.findByName("name");
        assertNotNull(warehouse);
        assertEquals("name", warehouse.getName());
    }
}