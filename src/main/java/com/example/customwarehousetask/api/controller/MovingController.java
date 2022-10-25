package com.example.customwarehousetask.api.controller;

import com.example.customwarehousetask.documents.Moving;
import com.example.customwarehousetask.entity.Product;
import com.example.customwarehousetask.entity.Warehouse;
import com.example.customwarehousetask.service.ProductService;
import com.example.customwarehousetask.service.WarehouseService;
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
public class MovingController {
    private final WarehouseService warehouseService;
    private final ProductService productService;

    @PostMapping("/moving")
    public @ResponseBody ResponseEntity<String> moving(@Validated @RequestBody Moving moving) {
        Warehouse warehouse = warehouseService.getByName(moving.getWarehouse2());
        if (warehouse == null) {
            return status(HttpStatus.valueOf("Not found warehouse " + moving.getWarehouse2())).build();
        }
        List<Product> productList = moving.getProductList().stream()
                .map(p -> productService.edit(p.getArticle(), null, null, null, warehouse))
                .collect(Collectors.toList());
        return ok(productList + " moved to the warehouse " + warehouse.getName());
    }
}
