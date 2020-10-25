package com.guitarshop.service;

import com.guitarshop.dao.CustomerDB;
import com.guitarshop.model.Customer;

import java.util.List;

public class CustomerService {
  private final CustomerDB customerDb = new CustomerDB();

  public void add(Customer customer) {
    customerDb.add(customer);
  }

  public void add(List<Customer> customers) {
    customerDb.add(customers);
  }

  public void remove(Customer customer) {
    customerDb.remove(customer);
  }

  public void remove(List<Customer> customers) {
    customerDb.remove(customers);
  }

  public List<Customer> getAllCustomers() {
    return customerDb.getAllCustomers();
  }
}
