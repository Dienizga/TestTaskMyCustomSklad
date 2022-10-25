package com.example.customwarehousetask.api.controller;

import com.example.customwarehousetask.api.converter.ReportToAllProductResponseConverter;
import com.example.customwarehousetask.api.converter.ReportToRemnantsResponseConverter;
import com.example.customwarehousetask.api.json.ReportAllProductResponse;
import com.example.customwarehousetask.api.json.ReportRemnantsResponse;
import com.example.customwarehousetask.api.json.ReportRequest;
import com.example.customwarehousetask.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReportController {
    private final ReportService service;
    private final ReportToAllProductResponseConverter toAllProductResponseConverter;
    private final ReportToRemnantsResponseConverter toRemnantsResponseConverter;

    @GetMapping("/all/product/list")
    public @ResponseBody ResponseEntity<List<ReportAllProductResponse>> allProductList(@Validated @RequestBody ReportRequest request) {
        return ok(service.getAllProductList(request.getNameProduct()).stream()
                .map(toAllProductResponseConverter::convert)
                .collect(Collectors.toList()));
    }

    @GetMapping("/remnants")
    public @ResponseBody ResponseEntity<List<ReportRemnantsResponse>> remnants(@Validated @RequestBody ReportRequest request) {
        return ok(service.getRemnants(request.getNameWarehouse()).stream()
                .map(toRemnantsResponseConverter::convert)
                .collect(Collectors.toList()));
    }
}
