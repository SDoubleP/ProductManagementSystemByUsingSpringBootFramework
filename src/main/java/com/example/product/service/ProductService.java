package com.example.product.service;

import java.util.List;

import com.example.product.dto.ProductDto;


public interface ProductService {
    ProductDto enternewProduct(ProductDto productDto);

    ProductDto getEmployeeById(Long id);

    List<ProductDto> getAllProduct();

    ProductDto updateProduct(Long id, ProductDto productDto);

    void deleteProduct(Long id);
}
