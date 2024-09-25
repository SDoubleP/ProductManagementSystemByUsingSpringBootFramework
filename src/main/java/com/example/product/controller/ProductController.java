package com.example.product.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.dto.ProductDto;
import com.example.product.entity.Product;
import com.example.product.service.ProductService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> enterNewProduct(@RequestBody ProductDto productDto){
        ProductDto savedProduct = productService.enternewProduct(productDto);
        return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable("id") Long id){
        ProductDto returnProduct = productService.getEmployeeById(id);
        return ResponseEntity.ok(returnProduct);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        List<ProductDto> allProducts = productService.getAllProduct();
        return ResponseEntity.ok(allProducts);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto){
        ProductDto updatedProducts = productService.updateProduct(id, productDto);
        return ResponseEntity.ok(updatedProducts);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("Deleted Product Successfully!");
    }
}
