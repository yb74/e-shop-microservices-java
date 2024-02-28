package com.younesbouaziz.orderservice.repository;

import com.younesbouaziz.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
