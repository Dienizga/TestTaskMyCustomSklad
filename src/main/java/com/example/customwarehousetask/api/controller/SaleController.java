package com.example.customwarehousetask.api.controller;

import com.example.customwarehousetask.documents.Sale;
import com.example.customwarehousetask.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SaleController {
    private final ProductService productService;

    @PostMapping("/sale")
    public @ResponseBody ResponseEntity<String> sale(@Validated @RequestBody Sale sale) {
        sale.getProductList().forEach(p -> productService.delete(p.getArticle()));
        return ok(sale.getProductList() + " saled");
    }
}
