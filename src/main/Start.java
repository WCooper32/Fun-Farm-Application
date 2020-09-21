package main;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Start extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //PANE
        VBox root = new VBox();
        root.setId("pane");
        root.setFillWidth(true);

        //BACKGROUND
        Scene scene = new Scene(root, 1280,720);
        scene.getStylesheets().addAll(this.getClass().getResource("css/style.css").toExternalForm());

        //TITLE
        Label title = new Label("Fun Farm");
        title.setFont(new Font(90));
        title.setTextFill(Color.WHITE);
        title.setFont(Font.font(null, FontWeight.BOLD, 90));

        //Drop Shadow
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
        title.setEffect(ds);

        //Position
        VBox.setMargin(title, new Insets(150,0,250,0));
        title.setPrefWidth(Double.MAX_VALUE);
        title.setAlignment(Pos.BASELINE_CENTER);
        root.getChildren().add(title);

        //CLICK ANYWHERE
        Label click = new Label("Click Anywhere to Continue");
        click.setTextFill(Color.WHITE);
        click.setFont(Font.font(null, FontWeight.BOLD,14));
        click.setPrefWidth(Double.MAX_VALUE);
        click.setAlignment(Pos.BASELINE_CENTER);
        root.getChildren().add(click);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.5), click);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setCycleCount(Animation.INDEFINITE);
        fadeTransition.play();

        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Welcome screen pressed");
                Settings settingsScreen = new Settings();
                settingsScreen.start(primaryStage);
            }
        });

        //STAGE
        primaryStage.setTitle("Fun Farm");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
