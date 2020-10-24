package com.guitarshop.dao;

import java.util.List;

abstract class DB{

  abstract void loadDB();

  abstract void writeDB();

  abstract void add(List<Object> list);

  abstract void add(Object item);

  abstract void remove(List<Object> list);

  abstract void remove(Object item);
}
