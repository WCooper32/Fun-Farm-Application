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
import main.state.StateSettings;

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
        HBox rowName = new HBox();
        root.getChildren().add(rowName);
        rowName.getChildren().addAll(labelName, textfieldName);
        rowName.setSpacing(10);

        //DIFFICULTY
        Label labelDifficulty = new Label("Choose Difficulty:");
        labelDifficulty.setFont(Font.font(null, FontWeight.BOLD, 14));
        ToggleGroup toggleDifficulty = new ToggleGroup();
        RadioButton buttonEasyDiff = new RadioButton("Easy");
        buttonEasyDiff.setToggleGroup(toggleDifficulty);
        buttonEasyDiff.setUserData(StateSettings.Difficulty.EASY);
        RadioButton buttonNormalDiff = new RadioButton("Medium");
        buttonNormalDiff.setToggleGroup(toggleDifficulty);
        buttonNormalDiff.setUserData(StateSettings.Difficulty.MEDIUM);
        RadioButton buttonHardDiff = new RadioButton("Hard");
        buttonHardDiff.setToggleGroup(toggleDifficulty);
        buttonHardDiff.setUserData(StateSettings.Difficulty.HARD);
        root.getChildren().addAll(labelDifficulty, buttonEasyDiff,
                buttonNormalDiff, buttonHardDiff);
        VBox.setMargin(labelDifficulty, new Insets(50, 0, 0, 0));

        //SEED
        Label labelSeed = new Label("Choose Seed:");
        labelSeed.setFont(Font.font(null, FontWeight.BOLD, 14));
        ToggleGroup toggleSeed = new ToggleGroup();
        RadioButton buttonSeed1 = new RadioButton("Carrots");
        buttonSeed1.setToggleGroup(toggleSeed);
        buttonSeed1.setUserData(StateSettings.Seed.CARROTS);
        RadioButton buttonSeed2 = new RadioButton("Potatoes");
        buttonSeed2.setToggleGroup(toggleSeed);
        buttonSeed2.setUserData(StateSettings.Seed.POTATOES);
        RadioButton buttonSeed3 = new RadioButton("Celery");
        buttonSeed3.setToggleGroup(toggleSeed);
        buttonSeed3.setUserData(StateSettings.Seed.CELERY);
        root.getChildren().addAll(labelSeed, buttonSeed1, buttonSeed2, buttonSeed3);
        VBox.setMargin(labelSeed, new Insets(50, 0, 0, 0));

        //SEASON
        Label labelSeason = new Label("Choose Season:");
        labelSeason.setFont(Font.font(null, FontWeight.BOLD, 14));
        ToggleGroup toggleSeason = new ToggleGroup();
        RadioButton buttonSeason1 = new RadioButton("Spring");
        buttonSeason1.setToggleGroup(toggleSeason);
        buttonSeason1.setUserData(StateSettings.Season.SPRING);
        RadioButton buttonSeason2 = new RadioButton("Summer");
        buttonSeason2.setToggleGroup(toggleSeason);
        buttonSeason2.setUserData(StateSettings.Season.SUMMER);
        RadioButton buttonSeason3 = new RadioButton("Fall");
        buttonSeason3.setToggleGroup(toggleSeason);
        buttonSeason3.setUserData(StateSettings.Season.FALL);
        RadioButton buttonSeason4 = new RadioButton("Winter");
        buttonSeason4.setToggleGroup(toggleSeason);
        buttonSeason4.setUserData(StateSettings.Season.WINTER);
        root.getChildren().addAll(labelSeason, buttonSeason1,
                buttonSeason2, buttonSeason3, buttonSeason4);
        VBox.setMargin(labelSeason, new Insets(50, 0, 0, 0));

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
                    manager.getState().getSettings().setInitialized(true);
                    manager.getState().getSettings().setName(textfieldName.getText());
                    manager.getState().getSettings().setDifficulty(((StateSettings.Difficulty)
                            toggleDifficulty.getSelectedToggle().getUserData()).getValue());
                    manager.getState().getSettings().setSeason(((StateSettings.Season) toggleSeason.
                            getSelectedToggle().getUserData()).getValue());
                    manager.getState().getSettings().setSeed(((StateSettings.Seed) toggleSeed.
                            getSelectedToggle().getUserData()).getValue());
                    manager.startGame();
                }
            }
        });
        root.getChildren().add(start);
        VBox.setMargin(start, new Insets(50, 0, 0, 0));
    }
}
