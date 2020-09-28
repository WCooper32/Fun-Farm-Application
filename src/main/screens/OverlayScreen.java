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

        Label labelMoney = new Label("Money: " + state.getInventory().getMoney());
        Label labelCorn = new Label("Corn: " + state.getInventory().getCorn());
        Label labelWheat = new Label("Wheat: " + state.getInventory().getWheat());
        resources.getChildren().addAll(labelMoney, labelCorn, labelWheat);
        ui.setLeft(resources);

        Label labelDay = new Label("Day: " + state.getEnvironment().getDay());
        ui.setCenter(labelDay);
    }

}
