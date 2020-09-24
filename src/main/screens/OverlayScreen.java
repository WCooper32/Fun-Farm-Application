package main.screens;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import main.engine.Manager;

public class OverlayScreen extends Screen<BorderPane> {

    private BorderPane UI;

    public OverlayScreen(Manager manager) {
        super(new BorderPane());
        this.UI = new BorderPane();
        draw(manager);
        this.root.setTop(UI);
    }

    /**
     * handles the drawing of the UI
     */
    private void draw(Manager manager) {
        UI.getChildren().clear();

        VBox resources = new VBox();
        Label labelMoney = new Label("Money: " + manager.state.inventory.money);
        Label labelCorn = new Label("Corn: " + manager.state.inventory.corn);
        Label labelWheat = new Label("Wheat: " + manager.state.inventory.wheat);
        resources.getChildren().addAll(labelMoney, labelCorn, labelWheat);
        UI.setLeft(resources);

        Label labelDay = new Label("Day: " + manager.state.environment.getDay());
        UI.setCenter(labelDay);
    }

    public void incrementMoney(Manager manager, int increment) {
        manager.state.inventory.incrementMoney(increment);
        this.draw(manager);
    }

    public void incrementWheat(Manager manager, int increment) {
        manager.state.inventory.incrementWheat(increment);
        this.draw(manager);
    }

    public void incrementCorn(Manager manager, int increment) {
        manager.state.inventory.incrementCorn(increment);
        this.draw(manager);
    }
}
