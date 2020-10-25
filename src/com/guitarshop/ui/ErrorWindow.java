package com.guitarshop.ui;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ErrorWindow {

  public ErrorWindow(String message, String title) {

    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle(title);
    alert.setHeaderText(message);
    alert.setContentText("");
    alert
        .showAndWait()
        .ifPresent(
            rs -> {
              if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
              }
            });
  }
}
