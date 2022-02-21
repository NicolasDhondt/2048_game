package g54170.atl.p2048.logger;

import g54170.atl.p2048.model.Game;
import g54170.atl.p2048.model.Position;
import g54170.atl.p2048.util.Observer;

/**
 * Logger of a game
 *
 * @author Nicolas, g54170
 */
public class Logger implements Observer {

    private final Game game;

    /**
     * Constructor of a logger with a given game
     *
     * @param game the game
     */
    public Logger(Game game) {
        this.game = game;
        this.game.register(this);
    }

    /**
     * Update when a changement appear and prints the board in the console
     */
    @Override
    public void update() {
        for (int i = 0; i < game.getBoard().getSIDE(); i++) {
            for (int j = 0; j < game.getBoard().getSIDE(); j++) {
                if (game.getBoard().getToken(new Position(i, j)) != null) {
                    System.out.print("    "
                            + game.getBoard().getToken(new Position(i, j)).getValue());
                } else {
                    System.out.print("    " + 0);
                }
            }
            System.out.println();
        }
        System.out.println("The score : " + game.getBoard().getScore());
        System.out.println("You can move with the arrow from the keyboard !");
        System.out.println("next step!");
    }
}
