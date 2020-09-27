package main.engine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.screens.GameScreen;
import main.screens.OverlayScreen;
import main.screens.Screen;
import main.screens.SettingsScreen;
import main.screens.StartScreen;
import main.state.StateGame;

/**
 * Entry point into application
 *
 * 1. Switches between scenes
 * 2. Stores game state
 * - ex: game not started, plots info, etc.
 * could use enums for states
 * 3. Put player data here
 */

public class Manager extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Stage primaryStage;
    private StackPane root;
    private StateGame state;

    /**
     * Removes all children from the root stack
     */
    private void resetScreen() {
        root.getChildren().clear();
    }

    /**
     * Adds the given screen to the root stack
     * @param screen the screen who's root we will use
     */
    private void addScreen(Screen screen) {
        Pane screenRoot = screen.getRoot();
        root.getChildren().add(screenRoot);
    }

    /**
     * Removes the most recently added child of the root
     */
    private void popScreen() {
        if (root.getChildren().size() != 0) {
            root.getChildren().remove(root.getChildren().size() - 1);
        }
    }

    /**
     * Called by the JavaFX framework?
     * @param stage the primary stage that serves as the window
     */
    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        state = new StateGame();

        // Create the primary stack pane which will show all the screens
        root = new StackPane();
        Scene scene = new Scene(root, 1280, 720);
        scene.getStylesheets().addAll(this.getClass().
                getResource("../css/style.css").toExternalForm());

        // Show the pane
        primaryStage.setScene(scene);
        primaryStage.setTitle("Fun Farm");
        primaryStage.show();

        // Add the start screen to the stack
        addScreen(new StartScreen(this));
    }

    /**
     * Start the game if settings are initialized. If not, ask for settings.
     */
    public void startGame() {
        if (!state.getSettings().isInitialized()) {
            resetScreen();
            addScreen(new SettingsScreen(this));
        } else {
            // Sets money based on difficulty
            state.inventory.money = state.settings.setStartingMoney();

            resetScreen();
            addScreen(new GameScreen(this));
            addScreen(new OverlayScreen(this));
        }
    }

    public StateGame getState() {
        return state;
    }

}
