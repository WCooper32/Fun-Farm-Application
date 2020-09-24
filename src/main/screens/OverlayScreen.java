package main.screens;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import main.engine.Manager;
import main.state.StateGame;

public class OverlayScreen extends Screen<BorderPane> {

    private BorderPane ui;

    public OverlayScreen(Manager manager) {
        super(new BorderPane());
        this.ui = new BorderPane();
        this.root.setTop(ui);
    }

    /**
     * handles the drawing of the UI
     */
    @Override
    public void render(StateGame state) {
        ui.getChildren().clear();

        VBox resources = new VBox();
        Label labelMoney = new Label("Money: " + state.inventory.money);
        Label labelCorn = new Label("Corn: " + state.inventory.corn);
        Label labelWheat = new Label("Wheat: " + state.inventory.wheat);
        resources.getChildren().addAll(labelMoney, labelCorn, labelWheat);
        ui.setLeft(resources);

        Label labelDay = new Label("Day: " + state.environment.getDay());
        ui.setCenter(labelDay);
    }

}
