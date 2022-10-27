package com.example.customwarehousetask.api.controller;

import com.example.customwarehousetask.api.json.MovingRequest;
import com.example.customwarehousetask.api.json.MovingResponse;
import com.example.customwarehousetask.entity.Warehouse;
import com.example.customwarehousetask.service.DTO.ProductDTO;
import com.example.customwarehousetask.service.DTO.WarehouseDTO;
import com.example.customwarehousetask.service.ProductService;
import com.example.customwarehousetask.service.WarehouseService;
import com.example.customwarehousetask.service.converter.DTOToWarehouseConverter;
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
    private final DTOToWarehouseConverter toWarehouseConverter;

    @PostMapping("/moving")
    public @ResponseBody ResponseEntity<MovingResponse> moving(@Validated @RequestBody MovingRequest request) {
        WarehouseDTO warehouseDTO = warehouseService.getById(request.getWarehouseTo().getId());
        if (warehouseDTO == null) {
            return status(HttpStatus.valueOf("Not found warehouse " + request.getWarehouseTo())).build();
        }
        Warehouse warehouse = toWarehouseConverter.convert(warehouseDTO);
        List<ProductDTO> productDTOList = request.getProductList().stream()
                .map(p -> productService.move(p.getArticle(), warehouse))
                .collect(Collectors.toList());
        return ok(new MovingResponse(request.getNumber(), request.getWarehouseFrom(), warehouseDTO, productDTOList));
    }
}
