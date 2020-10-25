package com.guitarshop.dao;

import com.guitarshop.model.Customer;
import com.guitarshop.model.Order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderDB extends DB implements Serializable {

  private static final long serialVersionUID = 1L;
  private static final String DB_FILE_LOCATION = "orderDB.dat";
  private final List<Order> orders = new ArrayList<>();

  public void add(Order o) {
    super.add(orders, o);
  }

  public void add(List<Order> o) {
    super.add(orders, o);
  }

  public void remove(Customer c) {
    super.remove(orders, c);
  }

  public void remove(List<Order> o) {
    super.remove(orders, o);
  }
}
