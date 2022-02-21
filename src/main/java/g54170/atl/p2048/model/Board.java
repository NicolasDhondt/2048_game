package g54170.atl.p2048.model;

/**
 * The board of the application 2048
 *
 * @author Nicolas, g54170
 */
public class Board {

    private final Token[][] gameBoard;
    private final static int SIDE = 4;
    private int score;
    // -> not the max on the board, the sum of the cases fusionned, up gradually

    /**
     * Constructor of the board 2048
     *
     * @param nbRow the given number of rows
     * @param nbCol the given number of rows
     */
    Board() {
        this.gameBoard = new Token[SIDE][SIDE];
        initBoard();
    }

    /**
     * Constructor of a Board USED ONLY IN TESTS
     *
     * @param tokens a given array of tokens
     */
    Board(Token[][] tokens) {
        gameBoard = tokens;
    }

    /**
     * gets the current score
     *
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * gets the const side
     *
     * @return the side
     */
    public int getSIDE() {
        return SIDE;
    }

    /**
     * gets a token at a given Position
     *
     * @param position a given Position
     * @return the token
     */
    public Token getToken(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Position can not be NULL !");
        }
        return gameBoard[position.getRow()][position.getCol()];
    }

    /**
     * restarts the game board.
     */
    public void restartBoard() {
        score = 0;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameBoard[i][j] != null) {
                    gameBoard[i][j].resetValue();
                }
            }
        }
        addAtRandomPlace();
    }

    /**
     * initializes a new Board and place the first number
     */
    private void initBoard() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                gameBoard[i][j] = null;
            }
        }
        addAtRandomPlace();
    }

    /**
     * checks if a cell is empty
     *
     * @param position a given Position
     * @return true if the cell is empty, false otherwise
     */
    boolean isCaseEmpty(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Direction can not be NULL !");
        }
        return gameBoard[position.getRow()][position.getCol()] == null
                || gameBoard[position.getRow()][position.getCol()].getValue()
                == 0;
    }

    /**
     * checks if a given position is inside of board
     *
     * @param position a given position
     * @return true if it is, false otherwise
     */
    boolean isInside(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Position can not be NULL !");
        }
        return position.getRow() >= 0
                && position.getCol() >= 0
                && position.getRow() < SIDE
                && position.getCol() < SIDE;
    }

    /**
     * adds the number 2 or 4 at a random place
     */
    void addAtRandomPlace() {
        int freeSpace = 0;
        int nbFreeSpace = 1 + (int) (Math.random() * countNbFreeSpace());
        int random = (int) (Math.random() * 10);
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameBoard[i][j] == null
                        || gameBoard[i][j].getValue() == 0) {
                    ++freeSpace;
                    if (nbFreeSpace == freeSpace) {
                        if (random <= 7) {
                            gameBoard[i][j] = new Token(2);
                        } else {
                            gameBoard[i][j] = new Token(4);
                        }
                    }
                }
            }
        }
    }

    /**
     * counts the number of free spaces
     *
     * @return the number of free spaces
     */
    private int countNbFreeSpace() {
        int freeSpace = 0;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameBoard[i][j] == null
                        || gameBoard[i][j].getValue() == 0) {
                    ++freeSpace;
                }
            }
        }
        return freeSpace;
    }

    /**
     * moves all numbers to a given direction
     */
    void moveNumbers(Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException("Direction can not be null!");
        }
        if (direction == Direction.NORTH || direction == Direction.WEST) {
            for (int i = 0; i < SIDE; i++) {
                for (int j = 0; j < SIDE; j++) {
                    move(direction, new Position(i, j));
                }
            }
        }
        if (direction == Direction.SOUTH || direction == Direction.EAST) {
            for (int i = SIDE - 1; i >= 0; i--) {
                for (int j = SIDE - 1; j >= 0; j--) {
                    move(direction, new Position(i, j));
                }
            }
        }
    }

    /**
     * moves a number in another Token of the board or not
     *
     * @param direction a given direction
     * @param currentPos a given position
     */
    private void move(Direction direction, Position currentPos) {
        if (direction == null || currentPos == null) {
            throw new IllegalArgumentException("Direction and position can not "
                    + "be NULL !");
        }
        if (!isCaseEmpty(currentPos)) {
            int val = gameBoard[currentPos.getRow()][currentPos.getCol()].getValue();
            gameBoard[currentPos.getRow()][currentPos.getCol()].resetValue();
            while (isInside(currentPos.next(direction))
                    && isCaseEmpty(currentPos.next(direction))) {
                currentPos = currentPos.next(direction);
            }
            gameBoard[currentPos.getRow()][currentPos.getCol()] = new Token(val);
        }
    }

    /**
     * merges all numbers to a given direction
     */
    void mergeNumbers(Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException("Direction can not be null!");
        }
        if (direction == Direction.NORTH || direction == Direction.WEST) {
            for (int i = 0; i < SIDE; i++) {
                for (int j = 0; j < SIDE; j++) {
                    merge(direction, new Position(i, j));
                }
            }
        }
        if (direction == Direction.SOUTH || direction == Direction.EAST) {
            for (int i = SIDE - 1; i >= 0; i--) {
                for (int j = SIDE - 1; j >= 0; j--) {
                    merge(direction, new Position(i, j));
                }
            }
        }
    }

    /**
     * Merges a number at a given direction and update the score if merge is
     * possible
     *
     * @param direction a given direction
     * @param currentPos a given position
     */
    private void merge(Direction direction, Position currentPos) {
        if (direction == null || currentPos == null) {
            throw new IllegalArgumentException("Direction and position can not "
                    + "be NULL !");
        }
        if (isInside(currentPos)
                && isInside(currentPos.next(direction))
                && !isCaseEmpty(currentPos)
                && !isCaseEmpty(currentPos.next(direction))
                && (gameBoard[currentPos.getRow()][currentPos.getCol()].getValue()
                == gameBoard[currentPos.next(direction).getRow()][currentPos.next(direction).getCol()]
                        .getValue())) {
            //merge numbers in the case the most in the given direction
            gameBoard[currentPos.next(direction).getRow()][currentPos.next(direction).getCol()]
                    .mergeToken(gameBoard[currentPos.getRow()][currentPos.getCol()]
                    );
            //reset the value
            gameBoard[currentPos.getRow()][currentPos.getCol()].resetValue();
            score += gameBoard[currentPos.next(direction).getRow()][currentPos.next(direction).getCol()]
                    .getValue();
            //refactor the board
            refactorAfterMerge(direction, currentPos);
        }
    }

    /**
     * refactors the board after merge some Tokens
     *
     * @param direction a given direction
     * @param currentPos a given position
     */
    private void refactorAfterMerge(Direction direction, Position currentPos) {
        if (direction == null || currentPos == null) {
            throw new IllegalArgumentException("Direction and position can not "
                    + "be NULL !");
        }
        if (isCaseEmpty(currentPos)) { //because of merge 
            while (isInside(currentPos)
                    && isInside(currentPos.nextOpposite(direction))
                    && isCaseEmpty(currentPos)
                    && !isCaseEmpty(currentPos.nextOpposite(direction))) {
                int val = gameBoard[currentPos.nextOpposite(direction).getRow()][currentPos.nextOpposite(direction).getCol()].getValue();
                gameBoard[currentPos.nextOpposite(direction).getRow()][currentPos.nextOpposite(direction).getCol()].resetValue();
                gameBoard[currentPos.getRow()][currentPos.getCol()] = new Token(val);
                currentPos = currentPos.nextOpposite(direction);
            }
        }
    }
}
