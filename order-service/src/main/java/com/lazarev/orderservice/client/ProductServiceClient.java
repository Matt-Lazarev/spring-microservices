package com.lazarev.orderservice.client;

import com.lazarev.orderservice.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ProductServiceClient {
    private static final String GET_PRODUCT_URL = "http://localhost:8081/api/products/%d";
    private final RestTemplate restTemplate;

    public ProductDto getProductById(Integer productId) {
        return restTemplate.getForObject(GET_PRODUCT_URL.formatted(productId), ProductDto.class);
    }
}
