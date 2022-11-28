package com.bow.ProductService.controller;

import com.bow.ProductService.service.Dtos.ProductRequestDto;
import com.bow.ProductService.service.Dtos.ProductResponseDto;
import com.bow.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequestDto productDto){
        productService.addProduct(productDto);
    }

    @GetMapping("/filter/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ProductResponseDto getProduct(@PathVariable String id){
       return productService.getProducutById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDto> getAllProducts(){
        return productService.getAllProducts();
    }


}
