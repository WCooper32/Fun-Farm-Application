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
        root.getStylesheets().addAll(this.getClass().getResource("../css/style.css")
                .toExternalForm());

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
        VBox.setMargin(title, new Insets(0, 0, 0, 0));
        title.setPrefWidth(Double.MAX_VALUE);
        title.setAlignment(Pos.TOP_LEFT);
        root.getChildren().add(title);

        //NAME
        Label labelName = new Label("Name:");
        labelName.setFont(Font.font(null, FontWeight.BOLD, 14));
        TextField textfieldName = new TextField();
        HBox hb = new HBox();
        root.getChildren().add(hb);
        hb.getChildren().addAll(labelName, textfieldName);
        hb.setSpacing(10);

        //DIFFICULTY
        Label labelDifficulty = new Label("Choose Difficulty:");
        labelDifficulty.setFont(Font.font(null, FontWeight.BOLD, 14));
        ToggleGroup toggleDifficulty = new ToggleGroup();
        RadioButton buttonEasyDiff = new RadioButton("Easy");
        buttonEasyDiff.setToggleGroup(toggleDifficulty);
        buttonEasyDiff.setUserData(Difficulty.EASY);
        RadioButton buttonNormalDiff = new RadioButton("Medium");
        buttonNormalDiff.setToggleGroup(toggleDifficulty);
        buttonNormalDiff.setUserData(Difficulty.MEDIUM);
        RadioButton buttonHardDiff = new RadioButton("Hard");
        buttonHardDiff.setToggleGroup(toggleDifficulty);
        buttonHardDiff.setUserData(Difficulty.HARD);
        root.getChildren().addAll(labelDifficulty, buttonEasyDiff,
                buttonNormalDiff, buttonHardDiff);
        VBox.setMargin(labelDifficulty, new Insets(50, 0, 0, 0));

        //SEED
        Label labelSeed = new Label("Choose Seed:");
        labelSeed.setFont(Font.font(null, FontWeight.BOLD, 14));
        ToggleGroup toggleSeed = new ToggleGroup();
        RadioButton buttonSeed1 = new RadioButton("Carrots");
        buttonSeed1.setToggleGroup(toggleSeed);
        buttonSeed1.setUserData(Seed.CARROTS);
        RadioButton buttonSeed2 = new RadioButton("Potatoes");
        buttonSeed2.setToggleGroup(toggleSeed);
        buttonSeed2.setUserData(Seed.POTATOES);
        RadioButton buttonSeed3 = new RadioButton("Celery");
        buttonSeed3.setToggleGroup(toggleSeed);
        buttonSeed3.setUserData(Seed.CELERY);
        root.getChildren().addAll(labelSeed, buttonSeed1, buttonSeed2, buttonSeed3);
        VBox.setMargin(labelSeed, new Insets(50, 0, 0, 0));

        //SEASON
        Label lSeason = new Label("Choose Season:");
        lSeason.setFont(Font.font(null, FontWeight.BOLD, 14));
        ToggleGroup toggleSeason = new ToggleGroup();
        RadioButton buttonSeason1 = new RadioButton("Spring");
        buttonSeason1.setToggleGroup(toggleSeason);
        buttonSeason1.setUserData(Season.SPRING);
        RadioButton buttonSeason2 = new RadioButton("Summer");
        buttonSeason2.setToggleGroup(toggleSeason);
        buttonSeason2.setUserData(Season.SUMMER);
        RadioButton buttonSeason3 = new RadioButton("Fall");
        buttonSeason3.setToggleGroup(toggleSeason);
        buttonSeason3.setUserData(Season.FALL);
        RadioButton buttonSeason4 = new RadioButton("Winter");
        buttonSeason4.setToggleGroup(toggleSeason);
        buttonSeason4.setUserData(Season.WINTER);
        root.getChildren().addAll(lSeason, buttonSeason1,
                buttonSeason2, buttonSeason3, buttonSeason4);
        VBox.setMargin(lSeason, new Insets(50, 0, 0, 0));

        //CONTINUE
        Button start = new Button("Start Game");
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textfieldName.getText().trim().equals("")) {  // empty, blank (?), or null
                    System.out.println("Handle invalid name");
                    EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            JOptionPane.showMessageDialog(null, "Please enter a valid name.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });
                } else if (toggleDifficulty.getSelectedToggle() == null) {
                    System.out.println("Handle unselected difficulty");
                    EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            JOptionPane.showMessageDialog(null, "Please select a difficulty.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });
                } else if (toggleSeed.getSelectedToggle() == null) {
                    System.out.println("Handle unselected seed");
                    EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            JOptionPane.showMessageDialog(null, "Please select a seed.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });
                } else if (toggleSeason.getSelectedToggle() == null) {
                    System.out.println("Handle unselected season");
                    EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            JOptionPane.showMessageDialog(null, "Please select a season.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });
                } else {
                    buttonNormalDiff.setUserData(Difficulty.MEDIUM);
                    manager.state.settings.initialized = true;
                    manager.state.settings.name = textfieldName.getText();
                    manager.state.settings.difficulty =  ((Difficulty) toggleDifficulty.
                            getSelectedToggle().getUserData()).getValue();
                    manager.state.settings.season = ((Season) toggleSeason.
                            getSelectedToggle().getUserData()).getValue();
                    manager.state.settings.seed = ((Seed) toggleSeed.
                            getSelectedToggle().getUserData()).getValue();
                    manager.startGame();
                }
            }
        });
        root.getChildren().add(start);
        VBox.setMargin(start, new Insets(50, 0, 0, 0));
    }

    public enum Difficulty {
        EASY(1), MEDIUM(2), HARD(3);
        private int value;
        private Difficulty(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    };
    public enum Season {
        SPRING(1), SUMMER(2), FALL(3), WINTER(4);
        private int value;
        private Season(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    };
    public enum Seed {
        CARROTS(1), POTATOES(2), CELERY(3);
        private int value;
        private Seed(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    };

}
