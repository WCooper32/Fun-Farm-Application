package main.screens;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.engine.Manager;

/**
 * 1. Have different class/app for UI (money, date, etc.)
 * 2. Have different class/app for graphics
 * 3. Game class needs to display empty plots (at least 10)
 * 4. Split into game mechanics and UI
 */
public class GameScreen {

    public StackPane root;

    public GameScreen(Manager manager) {
        root = new StackPane();

        // Game Overlay
        OverlayScreen overlayScreen = new OverlayScreen(manager);
        root.getChildren().add(overlayScreen.root);
    }

}
