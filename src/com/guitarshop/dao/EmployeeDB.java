package com.guitarshop.dao;

import com.guitarshop.model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDB extends DB implements Serializable {

  private static final long serialVersionUID = 1L;
  private static final String DB_FILE_LOCATION = "employeeDB.dat";

  private final List<Employee> employees = new ArrayList<>();

  public EmployeeDB() {
    loadDB();
    /*    employees.add(new Employee("Jim", "Bob", LocalDate.now(), EmployeeRole.MANAGER));
    employees.add(new Employee("Lewis", "Dog", LocalDate.now(), EmployeeRole.MANAGER));
    employees.add(new Employee("Stan", "Standardson", LocalDate.now(), EmployeeRole.SALES));
    employees.add(new Employee("Claire", "Murphy", LocalDate.now(), EmployeeRole.SALES));
    employees.add(new Employee("Amy", "West", LocalDate.now(), EmployeeRole.SALES));
    writeDB();*/
  }

  @Override
  void loadDB() {
    try (ObjectInputStream ois =
        new ObjectInputStream(new FileInputStream(new File(DB_FILE_LOCATION)))) {
      while (true) {
        try {
          Employee employee = (Employee) ois.readObject();
          employees.add(employee);
        } catch (EOFException eofe) {
          eofe.printStackTrace();
          break;
        }
      }
    } catch (FileNotFoundException fnfe) {
      fnfe.printStackTrace();
    } catch (ClassNotFoundException cnfe) {
      cnfe.printStackTrace();
    } catch (IOException ie) {
      ie.printStackTrace();
    }
  }

  @Override
  void writeDB() {
    try (FileOutputStream fos = new FileOutputStream(new File(DB_FILE_LOCATION));
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {
      for (Employee employee : employees) {
        oos.writeObject(employee);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void add(List list) {
    employees.addAll((list));
    writeDB();
  }

  @Override
  public void add(Object item) {
    employees.add((Employee) item);
    writeDB();
  }

  @Override
  public void remove(List list) {
    employees.removeAll(list);
    writeDB();
  }

  @Override
  public void remove(Object item) {
    employees.remove(item);
    writeDB();
  }

  public List<Employee> getEmployees() {
    return employees;
  }
}
