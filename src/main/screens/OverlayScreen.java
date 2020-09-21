package main.screens;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import main.engine.Manager;

public class OverlayScreen {

    public GridPane root;

    public OverlayScreen(Manager manager) {
        root = new GridPane();

        Label labelMoney = new Label("Money: " + manager.state.inventory.money);
        root.getChildren().add(labelMoney);
    }

    public void update() {

    }

}

