package com.guitarshop.service;

import com.guitarshop.dao.EmployeeDB;
import com.guitarshop.model.Employee;

import java.util.List;

public class EmployeeService {
  private final EmployeeDB employeeDB = new EmployeeDB();

  public void add(Employee employee) {
    employeeDB.add(employee);
  }

  public void add(List<Employee> employees) {
    employeeDB.add(employees);
  }

  public void remove(Employee employee) {
    employeeDB.remove(employee);
  }

  public void remove(List<Employee> employees) {
    employeeDB.remove(employees);
  }

  public boolean isValidEmployee(String userName, String password) {
    List<Employee> employeeList = employeeDB.getEmployees();

    System.out.println(userName + " " + password);
    System.out.println(employeeList.toString());

    for (Employee e : employeeList) {
      if (e.getUserName().toLowerCase().equals(userName.toLowerCase())
          && e.getPassWord().equals(password)) {
        return true;
      }
    }
    return false;
  }

  public Employee getEmployeeByUsername(String userName) {
    List<Employee> employeeList = employeeDB.getEmployees();
    for (Employee e : employeeList) {
      if (e.getUserName().toLowerCase().equals(userName.toLowerCase())) {
        return e;
      }
    }
    return null;
  }
}
