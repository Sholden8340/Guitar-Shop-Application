package com.guitarshop.dao;

import com.guitarshop.model.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDB extends DB implements Serializable {

  private static final long serialVersionUID = 1L;
  private static final String DB_FILE_LOCATION = "orderDB.dat";
  private final List<Order> orders = new ArrayList<>();

  public OrderDB() {
    try {
      loadDB(orders, DB_FILE_LOCATION);
    } catch (Exception e) {
      e.printStackTrace();
      Customer customer = new Customer(
              "Irina",
              "Schapendonk",
              LocalDate.now(),
              "Hunze 65",
              "Drachten",
              "06-77924191",
              "Irina.Schapendonk@mail.com");

      Order order = new Order(customer);
      order.addOrderItem(new OrderItem(new Guitar("Martin", "D-28", GuitarType.ACOUSTIC, 350, 4), 2));
      orders.add(order);
    }finally{
      writeDB(orders, DB_FILE_LOCATION);
    }
  }

  public void add(Order o) {
    super.add(orders, o);
    writeDB(orders, DB_FILE_LOCATION);
  }

  public void add(List<Order> o) {
    super.add(orders, o);
    writeDB(orders, DB_FILE_LOCATION);
  }

  public void remove(Order o) {
    super.remove(orders, o);
    writeDB(orders, DB_FILE_LOCATION);
  }

  public void remove(List<Order> o) {
    super.remove(orders, o);
    writeDB(orders, DB_FILE_LOCATION);
  }

  public List<Order> getAllOrders() {
    return orders;
  }
}
