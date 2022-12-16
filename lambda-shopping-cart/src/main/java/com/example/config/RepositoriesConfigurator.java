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
      new Product("8712392-123213", "oreo", 3)
    );
    productRepository.save(
      new Product("09182032-323123", "mantequilla regia", 1)
    );

    return productRepository;
  }
}
