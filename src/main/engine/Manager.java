package main.engine;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.screens.GameScreen;
import main.screens.SettingsScreen;
import main.screens.StartScreen;

/**
 * 1. Switches between scenes
 * 2. Stores game state
 * - ex: game not started, plots info, etc.
 * could use enums for states
 * 3. Put player data here
 */

public class Manager extends Application {

    private Stage primaryStage;
    public GameState state;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        state = new GameState();

        Pane root = new StartScreen(this).root;
        Scene scene = new Scene(root, 1280,720);
        scene.getStylesheets().addAll(this.getClass().getResource("../css/style.css").toExternalForm());

        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Welcome screen pressed");
                startGame();
            }
        });

        primaryStage.setTitle("Fun Farm");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void startGame() {
        if (state.settings == null) {
            Pane root = new SettingsScreen(this).root;
            Scene scene = new Scene(root, 1280,720);
            scene.getStylesheets().addAll(this.getClass().getResource("../css/style.css").toExternalForm());
            primaryStage.setScene(scene);
        } else {
            Pane root = new GameScreen(this).root;
            Scene scene = new Scene(root, 1280,720);
            scene.getStylesheets().addAll(this.getClass().getResource("../css/style.css").toExternalForm());
            primaryStage.setScene(scene);
        }
    }

}
