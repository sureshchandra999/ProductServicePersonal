package com.example.ProductServicePersonal.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateFakeStoreProductRequestDto {
    private String name;
    private String description;
    private String category;
    private double price;
    private String imageUrl;

}
