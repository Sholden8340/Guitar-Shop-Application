package com.guitarshop.dao;

import com.guitarshop.model.Guitar;
import com.guitarshop.model.GuitarType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StockDB extends DB implements Serializable {

  private static final long serialVersionUID = 1L;
  private static final String DB_FILE_LOCATION = "stockDB.dat";
  private final List<Guitar> guitars = new ArrayList<>();

  public StockDB() {
    try {
      loadDB(guitars, DB_FILE_LOCATION);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (guitars.isEmpty()) {
        guitars.add(new Guitar("Fender", "Telecaster", GuitarType.ELECTRIC, 300, 5));
        guitars.add(new Guitar("Fender", "Stratocaster", GuitarType.ELECTRIC, 350, 8));
        guitars.add(new Guitar("Gibson", "Les Paul", GuitarType.ELECTRIC, 600, 2));
        guitars.add(new Guitar("Gibson", "SG Standard", GuitarType.ELECTRIC, 550, 4));
        guitars.add(new Guitar("Martin", "D-28", GuitarType.ACOUSTIC, 350, 4));
        guitars.add(new Guitar("Epiphone", "200SCE", GuitarType.ACOUSTIC, 475, 6));
        guitars.add(
            new Guitar("Fender", "American Performer Precision Bass", GuitarType.BASS, 405, 3));
        guitars.add(
            new Guitar("Sterling by Music Man", "S.U.B. Sting Ray 5 BK", GuitarType.BASS, 625, 8));

        writeDB(guitars, DB_FILE_LOCATION);
      }
    }
  }

  public List<Guitar> getAllGuitars() {
    return guitars;
  }

  public void remove(List<Guitar> guitar) {
    remove(guitars, guitar);
    writeDB(guitars, DB_FILE_LOCATION);
  }

  public void remove(Guitar guitar) {
    remove(guitars, guitar);
    writeDB(guitars, DB_FILE_LOCATION);
  }

  public void add(List<Guitar> guitar) {
    add(guitars, guitar);
    writeDB(guitars, DB_FILE_LOCATION);
  }

  public void add(Guitar guitar) {
    add(guitars, guitar);
    writeDB(guitars, DB_FILE_LOCATION);
  }

  public void updateStock(int index, int quantity) {
    try{
      guitars.get(index).setStockQuantity(quantity);
    }catch (Exception e){
      e.printStackTrace();
    }
    writeDB(guitars, DB_FILE_LOCATION);
  }

  public int getIndex(Guitar g) {
    return guitars.indexOf(g);
  }
}
