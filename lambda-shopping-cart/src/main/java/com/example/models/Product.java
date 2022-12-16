package com.example.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
  private int prodId;
  private String name;
  private double qty;

  public Product(int prodId, String name, double qty){
    this.prodId = prodId;
    this.name = name;
    this.qty = qty;
  }
}
