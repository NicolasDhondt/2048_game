package g54170.atl.p2048.view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * The menu of the application
 *
 * @author Nicolas, g54170
 */
public class MenuApp {

    private final MenuBar menuBar;
    private final Menu menuFile;
    private final MenuItem exitItem;

    /**
     * Constructor of the menu bar
     */
    MenuApp() {
        menuBar = new MenuBar();
        menuFile = new Menu("File");
        exitItem = new MenuItem("Exit");
        exitItem.setOnAction(actionEvent -> {
            System.exit(0);
        });
        this.addToMenuBar();
    }

    /**
     * gets the menu bar
     *
     * @return the menu bar
     */
    MenuBar getMenuBar() {
        return menuBar;
    }

    /**
     * gets the exit item of the menu file in the menu bar
     *
     * @return the exit item
     */
    MenuItem getExitItem() {
        return exitItem;
    }

    /**
     * adds elements to the menu bar
     */
    private void addToMenuBar() {
        menuBar.setStyle("-fx-background-color: ALICEBLUE;");
        menuFile.getItems().add(exitItem);
        menuBar.getMenus().add(menuFile);
    }

}
