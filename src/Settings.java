import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javax.swing.*;

public class Settings extends Application {

    private String name;
    private int difficulty;
    private int seed;
    private int season;

    @Override
    public void start(Stage stage) {
        System.out.println("Started settings screen");
        VBox root = new VBox();
        root.setPadding(new Insets(10, 50, 50, 50));
        root.setId("settings");
        root.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());

        Scene scene = new Scene(root, 1280,720);
        stage.setScene(scene);

        //ERROR SCREEN
        JOptionPane errorBox = new JOptionPane();


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
        root.setMargin(title, new Insets(0,0,0,0));
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
        RadioButton bNoobDiff = new RadioButton("Noob");
        bNoobDiff.setToggleGroup(tDifficulty);
        RadioButton bNormalDiff = new RadioButton("Normal");
        bNormalDiff.setToggleGroup(tDifficulty);
        RadioButton bNSaneDiff = new RadioButton("N-Sane");
        bNSaneDiff.setToggleGroup(tDifficulty);
        root.getChildren().addAll(lDifficulty,bNoobDiff,bNormalDiff,bNSaneDiff);
        root.setMargin(lDifficulty, new Insets(50,0,0,0));

        //SEED
        Label lSeed = new Label("Choose Seed:");
        lSeed.setFont(Font.font(null, FontWeight.BOLD, 14));
        ToggleGroup tSeed = new ToggleGroup();
        RadioButton bSeed1 = new RadioButton("Andrew's");
        bSeed1.setToggleGroup(tSeed);
        RadioButton bSeed2 = new RadioButton("Andrew's Mom's");
        bSeed2.setToggleGroup(tSeed);
        RadioButton bSeed3 = new RadioButton("Andrew's Dad's Lands");
        bSeed3.setToggleGroup(tSeed);
        root.getChildren().addAll(lSeed,bSeed1,bSeed2,bSeed3);
        root.setMargin(lSeed, new Insets(50,0,0,0));

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
        root.getChildren().addAll(lSeason,bSeason1,bSeason2,bSeason3,bSeason4);
        root.setMargin(lSeason, new Insets(50,0,0,0));

        //CONTINUE
        Button start = new Button("Start Game");
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tfName.getText().trim().equals("")) {  // empty, blank (?), or null
                    System.out.println("Handle invalid name");
                    errorBox.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
                } else {
                    Game game = new Game();
                    game.start(stage);
                }
            }
        });
        root.getChildren().add(start);
        root.setMargin(start, new Insets(50,0,0,0));
    }

    //Accessors
    public String getName() {
        return name;
    }
    public int getDifficulty() {
        return difficulty;
    }
    public int getSeed() {
        return seed;
    }
    public int getSeason() {
        return season;
    }
}
