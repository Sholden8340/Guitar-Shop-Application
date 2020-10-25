package com.guitarshop.ui;

import com.guitarshop.model.Employee;
import com.guitarshop.service.EmployeeService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginWindow extends Application {
  private final EmployeeService employeeDB = new EmployeeService();

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    stage.setMinWidth(400);
    stage.setMinHeight(300);
    stage.setTitle("Login");
    stage.setWidth(400);
    stage.setHeight(300);
    GridPane gridPane = new GridPane();
    gridPane.setHgap(10);
    gridPane.setVgap(10);
    gridPane.setPadding(new Insets(10));

    Label usernameLabel = new Label("Username: ");
    Label passwordLabel = new Label("Password: ");

    TextField usernameTextBox = new TextField();
    usernameTextBox.setPromptText("Username");
    PasswordField passwordTextBox = new PasswordField();
    passwordTextBox.setPromptText("Password");

    Button loginButton = new Button("Login");
    loginButton.setOnAction(
        new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent actionEvent) {

            if (employeeDB.isValidEmployee(usernameTextBox.getText(), passwordTextBox.getText())) {
              Employee p = employeeDB.getEmployeeByUsername(usernameTextBox.getText());
              new MainWindow(p);
              stage.close();
            } else {
              passwordTextBox.setText("");
              usernameTextBox.setText("");

              new ErrorWindow("Invalid Login", "Invalid Login");
            }
          }
        });

    GridPane.setConstraints(usernameLabel, 0, 0);
    GridPane.setConstraints(passwordLabel, 0, 1);
    GridPane.setConstraints(usernameTextBox, 1, 0);
    GridPane.setConstraints(passwordTextBox, 1, 1);
    GridPane.setConstraints(loginButton, 1, 2);

    gridPane.getChildren().add(usernameLabel);
    gridPane.getChildren().add(passwordLabel);
    gridPane.getChildren().add(usernameTextBox);
    gridPane.getChildren().add(passwordTextBox);
    gridPane.getChildren().add(loginButton);

    Scene loginWindow = new Scene(gridPane);
    stage.setScene(loginWindow);
    stage.show();
  }
}
