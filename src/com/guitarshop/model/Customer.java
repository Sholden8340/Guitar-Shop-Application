package com.guitarshop.model;

import java.time.LocalDate;

public class Customer extends Person {
  public Customer(String firstName, String lastName, LocalDate birthDate) {
    super(firstName, lastName, birthDate);
  }
}
