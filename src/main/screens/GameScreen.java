package main.screens;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import main.engine.Manager;

import java.util.Stack;


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

        // Making plots inside a grid
        GridPane gridPane = new GridPane();
        root.getChildren().add(gridPane);

        gridPane.setGridLinesVisible(true);

        // allow button to grow:
        // button.setMaxWidth(Double.MAX_VALUE);
        // ask GridPane to make button fill it's cells:
        // GridPane.setFillWidth(button, true);
        // button.setMaxWidth(60);

        Label currLabel;
        for(int i = 0; i < 12; i++) {
            currLabel = new Label(("Plot " + i));
            gridPane.add(currLabel, (i/6 + 2), i%6);
        }

        gridPane.setHgap(20);
        gridPane.setVgap(20);



        // Farm plots


    }

}
