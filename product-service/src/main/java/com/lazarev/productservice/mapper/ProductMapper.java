package com.lazarev.productservice.mapper;

import com.lazarev.productservice.dto.ProductDto;
import com.lazarev.productservice.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductDto productDto);
    ProductDto toProductDto(Product product);
}
