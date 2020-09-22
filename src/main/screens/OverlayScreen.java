package main.screens;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import main.engine.Manager;

public class OverlayScreen extends Screen<BorderPane> {

    private BorderPane UI;
    private Manager manager;

    public OverlayScreen(Manager manager) {
        super(new BorderPane());
        this.manager = manager;
        this.UI = new BorderPane();
        draw();
        this.root.setTop(UI);
    }

    /**
     * handles the drawing of the UI
     */
    private void draw() {
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

    /**
     * returns manager
     * @return this.manager
     */
    public Manager getManager() {
        return this.manager;
    }

    public void incrementMoney(int increment) {
        this.manager.state.inventory.incrementMoney(increment);
        this.draw();
    }

    public void incrementWheat(int increment) {
        this.manager.state.inventory.incrementWheat(increment);
        this.draw();
    }

    public void incrementCorn(int increment) {
        this.manager.state.inventory.incrementCorn(increment);
        this.draw();
    }
}
