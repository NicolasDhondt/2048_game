package g54170.atl.p2048.model;

/**
 * The position class
 *
 * @author Nicolas, g54170
 */
public class Position {

    private final int row;
    private final int col;

    /**
     * Constructor of a position
     *
     * @param row a given integer
     * @param col a given integer
     */
    public Position(int row, int col) { //public because I need in the View
        this.row = row;
        this.col = col;
    }

    /**
     * gets the row
     *
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * gets the col
     *
     * @return the col
     */
    public int getCol() {
        return col;
    }

    /**
     * Gives the next position in a given direction
     *
     * @param direction a given direction
     * @return the next position
     */
    Position next(Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException("Direction can not be NULL !");
        }
        return new Position(this.row + direction.getDeltaRow(),
                this.col + direction.getDeltaCol());
    }

    /**
     * Gives the next position in the opposite of a given direction
     *
     * @param direction a given direction
     * @return the next opposite position
     */
    Position nextOpposite(Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException("Direction can not be NULL !");
        }
        direction = direction.getOppositeDirection(direction);
        return new Position(this.row + direction.getDeltaRow(),
                this.col + direction.getDeltaCol());
    }
}
