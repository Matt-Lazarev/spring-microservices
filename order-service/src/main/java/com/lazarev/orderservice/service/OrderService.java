package com.lazarev.orderservice.service;

import com.lazarev.orderservice.client.ProductServiceClient;
import com.lazarev.orderservice.dto.OrderDto;
import com.lazarev.orderservice.dto.ProductDto;
import com.lazarev.orderservice.entity.Order;
import com.lazarev.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductServiceClient productServiceClient;

    public void createOrder(OrderDto orderDto) {
        //HTTP call to product-service
        ProductDto productDto = productServiceClient.getProductById(orderDto.productId());

        Order order = new Order();
        order.setCreatedAt(LocalDateTime.now());
        order.setProductId(productDto.id());

        orderRepository.save(order);
    }
}
