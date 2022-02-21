package g54170.atl.p2048.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test of Board
 *
 * @author Nicolas, g54170
 */
public class BoardTest {

    /**
     * Test of getScore method, of class Board.
     */
    @Test
    public void testGetScore() {
        Token[][] tokens = {
            {null, new Token(2), new Token(2), null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.EAST);
        board.mergeNumbers(Direction.EAST);
        int result = board.getScore();
        int expResult = 4;
        assertEquals(result, expResult);
    }

    /**
     * Test of getSIDE method, of class Board.
     */
    @Test
    public void testGetSIDE() {
        Game game = new Game();
        boolean result = game.getBoard().getSIDE() == 4;
        boolean expResult = true;
        assertEquals(result, expResult);
    }

    /**
     * Test of getToken method, of class Board.
     */
    @Test
    public void testGetToken() {
        Token[][] tokens = {
            {new Token(3), null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };
        Board board = new Board(tokens);
        int result = board.getToken(new Position(0, 0)).getValue();
        int expResult = 3;
        assertEquals(result, expResult);
    }

    /**
     * Test of isCaseEmpty method, of class Board.
     */
    @Test
    public void testIsCaseEmpty() {
        Token[][] tokens = {
            {new Token(), null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };
        Board board = new Board(tokens);
        boolean result = false;
        for (int i = 0; i < board.getSIDE(); i++) {
            for (int j = 0; j < board.getSIDE(); j++) {
                Position newPos = new Position(i, j);
                if (board.getToken(newPos) != null
                        && board.getToken(newPos).getValue() == 0) {
                    result = true;
                    break;
                }
            }
        }
        boolean expResult = true;
        assertEquals(result, expResult);
    }

    /**
     * Test of moveNumbers method, simple move to the north of class Board.
     */
    @Test
    public void testSimpleNorthMove() {
        Token[][] tokens = {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {new Token(4), null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.NORTH);
        boolean expResult = true;
        boolean result = board.getToken(new Position(0, 0)).getValue() == 4;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers method, simple move to the south, of class Board.
     */
    @Test
    public void testSimpleSouthMove() {
        Token[][] tokens = {
            {new Token(4), null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.SOUTH);
        boolean expResult = true;
        boolean result = board.getToken(new Position(3, 0)).getValue() == 4;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers method, simple move to the east, of class Board.
     */
    @Test
    public void testSimpleEastMove() { //@srv idéalement on compare le board entier au board attendu.
        Token[][] tokens = {
            {new Token(4), null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.EAST);
        boolean expResult = true;
        boolean result = board.getToken(new Position(0, 3)).getValue() == 4;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers method, simple move to the west, of class Board.
     */
    @Test
    public void testSimpleWestMove() {
        Token[][] tokens = {
            {null, null, null, new Token(4)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.WEST);
        boolean expResult = true;
        boolean result = board.getToken(new Position(0, 0)).getValue() == 4;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers method, blocked move to the north, of class Board.
     */
    @Test
    public void testNorthBlockedMove() {
        Token[][] tokens = {
            {new Token(8), null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {new Token(4), null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.NORTH);
        boolean expResult = true;
        boolean result = board.getToken(new Position(1, 0)).getValue() == 4;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers method, blocked move to the south, of class Board.
     */
    @Test
    public void testSouthBlockedMove() {
        Token[][] tokens = {
            {new Token(4), null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {new Token(8), null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.SOUTH);
        boolean expResult = true;
        boolean result = board.getToken(new Position(2, 0)).getValue() == 4;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers method, blocked move to the east, of class Board.
     */
    @Test
    public void testEastBlockedMove() {
        Token[][] tokens = {
            {new Token(4), null, null, new Token(8)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.EAST);
        boolean expResult = true;
        boolean result = board.getToken(new Position(0, 2)).getValue() == 4;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers method, blocked move to the west, of class Board.
     */
    @Test
    public void testWestBlockedMove() {
        Token[][] tokens = {
            {new Token(8), null, null, new Token(4)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.WEST);
        boolean expResult = true;
        boolean result = board.getToken(new Position(0, 1)).getValue() == 4;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers and mergeNumbers method, move to the north with a
     * simple fuse, of class Board.
     */
    @Test
    public void testNorthMoveWithSimpleLongFuse() {
        Token[][] tokens = {
            {null, null, null, null},
            {null, null, null, null},
            {new Token(4), null, null, null},
            {new Token(4), null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.NORTH);
        board.mergeNumbers(Direction.NORTH);
        boolean expResult = true;
        boolean result = board.getToken(new Position(0, 0)).getValue() == 8;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers and mergeNumbers method, move to the south with a
     * simple fuse, of class Board.
     */
    @Test
    public void testSouthMoveWithSimpleLongFuse() {
        Token[][] tokens = {
            {new Token(4), null, null, null},
            {new Token(4), null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.SOUTH);
        board.mergeNumbers(Direction.SOUTH);
        boolean expResult = true;
        boolean result = board.getToken(new Position(3, 0)).getValue() == 8;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers and mergeNumbers method, move to the east with a
     * simple fuse, of class Board.
     */
    @Test
    public void testEastMoveWithSimpleLongFuse() {
        Token[][] tokens = {
            {new Token(4), new Token(4), null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.EAST);
        board.mergeNumbers(Direction.EAST);
        boolean expResult = true;
        boolean result = board.getToken(new Position(0, 3)).getValue() == 8;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers and mergeNumbers method, move to the west with a
     * simple fuse, of class Board.
     */
    @Test
    public void testWestMoveWithSimpleLongFuse() {
        Token[][] tokens = {
            {null, null, new Token(4), new Token(4)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.WEST);
        board.mergeNumbers(Direction.WEST);
        boolean expResult = true;
        boolean result = board.getToken(new Position(0, 0)).getValue() == 8;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers and mergeNumbers method, move to the north with a
     * double fuse, of class Board.
     */
    @Test
    public void testNorthMoveWithDoubleFuse() {
        Token[][] tokens = {
            {new Token(4), null, null, null},
            {new Token(4), null, null, null},
            {new Token(4), null, null, null},
            {new Token(4), null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.NORTH);
        board.mergeNumbers(Direction.NORTH);
        boolean expResult = true;
        boolean result = board.getToken(new Position(0, 0)).getValue() == 8
                && board.getToken(new Position(1, 0)).getValue() == 8;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers and mergeNumbers method, move to the south with a
     * double fuse, of class Board.
     */
    @Test
    public void testSouthMoveWithDoubleFuse() {
        Token[][] tokens = {
            {new Token(4), null, null, null},
            {new Token(4), null, null, null},
            {new Token(4), null, null, null},
            {new Token(4), null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.SOUTH);
        board.mergeNumbers(Direction.SOUTH);
        boolean expResult = true;
        boolean result = board.getToken(new Position(3, 0)).getValue() == 8
                && board.getToken(new Position(2, 0)).getValue() == 8;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers and mergeNumbers method, move to the east with a
     * double fuse, of class Board.
     */
    @Test
    public void testEastMoveWithDoubleFuse() {
        Token[][] tokens = {
            {new Token(4), new Token(4), new Token(4), new Token(4)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.EAST);
        board.mergeNumbers(Direction.EAST);
        boolean expResult = true;
        boolean result = board.getToken(new Position(0, 3)).getValue() == 8
                && board.getToken(new Position(0, 2)).getValue() == 8;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers and mergeNumbers method, move to the west with a
     * double fuse, of class Board.
     */
    @Test
    public void testWestMoveWithDoubleFuse() {
        Token[][] tokens = {
            {new Token(4), new Token(4), new Token(4), new Token(4)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.WEST);
        board.mergeNumbers(Direction.WEST);
        boolean expResult = true;
        boolean result = board.getToken(new Position(0, 0)).getValue() == 8
                && board.getToken(new Position(0, 1)).getValue() == 8;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers and mergeNumbers method, move to the north with a
     * faint fuse, of class Board.
     */
    @Test
    public void testNorthMoveWithFaintFuse() {
        Token[][] tokens = {
            {new Token(), null, null, null},
            {new Token(2), null, null, null},
            {new Token(2), null, null, null},
            {new Token(4), null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.NORTH);
        board.mergeNumbers(Direction.NORTH);
        boolean expResult = true;
        boolean result = board.getToken(new Position(0, 0)).getValue() == 4
                && board.getToken(new Position(1, 0)).getValue() == 4;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers and mergeNumbers method, move to the south with a
     * faint fuse, of class Board.
     */
    @Test
    public void testSouthMoveWithFaintFuse() {
        Token[][] tokens = {
            {new Token(4), null, null, null},
            {new Token(2), null, null, null},
            {new Token(2), null, null, null},
            {null, null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.SOUTH);
        board.mergeNumbers(Direction.SOUTH);
        boolean expResult = true;
        boolean result = board.getToken(new Position(3, 0)).getValue() == 4
                && board.getToken(new Position(2, 0)).getValue() == 4;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers and mergeNumbers method, move to the east with a
     * faint fuse, of class Board.
     */
    @Test
    public void testEastMoveWithFaintFuse() {
        Token[][] tokens = {
            {new Token(4), new Token(2), new Token(2), new Token()},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.EAST);
        board.mergeNumbers(Direction.EAST);
        boolean expResult = true;
        boolean result = board.getToken(new Position(0, 3)).getValue() == 4
                && board.getToken(new Position(0, 2)).getValue() == 4;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers and mergeNumbers method, move to the west with a
     * faint fuse, of class Board.
     */
    @Test
    public void testWestMoveWithFaintFuse() {
        Token[][] tokens = {
            {new Token(), new Token(2), new Token(2), new Token(4)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.WEST);
        board.mergeNumbers(Direction.WEST);
        boolean expResult = true;
        boolean result = board.getToken(new Position(0, 0)).getValue() == 4
                && board.getToken(new Position(0, 1)).getValue() == 4;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers and mergeNumbers method, move to the north with a
     * long faint fuse, of class Board.
     */
    @Test
    public void testNorthMoveWithLongFaintFuse() {
        Token[][] tokens = {
            {new Token(2), null, null, null},
            {new Token(2), null, null, null},
            {null, null, null, null},
            {new Token(4), null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.NORTH);
        board.mergeNumbers(Direction.NORTH);
        boolean expResult = true;
        boolean result = board.getToken(new Position(0, 0)).getValue() == 4
                && board.getToken(new Position(1, 0)).getValue() == 4;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers and mergeNumbers method, move to the south with a
     * long faint fuse, of class Board.
     */
    @Test
    public void testSouthMoveWithLongFaintFuse() {
        Token[][] tokens = {
            {new Token(4), null, null, null},
            {null, null, null, null},
            {new Token(2), null, null, null},
            {new Token(2), null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.SOUTH);
        board.mergeNumbers(Direction.SOUTH);
        boolean expResult = true;
        boolean result = board.getToken(new Position(3, 0)).getValue() == 4
                && board.getToken(new Position(2, 0)).getValue() == 4;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers and mergeNumbers method, move to the east with a long
     * faint fuse, of class Board.
     */
    @Test
    public void testEastMoveWithLongFaintFuse() {
        Token[][] tokens = {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {new Token(4), null, new Token(2), new Token(2)}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.EAST);
        board.mergeNumbers(Direction.EAST);
        boolean expResult = true;
        boolean result = board.getToken(new Position(3, 3)).getValue() == 4
                && board.getToken(new Position(3, 2)).getValue() == 4;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers and mergeNumbers method, move to the west with a long
     * faint fuse, of class Board.
     */
    @Test
    public void testWestMoveWithLongFaintFuse() {
        Token[][] tokens = {
            {new Token(2), new Token(2), null, new Token(4)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.WEST);
        board.mergeNumbers(Direction.WEST);
        boolean expResult = true;
        boolean result = board.getToken(new Position(0, 0)).getValue() == 4
                && board.getToken(new Position(0, 1)).getValue() == 4;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers and mergeNumbers method, blocked move to the north
     * with a fuse, of class Board.
     */
    @Test
    public void testNorthBlockdeMoveWithFuse() {
        Token[][] tokens = {
            {new Token(8), null, null, null},
            {new Token(), null, null, null},
            {new Token(4), null, null, null},
            {new Token(4), null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.NORTH);
        board.mergeNumbers(Direction.NORTH);
        boolean expResult = true;
        boolean result = board.getToken(new Position(0, 0)).getValue() == 8
                && board.getToken(new Position(1, 0)).getValue() == 8;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers and mergeNumbers method, blocked move to the south
     * with a fuse, of class Board.
     */
    @Test
    public void testSouthBlockedMoveWithFuse() {
        Token[][] tokens = {
            {new Token(4), null, null, null},
            {new Token(4), null, null, null},
            {new Token(), null, null, null},
            {new Token(8), null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.SOUTH);
        board.mergeNumbers(Direction.SOUTH);
        boolean expResult = true;
        boolean result = board.getToken(new Position(3, 0)).getValue() == 8
                && board.getToken(new Position(2, 0)).getValue() == 8;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers and mergeNumbers method, blocked move to the east
     * with a fuse, of class Board.
     */
    @Test
    public void testEastBlockedMoveWithFuse() {
        Token[][] tokens = {
            {new Token(4), new Token(4), new Token(), new Token(8)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.EAST);
        board.mergeNumbers(Direction.EAST);
        boolean expResult = true;
        boolean result = board.getToken(new Position(0, 3)).getValue() == 8
                && board.getToken(new Position(0, 2)).getValue() == 8;
        assertEquals(expResult, result);
    }

    /**
     * Test of moveNumbers and mergeNumbers method, blocked move to the west
     * with a fuse, of class Board.
     */
    @Test
    public void testWestBlockedMoveWithFuse() {
        Token[][] tokens = {
            {new Token(8), new Token(), new Token(4), new Token(4)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };
        Board board = new Board(tokens);
        board.moveNumbers(Direction.WEST);
        board.mergeNumbers(Direction.WEST);
        boolean expResult = true;
        boolean result = board.getToken(new Position(0, 0)).getValue() == 8
                && board.getToken(new Position(0, 1)).getValue() == 8;
        assertEquals(expResult, result);
    }

    /**
     * Test of restartBoard method, of class Board.
     */
    @Test
    public void testRestartBoard() {
        Token[][] tokens = {
            {new Token(16), null, null, new Token(16)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };
        Board board = new Board(tokens);
        boolean expResult = true;
        boolean result = false;
        board.restartBoard();
        for (int i = 0; i < board.getSIDE(); i++) {
            for (int j = 0; j < board.getSIDE(); j++) {
                if (!board.isCaseEmpty(new Position(i, j))
                        && (board.getToken(new Position(i, j)).getValue() == 2
                        || board.getToken(new Position(i, j)).getValue() == 4)) {
                    result = true;
                    break;
                }
            }
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of isInside method, true version, of class Board.
     */
    @Test
    public void testIsInsideTrueV() {
        Board board = new Board();
        boolean expResult = true;
        boolean result = board.isInside(new Position(2, 2));
        assertEquals(expResult, result);
    }

    /**
     * Test of isInside method, false version, of class Board.
     */
    @Test
    public void testIsInsideFalseV() {
        Board board = new Board();
        boolean expResult = false;
        boolean result = board.isInside(new Position(4, 4));
        assertEquals(expResult, result);
    }

    /**
     * Test of addAtRandomPlace method, of class Board.
     */
    @Test
    public void testAddAtRandomPlace() {
        Board board = new Board();
        boolean expResult = true;
        boolean result = false;
        for (int i = 0; i < board.getSIDE(); i++) {
            for (int j = 0; j < board.getSIDE(); j++) {
                if (!board.isCaseEmpty(new Position(i, j))
                        && (board.getToken(new Position(i, j)).getValue() == 2
                        || board.getToken(new Position(i, j)).getValue() == 4)) {
                    result = true;
                    break;
                }
            }
        }
        assertEquals(expResult, result);
    }

}
