package com.younesbouaziz.productservice.service;

import com.younesbouaziz.productservice.dto.ProductRequest;
import com.younesbouaziz.productservice.dto.ProductResponse;
import com.younesbouaziz.productservice.model.Product;
import com.younesbouaziz.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved!", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products =productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
