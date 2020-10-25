package com.guitarshop.ui;

import com.guitarshop.model.Customer;
import com.guitarshop.model.Employee;
import com.guitarshop.model.Guitar;
import com.guitarshop.model.OrderItem;
import com.guitarshop.service.StockService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.List;

public class MessageWindow {

  private Stage stage;
  private Employee employee;
  private Customer customer;
  private Guitar guitar;
  private int guitarQuantity;

  public MessageWindow(Employee employee) {
    this.stage = new Stage();
    this.employee = employee;
    stage.setWidth(800);
    stage.setHeight(600);
  }

  private Scene customerSearch(List<Customer> customers) {
    VBox vBox = new VBox(15);
    stage.setTitle("Customer Search - Guitar Shop");

    Label labelCustomerSearch = new Label("Search Results");
    TableView<Customer> orderListView = new TableView<>();
    ObservableList<Customer> customerObservableList = FXCollections.observableArrayList(customers);

    TableColumn<Customer, String> firstNameColumn = new TableColumn<>("First name");
    firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    TableColumn<Customer, String> lastNameColumn = new TableColumn<>("Last name");
    lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    TableColumn<Customer, LocalDate> dateOfBirthColumn = new TableColumn<>("Date Of Birth");
    dateOfBirthColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
    TableColumn<Customer, String> streetAddressColumn = new TableColumn<>("Street Address");
    streetAddressColumn.setCellValueFactory(new PropertyValueFactory<>("streetAddress"));
    TableColumn<Customer, String> cityColumn = new TableColumn<>("City");
    cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
    TableColumn<Customer, String> phoneNumberColumn = new TableColumn<>("Phone Number");
    phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
    TableColumn<Customer, String> emailAddressColumn = new TableColumn<>("Email Address");
    emailAddressColumn.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));

    orderListView
        .getColumns()
        .addAll(
            firstNameColumn,
            lastNameColumn,
            dateOfBirthColumn,
            streetAddressColumn,
            phoneNumberColumn,
            emailAddressColumn);
    orderListView.setItems(customerObservableList);
    orderListView.setOnMouseClicked(
        new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent mouseEvent) {
            customer = orderListView.getSelectionModel().getSelectedItem();
            stage.close();
          }
        });

    vBox.getChildren().addAll(labelCustomerSearch, orderListView);
    return new Scene(vBox);
  }

  private Scene articleSearch() {
    StockService stockService = new StockService();

    VBox vBox1 = new VBox(10);
    TableView<Guitar> stockListView = new TableView<>();
    stockListView.setEditable(true);
    ObservableList<Guitar> stockObservableList =
        FXCollections.observableArrayList(stockService.getAllGuitars());

    TableColumn<Guitar, String> brandColumn = new TableColumn<>("Brand");
    brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));

    TableColumn<Guitar, String> modelColumn = new TableColumn<>("Model");
    modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));

    TableColumn<Guitar, String> guitarTypeColumn = new TableColumn<>("Type");
    guitarTypeColumn.setCellValueFactory(new PropertyValueFactory<>("guitarType"));

    TableColumn<Guitar, Double> priceColumn = new TableColumn<>("Price");
    priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

    TableColumn<Guitar, Integer> stockQuantityColumn = new TableColumn<>("Amount in Stock");
    stockQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("stockQuantity"));

    stockListView
        .getColumns()
        .addAll(brandColumn, modelColumn, guitarTypeColumn, priceColumn, stockQuantityColumn);
    stockListView.setItems(stockObservableList);

    stockListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent mouseEvent) {
        guitar = stockListView.getSelectionModel().getSelectedItem();
      }
    });

    Label notEnoughStock = new Label("Not enough items in stock");
    notEnoughStock.setVisible(false);

    HBox hBoxOrderAmount = new HBox(10);
    TextField articleQuantityTextField = new TextField();
    articleQuantityTextField.setPromptText("Quantity");
    Button addToOrderButton = new Button("Add");
    Button cancelOrderButton = new Button("Change");
    hBoxOrderAmount
        .getChildren()
        .addAll(articleQuantityTextField, addToOrderButton, cancelOrderButton);

    addToOrderButton.setOnAction(
        new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent actionEvent) {
            try{
              int quantity = Integer.parseInt(articleQuantityTextField.getText());
              if(quantity > guitar.getStockQuantity()){
                notEnoughStock.setVisible(true);
              }
              else{
                guitarQuantity = quantity;
                stage.close();
              }
            }catch (Exception e){
              e.printStackTrace();
            }
          }
        });

    cancelOrderButton.setOnAction(
        new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent actionEvent) {
            stage.close();
          }
        });
    vBox1.getChildren().addAll(stockListView, hBoxOrderAmount, notEnoughStock);
    return new Scene(vBox1);
  }

  public Customer getSelectedCustomer(List<Customer> customerList) {
    stage.setScene(customerSearch(customerList));
    stage.showAndWait();
    return customer;
  }

  public OrderItem getSelectedGuitar(){
    stage.setScene(articleSearch());
    stage.showAndWait();
    return new OrderItem(guitar, guitarQuantity);
  }
}
