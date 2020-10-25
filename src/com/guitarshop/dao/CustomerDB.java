package com.guitarshop.dao;

import com.guitarshop.model.Customer;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CustomerDB extends DB implements Serializable {

  private static final long serialVersionUID = 1L;
  private static final String DB_FILE_LOCATION = "customerDB.dat";
  private final List<Customer> customers = new ArrayList<>();

  public CustomerDB() {

    try {
      loadDB(customers, DB_FILE_LOCATION);
    } catch (Exception e) {
      if (customers.isEmpty()) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        customers.add(
            new Customer(
                "Lynsey",
                "Hoftijzer",
                LocalDate.parse("07/04/1983", dateTimeFormatter),
                "Emminkhuizen 90",
                "Utrecht",
                "06-15136961",
                "Lynsey.Hoftijzer@mail.com"));
        customers.add(
            new Customer(
                "Winfried",
                "Prudon",
                LocalDate.parse("23/12/1990", dateTimeFormatter),
                "De Vlecke 7",
                "Gorredijk",
                "06-21034318",
                "Winfried.Prudon@mail.com"));
        customers.add(
            new Customer(
                "Shanon",
                "Vorst",
                LocalDate.parse("21/04/1984", dateTimeFormatter),
                "Wetterwille 107",
                "Heerenveen",
                "06-18037209",
                "Shanon.Vorst@mail.com"));
        customers.add(
            new Customer(
                "Delphine",
                "van de Graaf",
                LocalDate.parse("27/04/1978", dateTimeFormatter),
                "Bijvankspad 96",
                "Dinxperlo",
                "06-70173826",
                "Delphine.vandeGraaf@mail.com"));
        customers.add(
            new Customer(
                "Berfin",
                "Methorst",
                LocalDate.parse("03/08/1975", dateTimeFormatter),
                "Leerweg 146",
                "Ulrum",
                "06-66214115",
                "Berfin.Methorst@mail.com"));
        customers.add(
            new Customer(
                "Irina",
                "Schapendonk",
                LocalDate.parse("20/10/1955", dateTimeFormatter),
                "Hunze 65",
                "Drachten",
                "06-77924191",
                "Irina.Schapendonk@mail.com"));
        writeDB(customers, DB_FILE_LOCATION);
      }
    }
    loadDB(customers, DB_FILE_LOCATION);
  }

  public void add(Customer c) {
    super.add(customers, c);
  }

  public void add(List c) {
    super.add(customers, c);
  }

  public void remove(Customer c) {
    super.remove(customers, c);
  }

  public void remove(List c) {
    super.remove(customers, c);
  }

  public List<Customer> getAllCustomers() {
    return customers;
  }
}
