package com.guitarshop.service;

import com.guitarshop.dao.StockDB;
import com.guitarshop.model.Guitar;

import java.util.List;

public class StockService {
  private StockDB stockDB = new StockDB();

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

  public void updateStock(int index, int quantity){
    stockDB.updateStock(index, quantity);
  }
}
