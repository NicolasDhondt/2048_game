package g54170.atl.p2048.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 * The explanations of 2048 game
 *
 * @author Nicolas, g54170
 */
public class GameExplanation extends GridPane {

    private static final int SIZE_GRID = 400;
    private Label statusGame;
    private Label notPossibleToContinueLabel;

    /**
     * Constructor of the GameExplanation of the game 2048
     */
    GameExplanation() {
        this.setWidth(SIZE_GRID);
        this.setHeight(SIZE_GRID);
        this.setVgap(200);
        this.addStatusGameLabel();
        this.addNotContinueLabel();
    }

    /**
     * adds the status of the game in the app
     */
    private void addStatusGameLabel() {
        statusGame = new Label();
        statusGame.setPrefHeight(100);
        statusGame.setPrefWidth(400);
        statusGame.setAlignment(Pos.CENTER);
        statusGame.setStyle("-fx-background-color: AZURE;");
        Font font = new Font("Arial", 14);
        statusGame.setFont(font);
        statusGame.setText("Not yet won or lost!");
        this.add(statusGame, 0, 0);
    }

    /**
     * adds a message not continue possible in the app. Visibility not for the
     * moment.
     */
    private void addNotContinueLabel() {
        notPossibleToContinueLabel = new Label();
        notPossibleToContinueLabel.setText("You have already won or lost! Restart !");
        notPossibleToContinueLabel.setPrefHeight(100);
        notPossibleToContinueLabel.setPrefWidth(400);
        notPossibleToContinueLabel.setAlignment(Pos.CENTER);
        notPossibleToContinueLabel.setStyle("-fx-background-color: AZURE;");
        Font font = new Font("Arial", 14);
        notPossibleToContinueLabel.setFont(font);
        notPossibleToContinueLabel.setVisible(false);
        this.add(notPossibleToContinueLabel, 0, 1);
    }

    /**
     * displays a lose messaage in the console and in the status game
     */
    void displayLoseMessage() {
        statusGame.setText("Sorry, it's lose!");
        System.out.println("Sorry, it's lose!");
    }

    /**
     * displays a win message in the console and in the status game
     */
    void displayWinMessage() {
        statusGame.setText("Congratulation, it's win!");
        System.out.println("Congratulation, it's win!");
    }

    /**
     * displays when it's not possible to continue the game
     */
    void displayNotPossibleToContinue() {
        notPossibleToContinueLabel.setVisible(true);
        System.out.println("You have already won or lost! Restart !");
    }

    /**
     * resets the two labels
     */
    void resetLabels() {
        notPossibleToContinueLabel.setVisible(false);
        statusGame.setText("Not yet won or lost!");
    }

}
