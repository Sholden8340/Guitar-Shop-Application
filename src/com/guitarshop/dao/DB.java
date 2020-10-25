package com.guitarshop.dao;

import java.io.*;
import java.util.List;

abstract class DB<T> implements Serializable {

  private static final long serialVersionUID = 1L;
  // protected List<T> db = new ArrayList<>();

  protected void loadDB(List<T> db, String dbLocation) throws Exception {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(dbLocation)))) {
      while (true) {
        try {
          Object object = ois.readObject();
          db.add((T) object);
        } catch (EOFException eofe) {
          break;
        }
      }
    } catch (FileNotFoundException fnfe) {
      fnfe.printStackTrace();
      throw new Exception("File not found");
    } catch (ClassNotFoundException cnfe) {
      cnfe.printStackTrace();
      throw new Exception("Class Not Found");
    } catch (IOException ie) {
      ie.printStackTrace();
      throw new Exception("IO Exception");
    }
  }

  protected void writeDB(List<T> db, String dbLocation) {
    try (FileOutputStream fos = new FileOutputStream(new File(dbLocation));
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {
      for (Object obj : db) {
        oos.writeObject(obj);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  protected void add(List<T> db, List<T> newItems) {
    db.addAll(newItems);
  }

  protected void add(List<T> db, T item) {
    db.add(item);
  }

  protected void remove(List<T> db, List<T> removeItems) {
    db.removeAll(removeItems);
  }

  protected void remove(List<T> db, T item) {
    db.remove(item);
  }
}
