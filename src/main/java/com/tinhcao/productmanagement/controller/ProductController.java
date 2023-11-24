package com.tinhcao.productmanagement.controller;

import com.tinhcao.productmanagement.service.DynamicTableService;
import com.tinhcao.productmanagement.service.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final DynamicTableService dynamicTableService;

    @PostMapping("/add")
    public ResponseEntity<String> addProducts(@RequestBody Map<String, Object> payload) {
        String tableName = (String) payload.get("table");
        List<Map<String, String>> records = (List<Map<String, String>>) payload.get("records");

        dynamicTableService.saveDynamicEntity(tableName, records);

        return ResponseEntity.ok("Data added successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = dynamicTableService.getAllProducts();
        return ResponseEntity.ok(products);
    }
}
