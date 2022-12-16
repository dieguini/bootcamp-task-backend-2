package com.example.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
  private String prodId;
  private String name;
  private int qty;

  @Override
  public String toString() {
    // return super.toString();
    return "Id: "+ this.prodId+" Name: "+this.name+ " Quantity: "+this.qty;
  }
}
