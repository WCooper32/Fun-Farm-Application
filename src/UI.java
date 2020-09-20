
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


public class UI {

    private GridPane overlay;
    private Controller controller;
    private Label labelMoney;

    public UI(Controller controller) {
        overlay = new GridPane();
        this.controller = controller;
        labelMoney = new Label("Money: " + controller.getMoney());
        overlay.getChildren().add(labelMoney);
    }
    public void update() {}
    public GridPane getPane() {
        return overlay;
    }
}

