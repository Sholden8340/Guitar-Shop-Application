package com.guitarshop.dao;

import com.guitarshop.model.Employee;
import com.guitarshop.model.EmployeeRole;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDB extends DB implements Serializable {

  private static final long serialVersionUID = 1L;
  private static final String DB_FILE_LOCATION = "employeeDB.dat";

  private final List<Employee> employees = new ArrayList<>();

  public EmployeeDB() {
    loadDB(employees, DB_FILE_LOCATION);

    if (employees.isEmpty()) {
      employees.add(new Employee("Jim", "Bob", LocalDate.now(), EmployeeRole.MANAGER));
      employees.add(new Employee("Lewis", "Light", LocalDate.now(), EmployeeRole.MANAGER));
      employees.add(new Employee("Stan", "Standardson", LocalDate.now(), EmployeeRole.SALES));
      employees.add(new Employee("Claire", "Murphy", LocalDate.now(), EmployeeRole.SALES));
      employees.add(new Employee("Amy", "West", LocalDate.now(), EmployeeRole.SALES));
      writeDB(employees, DB_FILE_LOCATION);
    }
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void add(Employee e) { super.add(employees, e); }

  public void add(List e) {
    super.add(employees, e);
  }

  public void remove(Employee e) {
    super.remove(employees, e);
  }

  public void remove(List e) {
    super.remove(employees, e);
  }
}
