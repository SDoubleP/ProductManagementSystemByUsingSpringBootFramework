package com.example.product.mapper;

import com.example.product.dto.ProductDto;
import com.example.product.entity.Product;

public class ProductMapper {

    public static ProductDto mapToProductDto(Product product){
        return new ProductDto(
            product.getId(),
            product.getName(),
            product.getPrice()
        );
    }

    public static Product mapToProduct(ProductDto productDto){
        return new Product(
            productDto.getId(),
            productDto.getName(),
            productDto.getPrice()
        );
    }
}
