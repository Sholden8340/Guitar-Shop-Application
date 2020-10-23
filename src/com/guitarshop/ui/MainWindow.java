package com.guitarshop.ui;

import com.guitarshop.model.Employee;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class MainWindow {
  private Stage stage;
  private MenuBar menuBar;

  public MainWindow(Employee employee) {
    this.stage = new Stage();
    stage.setWidth(1024);
    stage.setHeight(800);
    setScene(homeScene(employee));
    stage.show();
  }

  private Scene homeScene(Employee employee) {
    VBox vBox = new VBox(10);
    Scene home = new Scene(vBox);
    stage.setTitle("Home - Guitar Shop");

    Label welcome = new Label("Welcome " + employee.getFirstName() + employee.getLastName());
    Label role = new Label(employee.getRole().toString());
    Label date = new Label(LocalDateTime.now().toString());

    vBox.getChildren().addAll(getMenuBar(employee), welcome, role, date);


    return home;
  }

  private Scene orderScene(Employee employee) {
    VBox vBox = new VBox();
    stage.setTitle("Order - Guitar Shop");
    vBox.getChildren().addAll(menuBar);

    return new Scene(vBox);
  }

  private Scene orderListScene(Employee employee) {
    VBox vBox = new VBox();
    stage.setTitle("Order List - Guitar Shop");
    vBox.getChildren().addAll(menuBar);

    return new Scene(vBox);
  }

  private Scene stockMaintainScene(Employee employee) {
    VBox vBox = new VBox();
    stage.setTitle("Stock Maintenance - Guitar Shop");
    vBox.getChildren().addAll(menuBar);

    return new Scene(vBox);
  }

  private MenuBar getMenuBar(Employee employee) {
    menuBar = new MenuBar();
    Menu homeMenu = new Menu("Home");
    Menu salesMenu = new Menu("Sales");
    Menu stockMenu = new Menu("Stock");

    MenuItem salesOrder = new MenuItem("Order");
    MenuItem salesListOrders = new MenuItem("List Orders");
    MenuItem stockMaintain = new MenuItem("Maintain");

    homeMenu.setOnAction(
        new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent actionEvent) {
            setScene(homeScene(employee));
          }
        });

    salesOrder.setOnAction(
        new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent actionEvent) {
            setScene(orderScene(employee));
          }
        });

    salesListOrders.setOnAction(
        new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent actionEvent) {
            setScene(orderListScene(employee));
          }
        });

    stockMaintain.setOnAction(
        new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent actionEvent) {
            setScene(stockMaintainScene(employee));
          }
        });

    switch (employee.getRole()) {
      case SALES:
        salesMenu.getItems().addAll(salesOrder, salesListOrders);
        menuBar.getMenus().addAll(homeMenu, salesMenu);
        break;
      case MANAGER:
        salesMenu.getItems().addAll(salesListOrders);
        stockMenu.getItems().addAll(stockMaintain);
        menuBar.getMenus().addAll(homeMenu, salesMenu, stockMenu);
        break;
      default:
        break;
    }
    return menuBar;
  }

  private void setScene(Scene scene) {
    stage.setScene(scene);
  }
}
