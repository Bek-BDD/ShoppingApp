package com.bow.ProductService.service.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {
    private String  id;
    private String name;
    private String description;
    private double price;
}
