package tests.utility;

import javafx.scene.layout.Pane;
import main.engine.Manager;
import main.screens.Screen;
import main.state.StateGame;

public class TestScreen extends Screen<Pane> {

    private int renderCount;

    public TestScreen() {
        super(new Pane());
        renderCount = 0;
    }

    @Override
    public void render(StateGame state) {
        renderCount++;
    }

    public int getRenderCount() {
        return renderCount;
    }

}
