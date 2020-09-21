package main;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Overlay {

    private GridPane overlay;
    private Manager manager;
    private Label labelMoney;

    public Overlay(Manager manager) {
        overlay = new GridPane();
        this.manager = manager;
        labelMoney = new Label("Money: " + manager.getMoney());
        overlay.getChildren().add(labelMoney);
    }

    public void update() {

    }

    public GridPane getPane() {
        return overlay;
    }
}

