package com.guitarshop.service;

import com.guitarshop.dao.StockDB;
import com.guitarshop.model.Guitar;
import com.guitarshop.model.Order;
import com.guitarshop.model.OrderItem;

import java.util.List;

public class StockService {
  private final StockDB stockDB = new StockDB();

  public void add(Guitar guitar) {
    stockDB.add(guitar);
  }

  public void add(List<Guitar> guitar) {
    stockDB.add(guitar);
  }

  public void remove(Guitar guitar) {
    stockDB.remove(guitar);
  }

  public void remove(List<Guitar> guitar) {
    stockDB.remove(guitar);
  }

  public List<Guitar> getAllGuitars() {
    return stockDB.getAllGuitars();
  }

  public void updateStock(int index, int quantity) {
    stockDB.updateStock(index, quantity);
  }

  public void updateStock(Order newOrder) {

    for (OrderItem o : newOrder.getOrderItems()) {
      int quantity = o.getQuantity();
      quantity = -quantity;
      updateStock(getIndex(o.getGuitar()), quantity);
    }
  }

  private int getIndex(Guitar g) {
    return stockDB.getIndex(g);
  }
}
