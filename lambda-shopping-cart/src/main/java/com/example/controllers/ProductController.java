package com.example.controllers;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.models.Product;
import com.example.repositories.IProductRepository;

@RestController
@EnableWebMvc
public class ProductController {
  private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
  private IProductRepository repository;

  public ProductController(IProductRepository repository){
    this.repository = repository;
  }

  @GetMapping(value = "/products")
  public Collection<Product> getProducts(){
    return this.repository.getAll();
  }

  @RequestMapping(path = "/products", method = RequestMethod.POST)
  public Product saveProduct(@RequestBody Product product){
    logger.info("Request post product");
    return this.repository.save(product);
  }
}
