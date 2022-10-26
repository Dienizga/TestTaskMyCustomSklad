package com.example.customwarehousetask.api.converter;

import com.example.customwarehousetask.api.json.WarehouseResponse;
import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import org.springframework.stereotype.Component;

@Component
public class WarehouseToResponseConverter implements Converter<WarehouseDTO, WarehouseResponse> {
    @Override
    public WarehouseResponse convert(WarehouseDTO warehouse) {
        return new WarehouseResponse(warehouse.getId(), warehouse.getName());
    }
}
