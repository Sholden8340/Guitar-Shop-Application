package com.guitarshop.ui;

import com.guitarshop.model.Employee;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class MessageWindow {

  private final Stage stage;
  private final Employee employee;
  private MenuBar menuBar;

  public MessageWindow(Employee employee) {
    this.stage = new Stage();
    this.employee = employee;
    stage.setTitle("");
    stage.setWidth(800);
    stage.setHeight(600);
    stage.show();
  }
}
