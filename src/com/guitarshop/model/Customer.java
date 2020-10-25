package com.guitarshop.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer extends Person implements Serializable {
  private static final long serialVersionUID = 1L;
  private String streetAddress;
  private String emailAddress;
  private String city;
  private String phoneNumber;

  public Customer(
      String firstName,
      String lastName,
      LocalDate birthDate,
      String streetAddress,
      String city,
      String phoneNumber,
      String emailAddress) {
    super(firstName, lastName, birthDate);
    this.streetAddress = streetAddress;
    this.city = city;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
  }

  public Customer(String firstName, String lastName, LocalDate birthDate) {
    super(firstName, lastName, birthDate);
  }

  public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }
}
