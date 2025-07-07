package com.example.ProductServicePersonal.controllers;


import com.example.ProductServicePersonal.dtos.CreateFakeStoreProductRequestDto;
import com.example.ProductServicePersonal.dtos.ProductResponseDto;
import com.example.ProductServicePersonal.models.Product;
import com.example.ProductServicePersonal.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;

    }


    /*@GetMapping("/products/{id}")
    public ProductResponseDto getProductById(@PathVariable long id){

        ProductResponseDto dummyProductResponseDto = new ProductResponseDto();
        dummyProductResponseDto.setId(1);
        dummyProductResponseDto.setName("Product " + id);
        dummyProductResponseDto.setDescription("Description for product " + id);
        dummyProductResponseDto.setPrice(99.99);
        dummyProductResponseDto.setImageUrl("http://example.com/product" + id + ".jpg");
        dummyProductResponseDto.setCategory("Category " + id);
        return dummyProductResponseDto;


    }*/
    /*@GetMapping("/products/{id}")
    public ProductResponseDto getProductById(@PathVariable long id){
        Product product = fakeStoreProductService.getProductById(id);

        ProductResponseDto productResponseDto = ProductResponseDto.from(product);
        return productResponseDto;

       // return  ProductResponseDto.from(product);


    }*/

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable long id){
        Product product = productService.getProductById(id);

        ProductResponseDto productResponseDto = ProductResponseDto.from(product);

        ResponseEntity<ProductResponseDto> responseEntity =
                new ResponseEntity<>(productResponseDto, HttpStatus.OK);


        return responseEntity;
    }

    @GetMapping("/products")
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();

        for(Product product : products) {
            ProductResponseDto productResponseDto = ProductResponseDto.from(product);
            productResponseDtos.add(productResponseDto);
        }

        return productResponseDtos;
    }

    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody CreateFakeStoreProductRequestDto createFakeStoreProductRequestDto){

        Product product=
        productService.createProduct(createFakeStoreProductRequestDto.getName(),
                createFakeStoreProductRequestDto.getDescription(),
                createFakeStoreProductRequestDto.getPrice(),
                createFakeStoreProductRequestDto.getCategory(),
                createFakeStoreProductRequestDto.getImageUrl());

        ProductResponseDto productResponseDto = ProductResponseDto.from(product);
        return productResponseDto;

    }




}
