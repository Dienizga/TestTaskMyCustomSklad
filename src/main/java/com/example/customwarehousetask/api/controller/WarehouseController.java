package com.example.customwarehousetask.api.controller;

import com.example.customwarehousetask.api.converter.WarehouseToResponseConverter;
import com.example.customwarehousetask.api.json.WarehouseRequest;
import com.example.customwarehousetask.api.json.WarehouseResponse;
import com.example.customwarehousetask.service.WarehouseService;
import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class WarehouseController {
    private final WarehouseService service;
    private final WarehouseToResponseConverter converter;

    @GetMapping("/warehouses")
    public @ResponseBody ResponseEntity<List<WarehouseResponse>> getList() {
        List<WarehouseDTO> warehouseList = service.getAll();
        return ok(warehouseList.stream().map(converter::convert).collect(Collectors.toList()));
    }

    @PostMapping("/create/warehouse")
    public @ResponseBody ResponseEntity<WarehouseResponse> create(@Validated @RequestBody WarehouseRequest request) {
        WarehouseDTO warehouse = service.create(request.getName());
        if (warehouse == null) {
            return status(HttpStatus.valueOf("There is already such a warehouse")).build();
        }
        return ok(converter.convert(warehouse));
    }

    @PatchMapping("/update/warehouse")
    public @ResponseBody ResponseEntity<WarehouseResponse> edit(@Validated @RequestBody WarehouseRequest request) {
        WarehouseDTO warehouse = service.edit(request.getName(), request.getNewName());
        if (warehouse == null) {
            return status(HttpStatus.valueOf("Not found")).build();
        }
        return ok(converter.convert(warehouse));
    }

    @DeleteMapping("/delete/warehouse")
    public @ResponseBody ResponseEntity<String> delete(@Validated @RequestBody WarehouseRequest request) {
        service.delete(request.getName());
        return ok(request.getName() + " deleted");
    }
}
