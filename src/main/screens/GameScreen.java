package main.screens;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import main.engine.Grid;
import main.engine.Manager;
import main.sprites.Plot;
import main.state.StateGame;

/**
 * 1. Have different class/app for UI (money, date, etc.)
 * 2. Have different class/app for graphics
 * 3. Game class needs to display empty plots (at least 10)
 * 4. Split into game mechanics and UI
 */
public class GameScreen extends Screen<Pane> {

    private Grid grid;

    public GameScreen(Manager manager) {
        super(new Pane());

        grid = new Grid();
        for (int i = 0; i < 12; i++) {
            grid.addSprite(new Plot(), (i / 6 + 2) * 68, (i % 6 + 1) * 52);
        }

    }

    @Override
    public void render(StateGame state) {
        Pane frame = grid.render();
        root.getChildren().clear();
        root.getChildren().add(frame);
    }

}