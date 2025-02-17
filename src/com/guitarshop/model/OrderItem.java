package com.guitarshop.model;

import java.io.Serializable;

public class OrderItem implements Serializable {
  private static final long serialVersionUID = 1L;
  private Guitar guitar;
  private int quantity;

  public OrderItem(Guitar guitar, int quantity) {
    this.guitar = guitar;
    this.quantity = quantity;
  }

  public Guitar getGuitar() {
    return guitar;
  }

  public void setGuitar(Guitar guitar) {
    this.guitar = guitar;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
