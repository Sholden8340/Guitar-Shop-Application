package com.guitarshop.model;

import java.time.LocalDate;

public class Employee extends Person {
    EmployeeRole role;

    public Employee(String firstName, String lastName, LocalDate birthDate, EmployeeRole role) {
        super(firstName, lastName, birthDate);
        this.role = role;
    }

    public EmployeeRole getRole() {
        return role;
    }

    public void setRole(EmployeeRole role) {
        this.role = role;
    }
}
