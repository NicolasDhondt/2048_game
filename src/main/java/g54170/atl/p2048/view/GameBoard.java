package g54170.atl.p2048.view;

import g54170.atl.p2048.model.Game;
import g54170.atl.p2048.model.Position;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 * the main game board of 2048, the numbers
 *
 * @author Nicolas, g54170
 */
public class GameBoard extends GridPane {

    private static final int TILE_SIZE = 100;
    private final Tile[][] tiles;

    /**
     * Constructor of the GameBoard GridPane, the board of the game
     *
     * @param game the game
     */
    GameBoard(Game game) {
        tiles = new Tile[game.getBoard().getSIDE()][game.getBoard().getSIDE()];
        this.createTiles(game);
    }

    /**
     * creates the board of the game to prints
     *
     * @param game the game
     */
    private void createTiles(Game game) {
        for (int i = 0; i < game.getBoard().getSIDE(); i++) {
            for (int j = 0; j < game.getBoard().getSIDE(); j++) {
                tiles[i][j] = new Tile();
                this.add(tiles[i][j], j, i);
                //because 0 1 is in line with add fuction and not in column as
                //an array
            }
        }
    }

    /**
     * change the tiles with the right value from the board of Game Class
     *
     * @param tiles an array of titles
     * @param game the game
     */
    void updateBoard(Game game) {
        for (int i = 0; i < game.getBoard().getSIDE(); i++) {
            for (int j = 0; j < game.getBoard().getSIDE(); j++) {
                if (game.getBoard().getToken(new Position(i, j)) != null) {
                    tiles[i][j].changeTile(game.getBoard().getToken(new Position(i, j)).getValue());
                }
            }
        }
    }

    /**
     * The tiles private class
     */
    private class Tile extends Label {

        /**
         * Constructor of a Tile
         */
        private Tile() {
            this.setMinSize(TILE_SIZE, TILE_SIZE);
            this.setMaxSize(TILE_SIZE, TILE_SIZE);
            this.setPrefSize(TILE_SIZE, TILE_SIZE);
            this.setAlignment(Pos.CENTER);
            Font font = new Font("Arial", 14);
            this.setFont(font);
            this.setStyle("-fx-background-color:LAVENDER;"
                    + "-fx-background-insets:1px;-fx-border-color:CORNFLOWERBLUE;"
                    + "-fx-border-width:1px;-fx-border-insets:1px;"
                    + "-fx-border-style:solid;");
        }

        /**
         * changes the value in a tile with the new value. The color can change.
         *
         * @param val the new value
         * @return the title changed
         */
        private void changeTile(int val) {
            Integer value = val;
            this.setText(value.toString());
            if (value == 0) {
                this.setText("");
            }
            this.setStyle("-fx-background-color: " + changeColorTile(val) + ";"
                    + "-fx-background-insets:1px; -fx-border-color:CORNFLOWERBLUE;"
                    + "-fx-border-width:1px; -fx-border-insets:1px;"
                    + "-fx-border-style:solid;");
        }

        /**
         * returns the name of a color to changes the color of a tile by its
         * value
         *
         * @param val a given integer
         * @return the name of the color
         */
        private String changeColorTile(int val) {
            switch (val) {
//                case 0:
//                    return "LAVENDER";
                case 2:
                    return "LIGHTCYAN";
                case 4:
                    return "POWDERBLUE";
                case 8:
                    return "LIGHTBLUE";
                case 16:
                    return "SKYBLUE";
                case 32:
                    return "LIGHTSKYBLUE";
                case 64:
                    return "ROYALBLUE";
                case 128:
                    return "STEELBLUE";
                case 256:
                    return "LIGHTSEAGREEN";
                case 512:
                    return "DARKSEAGREEN";
                case 1024:
                    return "CADETBLUE";
                case 2048:
                    return "TEAL";
                default:
                    return "LAVENDER"; //0 also
            }
        }
    }

}
