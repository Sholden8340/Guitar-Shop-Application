package com.guitarshop.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee extends Person implements Serializable {
  private static final long serialVersionUID = 1L;
  private EmployeeRole role;
  private String userName;
  private String passWord;

  public Employee(
      String firstName,
      String lastName,
      LocalDate birthDate,
      EmployeeRole role,
      String userName,
      String passWord) {
    super(firstName, lastName, birthDate);
    this.role = role;
    this.userName = userName;
    this.passWord = passWord;
  }

  public Employee(String firstName, String lastName, LocalDate birthDate, EmployeeRole role) {
    super(firstName, lastName, birthDate);
    this.role = role;
    this.userName = firstName + lastName;
    this.passWord = firstName + lastName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassWord() {
    return passWord;
  }

  public void setPassWord(String passWord) {
    this.passWord = passWord;
  }

  public EmployeeRole getRole() {
    return role;
  }

  public void setRole(EmployeeRole role) {
    this.role = role;
  }

  public String toString() {

    return "First Name: "
        + firstName
        + "\nLast Name: "
        + lastName
        + "\nDOB: "
        + birthDate
        + "\nRole: "
        + role
        + "\nUsername: "
        + userName
        + "\nPassword: "
        + passWord;
  }
}
