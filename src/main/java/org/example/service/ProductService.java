package org.example.service;

import org.example.dto.ProductDto;
import org.example.entity.Product;
import org.example.repository.ProductRepository;


public class ProductService {
    private ProductRepository productRepository = ProductRepository.getInstance();
    private static ProductService productService;
    public static ProductService getInstance(){
        if(productService == null){
            productService = new ProductService();
        }
        return productService;
    }

    public Product save(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.name());
        product.setPrice(productDto.price());

        return productRepository.save(product);
    }
}
