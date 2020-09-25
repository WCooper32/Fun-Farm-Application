package main.screens;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.engine.Manager;

import javax.swing.*;
import java.awt.*;

public class SettingsScreen extends Screen<VBox> {

    public SettingsScreen(Manager manager) {
        super(new VBox());
        System.out.println("Started settings screen");

        root.setPadding(new Insets(10, 50, 50, 50));
        root.setId("settings");
        root.getStylesheets().addAll(this.getClass().getResource("../css/style.css").toExternalForm());

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
        VBox.setMargin(title, new Insets(0,0,0,0));
        title.setPrefWidth(Double.MAX_VALUE);
        title.setAlignment(Pos.TOP_LEFT);
        root.getChildren().add(title);

        //NAME
        Label lName = new Label("Name:");
        lName.setFont(Font.font(null, FontWeight.BOLD, 14));
        TextField tfName = new TextField ();
        HBox hb = new HBox();
        root.getChildren().add(hb);
        hb.getChildren().addAll(lName, tfName);
        hb.setSpacing(10);

        //DIFFICULTY
        Label lDifficulty = new Label("Choose Difficulty:");
        lDifficulty.setFont(Font.font(null, FontWeight.BOLD, 14));
        ToggleGroup tDifficulty = new ToggleGroup();
        RadioButton bNoobDiff = new RadioButton("Easy");
        bNoobDiff.setToggleGroup(tDifficulty);
        RadioButton bNormalDiff = new RadioButton("Medium");
        bNormalDiff.setToggleGroup(tDifficulty);
        RadioButton bNSaneDiff = new RadioButton("Hard");
        bNSaneDiff.setToggleGroup(tDifficulty);
        root.getChildren().addAll(lDifficulty, bNoobDiff, bNormalDiff, bNSaneDiff);
        VBox.setMargin(lDifficulty, new Insets(50,0,0,0));

        //SEED
        Label lSeed = new Label("Choose Seed:");
        lSeed.setFont(Font.font(null, FontWeight.BOLD, 14));
        ToggleGroup tSeed = new ToggleGroup();
        RadioButton bSeed1 = new RadioButton("Carrots");
        bSeed1.setToggleGroup(tSeed);
        RadioButton bSeed2 = new RadioButton("Potatoes");
        bSeed2.setToggleGroup(tSeed);
        RadioButton bSeed3 = new RadioButton("Celery");
        bSeed3.setToggleGroup(tSeed);
        root.getChildren().addAll(lSeed, bSeed1, bSeed2, bSeed3);
        VBox.setMargin(lSeed, new Insets(50,0,0,0));

        //SEASON
        Label lSeason = new Label("Choose Season:");
        lSeason.setFont(Font.font(null, FontWeight.BOLD, 14));
        ToggleGroup tSeason = new ToggleGroup();
        RadioButton bSeason1 = new RadioButton("Spring");
        bSeason1.setToggleGroup(tSeason);
        RadioButton bSeason2 = new RadioButton("Summer");
        bSeason2.setToggleGroup(tSeason);
        RadioButton bSeason3 = new RadioButton("Fall");
        bSeason3.setToggleGroup(tSeason);
        RadioButton bSeason4 = new RadioButton("Winter");
        bSeason4.setToggleGroup(tSeason);
        root.getChildren().addAll(lSeason, bSeason1, bSeason2, bSeason3, bSeason4);
        VBox.setMargin(lSeason, new Insets(50,0,0,0));

        //CONTINUE
        Button start = new Button("Start Game");
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { // TODO @Harrison please also check for unselected options
                if (tfName.getText().trim().equals("")) {  // empty, blank (?), or null
                    System.out.println("Handle invalid name");
                    EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
                        }
                    });
                } else {
                    manager.getStateGame().settings.initialized = true;
                    manager.getStateGame().settings.name = tfName.getText();
                    manager.getStateGame().settings.difficulty = 0; // TODO @Harrison please set the setting appropriatley using enums
                    manager.getStateGame().settings.season = 0; // TODO @Harrison
                    manager.getStateGame().settings.seed = 0; // TODO @Harrison

                    if (manager.getStateGame().settings.difficulty == 0) {
                        manager.getStateGame().inventory.money = 999;
                    } else {
                        manager.getStateGame().inventory.money = 100;
                    }

                    manager.startGame();


                }
            }
        });
        root.getChildren().add(start);
        VBox.setMargin(start, new Insets(50,0,0,0));
    }

}
