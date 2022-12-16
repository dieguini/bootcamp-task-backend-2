package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.models.Product;
import com.example.repositories.IProductRepository;
import com.example.repositories.ProductRepository;

@Configuration
public class RepositoriesConfigurator {
  @Bean
  public IProductRepository initProductRepository(){
    ProductRepository productRepository = new ProductRepository();
    productRepository.save(
      new Product(1, "oreo", 3)
    );
    productRepository.save(
      new Product(2, "mantequilla regia", 1)
    );

    return productRepository;
  }
}
