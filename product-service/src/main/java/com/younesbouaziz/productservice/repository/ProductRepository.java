package com.younesbouaziz.productservice.repository;

import com.younesbouaziz.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
