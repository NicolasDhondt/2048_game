package g54170.atl.p2048.model;

/**
 * The interface of my Model, 2048 Game
 *
 * @author Nicolas, g54170
 */
public interface Model {

    /**
     * gets the board
     *
     * @return the board
     */
    public Board getBoard();

    /**
     * Plays the 2048 game, move all numbers and add a number each turn.
     * Impossible to move if each positions not change and no merge are
     * possible.
     *
     * @param direction a given direction
     */
    public void Play(Direction direction);

    /**
     * checks if a cell equals 2048, if it is : it's won
     *
     * @return true if it's won, false otherwise
     */
    public boolean isWon();

    /**
     * checks if the game is lose
     *
     * @return true if the game is lost, false otherwise
     */
    public boolean isLose();

}
