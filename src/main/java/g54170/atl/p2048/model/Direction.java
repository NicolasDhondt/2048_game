package g54170.atl.p2048.model;

/**
 * enum of direction
 *
 * @author Nicolas, g54170
 */
public enum Direction {

    NORTH(-1, 0), EAST(0, 1), SOUTH(1, 0), WEST(0, -1);

    private final int deltaRow;
    private final int deltaCol;

    Direction(int deltaRow, int deltaCol) {
        this.deltaRow = deltaRow;
        this.deltaCol = deltaCol;
    }

    /**
     * gets the deltaRow of a direction
     *
     * @return the deltaRow
     */
    int getDeltaRow() {
        return deltaRow;
    }

    /**
     * gets the deltaCol of a direction
     *
     * @return the deltaCol
     */
    int getDeltaCol() {
        return deltaCol;
    }

    /**
     * gets the opposite direction of a given direction
     *
     * @param direction the given direction
     * @return the opposite direction
     */
    Direction getOppositeDirection(Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException("Direction can not be NULL !");
        }
        switch (direction) {
            case NORTH:
                direction = SOUTH;
                break;
            case SOUTH:
                direction = NORTH;
                break;
            case WEST:
                direction = EAST;
                break;
            case EAST:
                direction = WEST;
                break;
            default:
                return null; //never
        }
        return direction;
    }

}
