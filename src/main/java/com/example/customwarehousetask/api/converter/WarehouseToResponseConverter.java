package com.example.customwarehousetask.api.converter;

import com.example.customwarehousetask.api.json.WarehouseResponse;
import com.example.customwarehousetask.entity.Warehouse;
import org.springframework.stereotype.Component;

@Component
public class WarehouseToResponseConverter implements Converter<Warehouse, WarehouseResponse> {
    @Override
    public WarehouseResponse convert(Warehouse warehouse) {
        return new WarehouseResponse(warehouse.getId(), warehouse.getName());
    }
}
