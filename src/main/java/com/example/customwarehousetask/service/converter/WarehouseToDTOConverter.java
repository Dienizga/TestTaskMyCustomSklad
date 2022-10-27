package com.example.customwarehousetask.service.converter;

import com.example.customwarehousetask.entity.Warehouse;
import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WarehouseToDTOConverter implements Converter<Warehouse, WarehouseDTO> {
    @Override
    public WarehouseDTO convert(Warehouse warehouse) {
        return new WarehouseDTO(warehouse.getId(), warehouse.getName());
    }
}
