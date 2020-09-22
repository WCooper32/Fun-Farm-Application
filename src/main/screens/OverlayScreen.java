package main.screens;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import main.engine.Manager;

public class OverlayScreen extends Screen<BorderPane> {

//    private Manager manager;
    private HBox UITop;

    public OverlayScreen(Manager manager) {
        super(new BorderPane());



        this.UITop = new HBox();

        draw(manager);

        this.root.setTop(UITop);
    }

    /**
     * handles the drawing of the UI
     */
    private void draw(Manager manager) {
        UITop.getChildren().clear();

        Label labelMoney = new Label("Money: " + manager.state.inventory.money);
        UITop.getChildren().add(labelMoney);

        Label labelDay = new Label("Day: " + manager.state.environment.getDay());
        UITop.getChildren().add(labelDay);
    }

}

