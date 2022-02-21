package g54170.atl.p2048.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 * the up GridPane
 *
 * @author Nicolas, g54170
 */
public class UpGridPane extends GridPane {

    /**
     * Constructor of the up GridPane
     */
    UpGridPane() {
        this.setPadding(new Insets(30));
        this.addMainTitle();
    }

    /**
     * adds a title in the up GridPane
     */
    private void addMainTitle() {
        Label title = new Label("Enjoy with the 2048 game !");
        title.setUnderline(true);
        Font font = new Font("Arial", 20);
        title.setFont(font);
        this.add(title, 0, 0);
        this.setAlignment(Pos.CENTER);
    }
}
