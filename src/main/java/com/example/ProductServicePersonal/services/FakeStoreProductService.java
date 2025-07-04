package com.example.ProductServicePersonal.services;

import com.example.ProductServicePersonal.dtos.FakeStoreProductDto;
import com.example.ProductServicePersonal.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
}
