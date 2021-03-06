package main.screens;

import javafx.scene.layout.Pane;
import main.state.StateGame;

public abstract class Screen<T extends Pane> {

    /**
     * The root pane for this screen
     */
    protected T root;

    public Screen(T root) {
        this.root = root;
    }

    public Pane getRoot() {
        return root;
    }

    public void render(StateGame state) {
    }

}
