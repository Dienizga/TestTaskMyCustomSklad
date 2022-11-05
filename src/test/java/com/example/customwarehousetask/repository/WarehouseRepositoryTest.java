package com.example.customwarehousetask.repository;

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
class WarehouseRepositoryTest {
    @Autowired WarehouseRepository subj;

    @Test
    void findByName() {
        List<Warehouse> warehouseList = subj.findAllByName("name");
        assertNotNull(warehouseList);
        assertEquals(1, warehouseList.size());
    }
}