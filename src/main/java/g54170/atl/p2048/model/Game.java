package g54170.atl.p2048.model;

import g54170.atl.p2048.util.Subject;

/**
 * The current game of the 2048 application
 *
 * @author Nicolas, g54170
 */
public class Game extends Subject implements Model {

    private Board board;
    private static final int MAXVALUE = 2048;

    /**
     * Constructor of the 2048 game
     */
    public Game() {
        this.board = new Board();
    }

    /**
     * gets the board of the game
     *
     * @return the board
     */
    @Override
    public Board getBoard() { //called in View and Test
        return board;
    }

    /**
     * sets the board USED ONLY IN TESTS
     *
     * @param board the new board
     */
    void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Plays the 2048 game, move all numbers and add a number each turn.
     * Impossible to move if each positions not change and no merge are
     * possible.
     *
     * @param direction a given direction
     */
    @Override
    public void Play(Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException("Direction can not be NULL !");
        }
        if (isPossibleToMove(direction)) {
            board.moveNumbers(direction);
            board.mergeNumbers(direction);
            if (isACellEmpty()) {
                board.addAtRandomPlace();
            }
            notifyObservers();
        }
    }

    /**
     * checks if a cell equals 2048, if it is, it's won
     *
     * @return true if it's won, false otherwise
     */
    @Override
    public boolean isWon() {
        for (int i = 0; i < board.getSIDE(); i++) {
            for (int j = 0; j < board.getSIDE(); j++) {
                if (board.getToken(new Position(i, j)) != null
                        && board.getToken(new Position(i, j)).getValue() == MAXVALUE) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * checks if the game is lose
     *
     * @return true if the game is lost, false otherwise
     */
    @Override
    public boolean isLose() {
        return !isPossibleToFuseFast() && !isACellEmpty();
    }

    /**
     * checks if a fuse move is possible fast (around a single case)
     *
     * @return true if it's, false otherwhse
     */
    private boolean isPossibleToFuseFast() {
        for (int i = 0; i < board.getSIDE(); i++) {
            for (int j = 0; j < board.getSIDE(); j++) {
                if (((i + 1 < board.getSIDE()
                        && (board.isInside(new Position(i, j))
                        && board.getToken(new Position(i, j)) != null
                        && board.getToken(new Position(i + 1, j)) != null)
                        && board.getToken(new Position(i, j)).getValue()
                        == board.getToken(new Position(i + 1, j)).getValue()) //south
                        || (i - 1 >= 0
                        && (board.isInside(new Position(i, j))
                        && board.getToken(new Position(i, j)) != null
                        && board.getToken(new Position(i - 1, j)) != null)
                        && board.getToken(new Position(i, j)).getValue()
                        == board.getToken(new Position(i - 1, j)).getValue()) //north
                        || (j + 1 < board.getSIDE()
                        && (board.isInside(new Position(i, j))
                        && board.getToken(new Position(i, j)) != null
                        && board.getToken(new Position(i, j + 1)) != null)
                        && board.getToken(new Position(i, j)).getValue()
                        == board.getToken(new Position(i, j + 1)).getValue()) //east
                        || (j - 1 >= 0
                        && (board.isInside(new Position(i, j))
                        && board.getToken(new Position(i, j)) != null
                        && board.getToken(new Position(i, j - 1)) != null)
                        && board.getToken(new Position(i, j)).getValue()
                        == board.getToken(new Position(i, j - 1)).getValue()) //west
                        )) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * checks if a cell is empty
     *
     * @return true if it's, false otherwise
     */
    private boolean isACellEmpty() {
        for (int i = 0; i < board.getSIDE(); i++) {
            for (int j = 0; j < board.getSIDE(); j++) {
                if (board.isCaseEmpty(new Position(i, j))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * checks if a move is possible to change the board
     *
     * @param direction a given direction
     * @return true if a move is possible by the direction, false otherwise
     */
    private boolean isPossibleToMove(Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException("Direction can not be NULL !");
        }
        for (int i = 0; i < board.getSIDE(); i++) {
            for (int j = 0; j < board.getSIDE(); j++) {
                if (!board.isCaseEmpty(new Position(i, j))) {
                    if ((board.isInside(new Position(i, j).next(direction))
                            && board.isCaseEmpty(new Position(i, j).next(direction)))
                            || (board.isInside(new Position(i, j).next(direction))
                            && !board.isCaseEmpty(new Position(i, j).next(direction))
                            && board.getToken(new Position(i, j)).getValue()
                            == board.getToken(new Position(i, j).next(direction)).getValue())) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

}
