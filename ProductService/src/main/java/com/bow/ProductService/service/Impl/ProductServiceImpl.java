package com.bow.ProductService.service.Impl;

import com.bow.ProductService.model.Product;
import com.bow.ProductService.repository.ProductRepo;
import com.bow.ProductService.service.Adapters.ProductAdapter;
import com.bow.ProductService.service.Dtos.ProductRequestDto;
import com.bow.ProductService.service.Dtos.ProductResponseDto;
import com.bow.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductAdapter productAdapter;

    @Override
    public Product addProduct(ProductRequestDto productDto) {
        Product prod= productAdapter.fromRequsetDtoToDomain(productDto);
        return productRepo.save(prod);
    }

    @Override
    public ProductResponseDto getProducutById(String id) {
        Optional<Product> prod= productRepo.findById(id);
        if(prod.isPresent()){
            return productAdapter.fromDomainToResponseDto( prod.get());
        }else{
            return null;
        }
    }
    @Override
    public List<ProductResponseDto> getAllProducts(){
        return productRepo.findAll().stream()
                .map(p->productAdapter.fromDomainToResponseDto(p))
                .collect(Collectors.toList());
    }

}
