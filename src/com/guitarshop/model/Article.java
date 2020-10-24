package com.guitarshop.model;

public class Article {
  private String brand;
  private String model;
  private double price;
  private int stockQuantity;

  public Article(String brand, String model, double price, int stockQuantity) {
    this.brand = brand;
    this.model = model;
    this.price = price;
    this.stockQuantity = stockQuantity;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) throws Exception {
    if (price < 0) {
      throw new Exception("Price cannot be negative");
    }
    this.price = price;
  }

  public int getStockQuantity() {
    return stockQuantity;
  }

  public void setStockQuantity(int stockQuantity) throws Exception {
    if (stockQuantity < 0) {
      throw new Exception("Stock amount cannot be negative");
    }
    this.stockQuantity = stockQuantity;
  }
}
