import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * 1. Have different class/app for UI (money, date, etc.)
 * 2. Have different class/app for graphics
 * 3. Game class needs to display empty plots (at least 10)
 * 4. Split into game mechanics and UI
 */
public class Game extends Application {
    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 1280, 720);

        //Overlay
        Controller controller = new Controller();
        UI overlay = new UI(controller);
        root.getChildren().add(overlay.getPane());


        stage.setScene(scene);
    }
}
