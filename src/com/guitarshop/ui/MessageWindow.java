package com.guitarshop.ui;

import com.guitarshop.model.Customer;
import com.guitarshop.model.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.List;

public class MessageWindow {

  private Stage stage;
  private Employee employee;

  public MessageWindow(Employee employee) {
    this.stage = new Stage();
    this.employee = employee;
    stage.setWidth(800);
    stage.setHeight(600);
    stage.show();
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

    orderListView.getColumns().addAll(firstNameColumn, lastNameColumn, dateOfBirthColumn, streetAddressColumn, phoneNumberColumn, emailAddressColumn);
    orderListView.setItems(customerObservableList);

    orderListView.getSelectionModel().getSelectedItem();

    vBox.getChildren().addAll(labelCustomerSearch, orderListView);
    return new Scene(vBox);
  }

  public void setCustomerScene(List<Customer> customerList) {
    stage.setScene(customerSearch(customerList));
  }


}
