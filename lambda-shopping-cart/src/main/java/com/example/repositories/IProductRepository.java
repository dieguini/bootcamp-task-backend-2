package com.example.repositories;

import java.util.Collection;

import com.example.models.Product;

public interface IProductRepository {
  Product save(Product product);
  Collection<Product> getAll();
}
