package com.example.customwarehousetask.service.converter;

import com.example.customwarehousetask.entity.Warehouse;
import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DTOToWarehouseConverter implements Converter<WarehouseDTO, Warehouse> {
    @Override
    public Warehouse convert(WarehouseDTO warehouseDTO) {
        return new Warehouse(warehouseDTO.getId(), warehouseDTO.getName());
    }
}
