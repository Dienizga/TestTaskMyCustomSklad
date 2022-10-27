package com.example.customwarehousetask.api.controller;

import com.example.customwarehousetask.api.json.AdmissionRequest;
import com.example.customwarehousetask.api.json.AdmissionResponse;
import com.example.customwarehousetask.exception.CustomUserException;
import com.example.customwarehousetask.service.DTO.ProductDTO;
import com.example.customwarehousetask.service.DTO.WarehouseDTO;
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
public class AdmissionController {
    private final WarehouseService warehouseService;
    private final ProductService productService;

    @PostMapping("/admission")
    public @ResponseBody ResponseEntity<AdmissionResponse> admisson(@Validated @RequestBody AdmissionRequest request) {
        WarehouseDTO warehouseDTO;
        List<ProductDTO> productDTOList;
        try {
            warehouseDTO = warehouseService.getById(request.getWarehouseDTO().getId());
            productDTOList = request.getProductList().stream()
                    .map(p -> productService.create(
                            p.getArticle(),
                            p.getName(),
                            p.getLastPurchase(),
                            warehouseDTO
                    ))
                    .collect(Collectors.toList());
        } catch (CustomUserException e) {
            return status(HttpStatus.valueOf(e.getMessage())).build();
        }
        return ok(new AdmissionResponse(request.getNumber(), warehouseDTO, productDTOList));
    }
}
