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
    Label visiblePassword = new Label();

    TextField usernameTextBox = new TextField();
    usernameTextBox.setPromptText("Username");
    PasswordField passwordTextBox = new PasswordField();
    passwordTextBox.setPromptText("Password");

    Button loginButton = new Button("Login");
    // loginButton.setVisible(false);
    loginButton.setOnAction(
        new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent actionEvent) {

            if (employeeDB.isValidEmployee(usernameTextBox.getText(), passwordTextBox.getText())) {
              Employee p = employeeDB.getEmployeeByUsername(usernameTextBox.getText());

              System.out.println("Employee in action event");
              System.out.println(p.toString());
              new MainWindow(p);
              stage.close();
            } else {
              // Invalid login
              passwordTextBox.setText("");
              usernameTextBox.setText("");
              // throw new In;
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

    // VBox vBox = new VBox();
    // vBox.getChildren().addAll(gridPane, visiblePassword);

    Scene loginWindow = new Scene(gridPane);
    stage.setScene(loginWindow);
    stage.show();

    /*    StringProperty passwordFieldProperty = passwordTextBox.textProperty();
    passwordFieldProperty.addListener(
        new ChangeListener<String>() {
          @Override
          public void changed(
              ObservableValue<? extends String> observableValue, String oldValue, String newValue) {

            loginButton.setVisible(true);
          }
        });

    visiblePassword.textProperty().bind(passwordFieldProperty);*/
  }
}
