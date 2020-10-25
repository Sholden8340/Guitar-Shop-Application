package com.guitarshop.service;

import com.guitarshop.dao.OrderDB;
import com.guitarshop.model.Order;

import java.util.List;

public class OrderService {

  private final OrderDB orderDB = new OrderDB();

  public void add(Order order) {
    orderDB.add(order);
  }

  public void add(List<Order> orders) {
    orderDB.add(orders);
  }

  public void remove(Order order) {
    orderDB.remove(order);
  }

  public void remove(List<Order> orders) {
    orderDB.remove(orders);
  }

  public List<Order> getAllOrders() {
    return orderDB.getAllOrders();
  }
}
