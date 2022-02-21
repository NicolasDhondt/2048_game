package g54170.atl.p2048.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test of Direction class
 *
 * @author Nicolas, g54170
 */
public class DirectionTest {

    /**
     * Test of getDeltaRow method, of class Direction.
     */
    @Test
    public void testGetDeltaRow() {
        int row = Direction.NORTH.getDeltaRow();
        boolean result = true;
        boolean expResult = row == -1;
        assertEquals(result, expResult);
    }

    /**
     * Test of getDeltaCol method, of class Direction.
     */
    @Test
    public void testGetDeltaCol() {
        int col = Direction.NORTH.getDeltaCol();
        boolean result = true;
        boolean expResult = col == 0;
        assertEquals(result, expResult);
    }

    /**
     * Test of valueOf method, of class Direction.
     */
    @Test
    public void testValues() {
        int row = Direction.NORTH.getDeltaRow();
        int col = Direction.NORTH.getDeltaCol();
        boolean result = true;
        boolean expResult = row == -1 && col == 0;
        assertEquals(result, expResult);
    }

}
