package com.guitarshop.model;

import java.io.Serializable;

public class Guitar extends Article implements Serializable {
  private static final long serialVersionUID = 1L;
  private GuitarType guitarType;

  public GuitarType getGuitarType() {
    return guitarType;
  }

  public void setGuitarType(GuitarType guitarType) {
    this.guitarType = guitarType;
  }

  public Guitar(
      String brand, String model, GuitarType guitarType, double price, int stockQuantity) {
    super(brand, model, price, stockQuantity);
    this.guitarType = guitarType;
  }
}
