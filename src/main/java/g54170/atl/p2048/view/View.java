package g54170.atl.p2048.view;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The main view of the 2048 application
 *
 * @author Nicolas, g54170
 */
public class View {

    /**
     * changes the stage by adding title and color
     *
     * @param primaryStage the stage
     * @param root the root
     */
    void changeStage(Stage primaryStage, VBox root) {
        addStageTitle(primaryStage);
        coloredRoot(root);
    }

    /**
     * adds a title to the application
     *
     * @param primaryStage the stage
     */
    private void addStageTitle(Stage primaryStage) {
        primaryStage.setTitle("Welcome to the 2048 game!");
    }

    /**
     * colors the root
     *
     * @param root the root
     */
    private void coloredRoot(VBox root) {
        root.setStyle("-fx-background-color: LIGHTSTEELBLUE;");
    }

}
