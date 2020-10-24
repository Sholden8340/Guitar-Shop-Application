package com.guitarshop.ui;

import com.guitarshop.model.Article;
import com.guitarshop.model.Employee;
import com.guitarshop.model.Order;
import com.guitarshop.model.OrderItem;
import com.guitarshop.service.EmployeeService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainWindow {
  private final Stage stage;
  EmployeeService employeeDB = new EmployeeService();
  private MenuBar menuBar;
  private final Employee employee;

  public MainWindow(Employee employee) {
    this.stage = new Stage();
    this.employee = employee;

    stage.setWidth(1024);
    stage.setHeight(800);
    setScene(homeScene());
    stage.show();
  }

  private Scene homeScene() {
    VBox vBox = new VBox(10);
    Scene home = new Scene(vBox);
    stage.setTitle("Home - Guitar Shop");



    Label welcome = new Label(String.format("Welcome %s %s", employee.getFirstName(), employee.getLastName()));
    Label role = new Label(employee.getRole().toString());

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm");
    Label date = new Label(dateTimeFormatter.format(LocalDateTime.now()));

    vBox.getChildren().addAll(getMenuBar(), welcome, role, date);

    return home;
  }

  private Scene orderScene() {
    VBox vBox = new VBox();
    stage.setTitle("Order - Guitar Shop");

    Label labelCreateOrder = new Label("Create Order");

    HBox customerInfoHBox = new HBox(10);

    VBox customerSearch = new VBox(10);
    Label labelCustomerSearch = new Label("Customer");

    HBox customerSearchHBox = new HBox(10);
    TextField customerSearchTextField = new TextField();
    Button customerSearchButton = new Button("Search");
    customerSearchHBox.getChildren().addAll(customerSearchTextField, customerSearchButton);
    customerSearch.getChildren().addAll(labelCustomerSearch, customerSearchHBox);

    GridPane customerDetails = new GridPane();

    Label firstName = new Label("First Name: ");
    Label firstNameCustomer = new Label("xxxxxxxxxxxxxxxxx");
    Label lastName = new Label("Last Name: ");
    Label lastNameCustomer = new Label("xxxxxxxxxxxxxxxxx");
    Label address = new Label("Street Address: ");
    Label addressCustomer = new Label("xxxxxxxxxxxxxxxxx");
    Label city = new Label("City: ");
    Label cityCustomer = new Label("xxxxxxxxxxxxxxxxx ");
    Label phoneNumber = new Label("Phone Number: ");
    Label phoneNumberCustomer = new Label("xxxxxxxxxxxxxxxxx");
    Label email = new Label("Email: ");
    Label emailCustomer = new Label("xxxxxxxxxxxxxxxxx");

    GridPane.setConstraints(firstName, 0, 0);
    GridPane.setConstraints(firstNameCustomer, 1, 0);
    GridPane.setConstraints(lastName, 2, 0);
    GridPane.setConstraints(lastNameCustomer, 3, 0);
    GridPane.setConstraints(address, 0, 1);
    GridPane.setConstraints(addressCustomer, 1, 1);
    GridPane.setConstraints(city, 2, 1);
    GridPane.setConstraints(cityCustomer, 3, 1);
    GridPane.setConstraints(phoneNumber, 0, 2);
    GridPane.setConstraints(phoneNumberCustomer, 1, 2);
    GridPane.setConstraints(email, 2, 2);
    GridPane.setConstraints(emailCustomer, 3, 2);

    customerDetails
        .getChildren()
        .addAll(
            firstName,
            firstNameCustomer,
            lastName,
            lastNameCustomer,
            address,
            addressCustomer,
            city,
            cityCustomer,
            phoneNumber,
            phoneNumberCustomer,
            email,
            emailCustomer);
    customerDetails.setPadding(new Insets(10));
    customerDetails.setHgap(10);
    customerDetails.setVgap(10);

    customerInfoHBox.getChildren().addAll(customerSearch, customerDetails);

    Label labelArticles = new Label("Articles");
    ListView<Article> articleListView = new ListView<>();
    HBox articleHBox = new HBox();
    Button addArticleButton = new Button("Add Article");
    Button removeArticleButton = new Button("Remove Article");
    Button confirmOrderButton = new Button("Confirm Order");
    Button cancelOrderButton = new Button("Reset Order");
    articleHBox
        .getChildren()
        .addAll(addArticleButton, removeArticleButton, confirmOrderButton, cancelOrderButton);

    vBox.getChildren()
        .addAll(
            menuBar,
            labelCreateOrder,
            customerInfoHBox,
            labelArticles,
            articleListView,
            articleHBox);
    return new Scene(vBox);
  }

  private Scene orderListScene() {
    VBox vBox = new VBox(15);
    stage.setTitle("Order List - Guitar Shop");

    Label labelOrderList = new Label("Order List");
    ListView<Order> orderListView = new ListView<>();

    Label labelOrderDetails = new Label("Order Details");
    ListView<OrderItem> orderDetailsView = new ListView<>();

    vBox.getChildren()
        .addAll(menuBar, labelOrderList, orderListView, labelOrderDetails, orderDetailsView);

    return new Scene(vBox);
  }

  private Scene stockMaintainScene() {
    VBox vBox = new VBox();
    stage.setTitle("Stock Maintenance - Guitar Shop");

    VBox vBox1 = new VBox(10);
    Label labelStockMaintenance = new Label("Stock Maintenance");
    ListView<Article> stockListView = new ListView<>();

    HBox hBoxStockChange = new HBox(10);
    TextField stockQuantityTextField = new TextField();
    stockQuantityTextField.setPromptText("Quantity");
    Button changeStockButton = new Button("Change");

    hBoxStockChange.getChildren().addAll(stockQuantityTextField, changeStockButton);

    vBox1.getChildren().addAll(labelStockMaintenance, stockListView, hBoxStockChange);
    vBox.getChildren().addAll(menuBar, vBox1);

    return new Scene(vBox);
  }

  private MenuBar getMenuBar() {
    menuBar = new MenuBar();
    Menu homeMenu = new Menu("Home");
    MenuItem homeMenuItem = new MenuItem("Home");
    homeMenu.getItems().add(homeMenuItem);

    Menu salesMenu = new Menu("Sales");
    MenuItem salesOrder = new MenuItem("Order");
    MenuItem salesListOrders = new MenuItem("List Orders");

    Menu stockMenu = new Menu("Stock");
    MenuItem stockMaintain = new MenuItem("Maintain");

    homeMenu.setOnAction(
        new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent actionEvent) {
            setScene(homeScene());
          }
        });

    salesOrder.setOnAction(
        new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent actionEvent) {
            setScene(orderScene());
          }
        });

    salesListOrders.setOnAction(
        new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent actionEvent) {
            setScene(orderListScene());
          }
        });

    stockMaintain.setOnAction(
        new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent actionEvent) {
            setScene(stockMaintainScene());
          }
        });
    switch (employee.getRole()) {
      case SALES:
        salesMenu.getItems().addAll(salesOrder, salesListOrders);
        menuBar.getMenus().addAll(homeMenu, salesMenu);
        break;
      case MANAGER:
        salesMenu.getItems().add(salesListOrders);
        stockMenu.getItems().add(stockMaintain);
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
