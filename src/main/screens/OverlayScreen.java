package main.screens;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import main.engine.Manager;

public class OverlayScreen extends Screen<GridPane> {

    public OverlayScreen(Manager manager) {
        super(new GridPane());

        Label labelMoney = new Label("Money: " + manager.state.inventory.money);
        root.getChildren().add(labelMoney);
    }

    /**
     * Can be called by other classes to update the UI
     */
    public void update() {

    }

}

