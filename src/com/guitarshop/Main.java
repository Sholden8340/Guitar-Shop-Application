package com.guitarshop;

import com.guitarshop.model.Employee;
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

public class Main extends Application {
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
    stage.show();

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

            Employee p = getValidUser(usernameTextBox.getText(), passwordTextBox.getText());

            stage.close();
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

  private Employee getValidUser(String userName, String userPassword) {

    throw new java.lang.UnsupportedOperationException("Not Implemented yet.");
  }

  private boolean isValidLogin(Employee e) {

    throw new java.lang.UnsupportedOperationException("Not Implemented yet.");
  }
}
