package com.guitarshop.ui;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ErrorWindow {

  public ErrorWindow(String message, String title, boolean isConfirmation) {

    Alert alert;
    if (isConfirmation) {
      alert = new Alert(Alert.AlertType.INFORMATION);
    } else {
      alert = new Alert(Alert.AlertType.WARNING);
    }

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
