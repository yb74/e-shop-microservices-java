package com.younesbouaziz.productservice.controller;

import com.younesbouaziz.productservice.dto.ProductRequest;
import com.younesbouaziz.productservice.dto.ProductResponse;
import com.younesbouaziz.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest request) {
        productService.createProduct(request);
    }

    @GetMapping @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}
