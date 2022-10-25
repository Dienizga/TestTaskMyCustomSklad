package com.example.customwarehousetask.api.controller;

import com.example.customwarehousetask.documents.Admission;
import com.example.customwarehousetask.entity.Product;
import com.example.customwarehousetask.entity.Warehouse;
import com.example.customwarehousetask.service.ProductService;
import com.example.customwarehousetask.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/admission")
    public @ResponseBody ResponseEntity<String> admisson(@RequestBody Admission admission) {
        Warehouse warehouse = warehouseService.getByName(admission.getWarehouseName());
        if (warehouse == null) {
            return status(HttpStatus.valueOf("Not found warehouse " + admission.getWarehouseName())).build();
        }
        List<Product> productList = admission.getProductList().stream()
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
