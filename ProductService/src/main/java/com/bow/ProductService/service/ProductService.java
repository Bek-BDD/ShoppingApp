package com.bow.ProductService.service;

import com.bow.ProductService.model.Product;
import com.bow.ProductService.service.Dtos.ProductRequestDto;
import com.bow.ProductService.service.Dtos.ProductResponseDto;

import java.util.List;

public interface ProductService {
    public Product addProduct(ProductRequestDto productDto);
    public ProductResponseDto getProducutById(String id);
    public List<ProductResponseDto>getAllProducts();
}
