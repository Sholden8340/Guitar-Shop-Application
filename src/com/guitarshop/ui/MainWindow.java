package com.guitarshop.ui;

import com.guitarshop.model.Employee;
import javafx.stage.Stage;

public class MainWindow {
    private Stage stage;

    public MainWindow(Employee employee) {
        this.stage = new Stage();
        stage.setWidth(1024);
        stage.setHeight(800);

        
    }
}
