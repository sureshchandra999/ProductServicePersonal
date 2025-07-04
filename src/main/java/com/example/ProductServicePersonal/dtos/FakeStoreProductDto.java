package com.example.ProductServicePersonal.dtos;


import com.example.ProductServicePersonal.models.Category;
import com.example.ProductServicePersonal.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {

    private long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;


    public Product toProduct(){
        Product product = new Product();
        product.setId(this.id);
        product.setName(this.title);
        product.setPrice(this.price);
        product.setDescription(this.description);
        product.setImageUrl(this.image);

        // Assuming Category is a simple string for this example
        // In a real application, you might want to map this to a Category object
        Category category = new Category();
        category.setName(this.category);
        product.setCategory(category);

        return product;
    }

}
