package com.example.customwarehousetask.api.controller;

import com.example.customwarehousetask.api.json.SaleRequest;
import com.example.customwarehousetask.api.json.SaleResponse;
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
public class SaleController {
    private final ProductService productService;
    private final WarehouseService warehouseService;

    @PostMapping("/sale")
    public @ResponseBody ResponseEntity<SaleResponse> sale(@Validated @RequestBody SaleRequest request) {
        WarehouseDTO warehouseDTO;
        List<ProductDTO> productDTOList;
        try {
            warehouseDTO = warehouseService.getById(request.getWarehouseDTO().getId());
            productDTOList = request.getProductDTOList().stream()
                    .map(p -> productService.writeOff(p.getArticle(), p.getLastSale()))
                    .collect(Collectors.toList());
        } catch (CustomUserException e) {
            return status(HttpStatus.valueOf(e.getMessage())).build();
        }
        return ok(new SaleResponse(request.getNumber(), warehouseDTO, productDTOList));
    }
}
