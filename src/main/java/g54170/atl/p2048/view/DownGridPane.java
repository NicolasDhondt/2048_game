package g54170.atl.p2048.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 * the down GridPane
 *
 * @author Nicolas, g54170
 */
public class DownGridPane extends GridPane {

    private Label scoreLab;

    /**
     * Constructor of the down GridPane
     */
    DownGridPane() {
        this.setPadding(new Insets(20));
        this.setHgap(260);
        scoreLab = new Label();
        this.addScore();
    }

    /**
     * adds a button to restart the game
     *
     * @return the button
     */
    Button addButton() {
        Button restartButton = new Button("CLICK TO RESTART");
        restartButton.setPrefHeight(80);
        restartButton.setPrefWidth(400);
        restartButton.setStyle("-fx-background-color: ALICEBLUE;");
        Font font = new Font("Arial", 20);
        restartButton.setFont(font);
        this.add(restartButton, 0, 0);
        return restartButton;
    }

    /**
     * adds a score in the view
     *
     * @param score the score of the game
     */
    private void addScore() {
        scoreLab = new Label();
        scoreLab.setText("THE SCORE : " + 0);
        Font font = new Font("Arial", 20);
        scoreLab.setFont(font);
        this.add(scoreLab, 1, 0);
    }

    /**
     * updates the score of the view
     */
    void updateScore(int score) {
        scoreLab.setText("THE SCORE : " + score);
    }
}
