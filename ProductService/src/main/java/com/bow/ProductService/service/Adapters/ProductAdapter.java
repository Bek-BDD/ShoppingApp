package com.bow.ProductService.service.Adapters;

import com.bow.ProductService.model.Product;
import com.bow.ProductService.service.Dtos.ProductRequestDto;
import com.bow.ProductService.service.Dtos.ProductResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductAdapter {
    @Autowired
    private ModelMapper mapper;
    public Product fromRequsetDtoToDomain(ProductRequestDto productDto){
        return mapper.map(productDto,Product.class);
    }

    public ProductRequestDto fromDomainToRequestDto (Product product){
        return mapper.map(product, ProductRequestDto.class);
    }

    public Product fromResponseDtoToDomain(ProductResponseDto productDto){
        return mapper.map(productDto,Product.class);
    }

    public ProductResponseDto fromDomainToResponseDto(Product product){
        return mapper.map(product, ProductResponseDto.class);
    }

}
