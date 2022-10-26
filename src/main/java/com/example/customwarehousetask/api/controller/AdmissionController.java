package com.example.customwarehousetask.api.controller;

import com.example.customwarehousetask.documents.Admission;
import com.example.customwarehousetask.entity.Warehouse;
import com.example.customwarehousetask.service.ProductService;
import com.example.customwarehousetask.service.WarehouseService;
import com.example.customwarehousetask.service.converter.DTOToWarehouseConverter;
import com.example.customwarehousetask.service.DTO.ProductDTO;
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
public class AdmissionController {
    private final WarehouseService warehouseService;
    private final ProductService productService;
    private final DTOToWarehouseConverter toWarehouseConverter;

    @PostMapping("/admission")
    public @ResponseBody ResponseEntity<String> admisson(@Validated @RequestBody Admission admission) {
        WarehouseDTO warehouseDTO = warehouseService.getByName(admission.getWarehouseName());
        if (warehouseDTO == null) {
            return status(HttpStatus.valueOf("Not found warehouse " + admission.getWarehouseName())).build();
        }
        Warehouse warehouse = toWarehouseConverter.convert(warehouseDTO);
        List<ProductDTO> productList = admission.getProductList().stream()
                .map(p -> productService.create(
                        p.getArticle(),
                        p.getName(),
                        p.getLastPurchase(),
                        p.getLastSale(),
                        warehouse
                ))
                .collect(Collectors.toList());
        return ok(productList + " received");
    }
}
