package com.guitarshop.model;

public class Guitar extends Article {
  private final GuitarType guitarType;

  public Guitar(
      String brand, String model, GuitarType guitarType, double price, int stockQuantity) {
    super(brand, model, price, stockQuantity);
    this.guitarType = guitarType;
  }
}
