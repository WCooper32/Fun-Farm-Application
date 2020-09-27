package main.engine;

import javafx.animation.AnimationTimer;
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

import java.util.ArrayList;

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
    private ArrayList<Screen> screens;

    /**
     * revmoves all children
     */
    public void resetScreen() {
        root.getChildren().clear();
        screens.clear();
    }

    /**
     * Adds the given screen to the root stack
     * @param screen the screen who's root we will use
     */
    public void addScreen(Screen screen) {
        Pane screenRoot = screen.getRoot();
        root.getChildren().add(screenRoot);
        screens.add(screen);
    }

    /**
     * Removes the most recently added child of the root
     */
    public Screen popScreen() {
        if (root.getChildren().size() != 0) {
            root.getChildren().remove(root.getChildren().size() - 1);
            return screens.remove(screens.size() - 1);
        }
        return null;
    }

    /**
     * Called by the JavaFX framework?
     * @param stage the primary stage that serves as the window
     */
    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        state = new StateGame();
        screens = new ArrayList<>();

        // Create the primary stack pane which will show all the screens
        root = new StackPane();
        Scene scene = new Scene(root, 1280,720);
        scene.getStylesheets().addAll(this.getClass().getResource("../css/style.css").toExternalForm());

        // Show the pane
        primaryStage.setScene(scene);
        primaryStage.setTitle("Fun Farm");
        primaryStage.show();

        // Add the start screen to the stack
        addScreen(new StartScreen(this));

        // Start the render loop
        RenderLoop renderLoop = new RenderLoop();
        renderLoop.start();
    }

    /**
     * Start the game if settings are initialized. If not, ask for settings.
     */
    public void startGame() {
        if (!state.settings.initialized) {
            resetScreen();
            addScreen(new SettingsScreen(this));
        } else {
            resetScreen();
            addScreen(new GameScreen(this));
            addScreen(new OverlayScreen(this));
        }
    }

    public StateGame getState() {
        return state;
    }

    private class RenderLoop extends AnimationTimer {
        @Override
        public void handle(long now) {
            for (Screen screen : screens) {
                screen.render(state);
            }
        }
    }
    
}

