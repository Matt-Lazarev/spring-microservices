package com.lazarev.productservice.controller;

import com.lazarev.productservice.dto.ProductDto;
import com.lazarev.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public void saveProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(productDto);
    }
}
