package com.example.product.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.product.dto.ProductDto;
import com.example.product.entity.Product;
import com.example.product.exception.ResourceNotFoundException;
import com.example.product.mapper.ProductMapper;
import com.example.product.repository.ProductRepository;
import com.example.product.service.ProductService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ProductServiceImplement implements ProductService{
    private ProductRepository productRepository;
    @Override
    public ProductDto enternewProduct(ProductDto productDto) {
        Product product = ProductMapper.mapToProduct(productDto);
        Product savedProduct = productRepository.save(product);

        return ProductMapper.mapToProductDto(savedProduct);
    }

    @Override
    public ProductDto getEmployeeById(Long id) {
        Product product = productRepository.findById(id)
        .orElseThrow(()->new ResourceNotFoundException("No product with given id : "+id));
        
        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> allProducts = productRepository.findAll();
        return allProducts.stream().map((product)-> ProductMapper.mapToProductDto(product))
        .collect(Collectors.toList());
        
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {

        Product existingProduct = productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No product with given id : "+id));

        existingProduct.setName(productDto.getName());
        existingProduct.setPrice(productDto.getPrice());
        Product updatedProduct = productRepository.save(existingProduct);
        return ProductMapper.mapToProductDto(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product existingProduct = productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No product with given id : "+id));
        productRepository.deleteById(id);
        
    }
    
    
}
