package main.screens;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import main.engine.Manager;


/**
 * 1. Have different class/app for UI (money, date, etc.)
 * 2. Have different class/app for graphics
 * 3. Game class needs to display empty plots (at least 10)
 * 4. Split into game mechanics and UI
 */
public class GameScreen extends Screen<GridPane> {

    public GameScreen(Manager manager) {
        super(new GridPane());

        root.setGridLinesVisible(true);

        Label currLabel;
        for(int i = 0; i < 12; i++) {
            currLabel = new Label(("Plot " + i));
            root.add(currLabel, (i/6 + 2), i%6);
        }
    }

}
