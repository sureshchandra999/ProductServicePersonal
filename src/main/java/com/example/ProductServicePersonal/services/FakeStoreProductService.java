package com.example.ProductServicePersonal.services;

import com.example.ProductServicePersonal.dtos.FakeStoreProductDto;
import com.example.ProductServicePersonal.dtos.FakeStoreProductRequestDto;
import com.example.ProductServicePersonal.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class);
        /*FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.in/api/products/" + id,
                FakeStoreProductDto.class);*/

        return fakeStoreProductDto.toProduct();



    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos =
        restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class); //https://fakestoreapi.com/products/
        List<Product> products = new ArrayList<>();
        if (fakeStoreProductDtos != null) {
            for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
                products.add(fakeStoreProductDto.toProduct());
            }
        }
        return products;

    }

    @Override
    public Product createProduct(String name,
                                 String description,
                                 double price,
                                 String category,
                                 String imageUrl) {

        FakeStoreProductRequestDto fakeStoreProductRequestDto = new FakeStoreProductRequestDto();
        fakeStoreProductRequestDto.setTitle(name);
        fakeStoreProductRequestDto.setDescription(description);
        fakeStoreProductRequestDto.setPrice(price);
        fakeStoreProductRequestDto.setImage(imageUrl);
        fakeStoreProductRequestDto.setCategory(category);

        FakeStoreProductDto fakeStoreProductDto =
        restTemplate.postForObject("https://fakestoreapi.com/products",
                fakeStoreProductRequestDto,  //Request DTO
                FakeStoreProductDto.class //Response DTO
        );
        return fakeStoreProductDto.toProduct();
    }


}
