package com.example.customwarehousetask.service.converter;

import com.example.customwarehousetask.api.converter.Converter;
import com.example.customwarehousetask.entity.Warehouse;
import com.example.customwarehousetask.service.objects.WarehouseDTO;
import org.springframework.stereotype.Component;

@Component
public class WarehouseToDTOConverter implements Converter<Warehouse, WarehouseDTO> {
    @Override
    public WarehouseDTO convert(Warehouse warehouse) {
        return new WarehouseDTO(warehouse.getId(), warehouse.getName());
    }
}