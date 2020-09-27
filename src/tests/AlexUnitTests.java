package tests;

import javafx.application.Platform;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.engine.Manager;
import main.screens.Screen;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import tests.utility.JavaFXThreadingRule;
import tests.utility.TestScreen;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AlexUnitTests {

    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    private static final int TIMEOUT = 200;
    private Manager manager;
    private StackPane root;

    @Before
    public void setup() {
        Stage primaryStage = new Stage();
        manager = new Manager();
        manager.start(primaryStage);
        root = (StackPane) primaryStage.getScene().getRoot();
    }

    @Test(timeout = TIMEOUT)
    public void testAddRemoveScreens() {
        Platform.runLater(
            () -> {
                Screen s1 = new TestScreen();
                Screen s2 = new TestScreen();
                Screen s3 = new TestScreen();

                manager.addScreen(s1);
                manager.addScreen(s2);
                manager.addScreen(s3);
                assertEquals(root.getChildren().size(), 4);

                assertEquals(s3, manager.popScreen());
                assertEquals(root.getChildren().size(), 3);

                manager.resetScreen();
                assertEquals(root.getChildren().size(), 0);
            }
        );
    }

    @Test(timeout = TIMEOUT)
    public void testRenderScreens() {
        Platform.runLater(
            () -> {
                TestScreen s1 = new TestScreen();
                TestScreen s2 = new TestScreen();
                TestScreen s3 = new TestScreen();

                manager.addScreen(s1);
                manager.addScreen(s2);
                manager.addScreen(s3);

                new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            assertTrue(s1.getRenderCount() > 0);
                            assertTrue(s2.getRenderCount() > 0);
                            assertTrue(s3.getRenderCount() > 0);
                        }
                    },
                    500
                );
            }
        );
    }

}
