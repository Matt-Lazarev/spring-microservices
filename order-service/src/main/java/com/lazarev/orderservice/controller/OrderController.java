package com.lazarev.orderservice.controller;

import com.lazarev.orderservice.dto.OrderDto;
import com.lazarev.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public void createOrder(@RequestBody OrderDto orderDto) {
        orderService.createOrder(orderDto);
    }
}
