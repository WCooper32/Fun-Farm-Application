package tests;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import main.engine.Manager;
import main.screens.OverlayScreen;
import main.state.StateGame;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import tests.utility.JavaFXThreadingRule;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OverlayUITests {
    private static final int TIMEOUT = 200;
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
    //this rule allows JavaFX objects to be made in these tests

    public Manager manager;
    public OverlayScreen mainScreen;
    private StateGame state;

    @Before
    public void setup() {
        manager = new Manager();
        state = new StateGame();
        mainScreen = new OverlayScreen(manager);
    }

    @Test (timeout = TIMEOUT)
    public void testResources() {
        mainScreen.render(state);

        VBox resources = new VBox();

        Label labelMoney = new Label("Money: " + state.getInventory().getMoney());
        Label labelCorn = new Label("Corn: " + state.getInventory().getCorn());
        Label labelWheat = new Label("Wheat: " + state.getInventory().getWheat());
        resources.getChildren().addAll(labelMoney, labelCorn, labelWheat);

        ArrayList<Label> list = new ArrayList<>();
        list.add(labelMoney);
        list.add(labelCorn);
        list.add(labelWheat);
        VBox actualResources = (VBox) ((BorderPane)((BorderPane)mainScreen.getRoot()).getTop()).getLeft();

        boolean isSame = true;

        //check to see if the list that I just made is equal to the mainScreen's resource list
        if (list.size() != actualResources.getChildren().size()) {
            isSame = false;
        } else {
            for (int i = 0; i < list.size(); i++) {
                Label curr = (Label) actualResources.getChildren().get(i);
                if (!curr.getText().equals(list.get(i).getText())) {
                    isSame = false;
                    break;
                }
            }
        }
        assertTrue(isSame);
    }


}
