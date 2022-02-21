package g54170.atl.p2048.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test of class Position
 *
 * @author Nicolas, g54170
 */
public class PositionTest {

    /**
     * Test of getRow method, of class Position.
     */
    @Test
    public void testGetRow() {
        Position pos = new Position(1, 0);
        boolean result = pos.getRow() == 1;
        boolean expResult = true;
        assertEquals(result, expResult);
    }

    /**
     * Test of getCol method, of class Position.
     */
    @Test
    public void testGetCol() {
        Position pos = new Position(1, 0);
        boolean result = pos.getCol() == 0;
        boolean expResult = true;
        assertEquals(result, expResult);
    }

    /**
     * Test of next method, of class Position.
     */
    @Test
    public void testNext() {
        Position pos = new Position(1, 0);
        pos = pos.next(Direction.NORTH);
        boolean result = pos.getRow() == 0;
        boolean expResult = true;
        assertEquals(result, expResult);
    }

    /**
     * Test of nextOpposite method, of class Position.
     */
    @Test
    public void testNextOpposite() {
        Position pos = new Position(1, 0);
        pos = pos.nextOpposite(Direction.NORTH);
        boolean result = pos.getRow() == 2 && pos.getCol() == 0;
        boolean expResult = true;
        assertEquals(result, expResult);
    }

}
