package com.example.ProductServicePersonal.controllers;


import com.example.ProductServicePersonal.dtos.ProductResponseDto;
import com.example.ProductServicePersonal.models.Product;
import com.example.ProductServicePersonal.services.FakeStoreProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    FakeStoreProductService fakeStoreProductService;
    public ProductController(FakeStoreProductService fakeStoreProductService) {
        this.fakeStoreProductService = fakeStoreProductService;

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
        Product product = fakeStoreProductService.getProductById(id);

        ProductResponseDto productResponseDto = ProductResponseDto.from(product);

        ResponseEntity<ProductResponseDto> responseEntity =
                new ResponseEntity<>(productResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);


        return responseEntity;
    }


}
