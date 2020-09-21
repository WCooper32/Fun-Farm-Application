package main.screens;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;
import main.engine.Manager;

public class StartScreen {

    public VBox root;

    public StartScreen(Manager manager) {

        //PANE
        root = new VBox();
        root.setId("pane");
        root.setFillWidth(true);

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

    }
}
