package com.guitarshop.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
  private Customer customer;
  private List<OrderItem> orderItems = new ArrayList<>();

  public Order(Customer customer) {
    this.customer = customer;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public List<OrderItem> getOrderItems() {
    return orderItems;
  }

  public void addOrderItem(OrderItem item) {
    orderItems.add(item);
  }

  public void removeOrderItem(OrderItem item) {
    orderItems.remove(item);
  }
}
