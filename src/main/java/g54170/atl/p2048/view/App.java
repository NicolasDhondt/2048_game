package g54170.atl.p2048.view;

import g54170.atl.p2048.logger.Logger;
import g54170.atl.p2048.model.Direction;
import g54170.atl.p2048.model.Game;
import g54170.atl.p2048.util.Observer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Controler of the 2048 application
 *
 * @author Nicolas, g54170
 */
public class App extends Application implements Observer {

    private final Game game;
    private final View view;
    private GameBoard gameBoard;
    private GameExplanation gameExplanation;
    private UpGridPane upGrid;
    private DownGridPane downGrid;
    private MenuApp menu;
    private static final int MAXWIDTH = 1000;
    private static final int MAXHEIGHT = 750;

    /**
     * Controler of the appliction
     */
    public App() {
        game = new Game();
        view = new View();
    }

    /**
     * launchs the 2048 application, init and starts the app
     *
     * @param args an array of args
     */
    public void launchApp(String[] args) {
        launch(args);
    }

    /**
     * starts the game
     *
     * @param primaryStage the stage
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setMaxHeight(MAXHEIGHT);
        primaryStage.setMaxWidth(MAXWIDTH);
        VBox root = new VBox();
        root.setPadding(new Insets(20));
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(20));
        hbox.setSpacing(120); //space beetween GridPane
        Logger logger = new Logger(game);
        Scene scene = new Scene(root, MAXWIDTH, MAXHEIGHT);
        buildAllForFXView(root, vbox, hbox);
        view.changeStage(primaryStage, root);
        setActionsOnScene(scene);
        this.update(); //to print the board
        primaryStage.setScene(scene);
        primaryStage.show();
        game.register(this);
    }

    /**
     * sets the actions for the game and the button restart from the scene
     *
     * @param scene the given scene
     */
    private void setActionsOnScene(Scene scene) {
        Button restartButton = downGrid.addButton();
        restartButton.setOnMouseClicked(actionEvent -> {
            restartGame();
            actionEvent.consume();
        });

        scene.setOnKeyReleased(keyEvent -> {
            if (!game.isWon() && !game.isLose()) {
                Direction direction = detectKeyPressed(keyEvent);
                while (direction == null) {
                    direction = detectKeyPressed(keyEvent);
                }
                game.Play(direction);
            } else {
                gameExplanation.displayNotPossibleToContinue();
            }
        });
    }

    /**
     * detects and returns the Direction chosen by the keyBoard
     *
     * @param event the event
     * @return the direction chosen
     */
    private Direction detectKeyPressed(KeyEvent event) {
        Direction direction = null;
        if (event.getCode().toString().equals("LEFT")) {
            direction = Direction.WEST;
        }
        if (event.getCode().toString().equals("UP")) {
            direction = Direction.NORTH;
        }
        if (event.getCode().toString().equals("RIGHT")) {
            direction = Direction.EAST;
        }
        if (event.getCode().toString().equals("DOWN")) {
            direction = Direction.SOUTH;
        }
        event.consume();
        return direction;
    }

    /**
     * restarts the game
     */
    private void restartGame() {
        game.getBoard().restartBoard();
        gameExplanation.resetLabels();
        update();
    }

    /**
     * builds all elements for the fx view
     *
     * @param root the given root
     * @param vbox the given vbox
     * @param hbox the given hbox
     */
    private void buildAllForFXView(VBox root, VBox vbox, HBox hbox) {
        gameBoard = new GameBoard(game);
        gameExplanation = new GameExplanation();
        menu = new MenuApp();
        upGrid = new UpGridPane();
        downGrid = new DownGridPane();
        vbox.getChildren().add(menu.getMenuBar());
        vbox.getChildren().add(upGrid);
        hbox.getChildren().add(gameBoard);
        hbox.getChildren().add(gameExplanation);
        vbox.getChildren().add(hbox);
        vbox.getChildren().add(downGrid);
        root.getChildren().add(vbox);
    }

    /**
     * Updates boards when the board of the game changed
     */
    @Override
    public void update() {
        gameBoard.updateBoard(game);
        downGrid.updateScore(game.getBoard().getScore());
        if (game.isWon()) {
            gameExplanation.displayWinMessage();
        }
        if (game.isLose()) {
            gameExplanation.displayLoseMessage();
        }
    }
}
