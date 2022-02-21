package g54170.atl.p2048.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test of class Game
 *
 * @author Nicolas, g54170
 */
public class GameTest {

    /**
     * Test of isWon method, true version, of class Game.
     */
    @Test
    public void testIsWonTrueV() {
        Game game = new Game();
        Token[][] tokens = {
            {new Token(2048), null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };
        Board board = new Board(tokens);
        game.setBoard(board);
        boolean expResult = true;
        boolean result = game.isWon();
        assertEquals(expResult, result);
    }

    /**
     * Test of isWon method, false version, of class Game.
     */
    @Test
    public void testIsWonFalseV() {
        Game game = new Game();
        boolean expResult = false;
        boolean result = game.isWon();
        assertEquals(expResult, result);
    }

    /**
     * Test of isLose method, of the isACaseEmpty method, of class Game.
     */
    @Test
    public void testIsLose() {
        Game game = new Game();
        Token[][] tokens = {
            {new Token(2), new Token(4), new Token(8), new Token(2)},
            {new Token(4), new Token(8), new Token(2), new Token(4)},
            {new Token(8), new Token(2), new Token(4), new Token(8)},
            {new Token(2), new Token(4), new Token(8), new Token(2)}
        };
        Board board = new Board(tokens);
        game.setBoard(board);
        boolean expResult = true;
        boolean result = game.isLose();
        assertEquals(expResult, result);
    }

    /**
     * Test of isPossibleToMove method, possible to move, of class Game.
     */
    @Test
    public void isPossibleToMove() {
        Game game = new Game();
        Token[][] tokens = {
            {new Token(4), null, null, new Token(8)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };
        Board board = new Board(tokens);
        game.setBoard(board);
        game.Play(Direction.EAST);
        boolean contain2 = false;
        for (int i = 0; i < game.getBoard().getSIDE(); i++) {
            for (int j = 0; j < game.getBoard().getSIDE(); j++) {
                if (board.getToken(new Position(i, j)) != null
                        && (board.getToken(new Position(i, j)).getValue() == 2
                        || board.getToken(new Position(i, j)).getValue() == 4));
                {
                    contain2 = true;
                    break;
                }
            }
        }
        boolean expResult = true;
        boolean result = game.getBoard().getToken(new Position(0, 3)).getValue() == 8
                && game.getBoard().getToken(new Position(0, 2)).getValue() == 4
                && contain2;
        assertEquals(expResult, result);
    }

    /**
     * Test of isPossibleToMove method, not possible to move, of class Game.
     */
    @Test
    public void isNotPossibleToMove() {
        Game game = new Game();
        Token[][] tokens = {
            {new Token(4), null, null, new Token(8)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };
        Board board = new Board(tokens);
        game.setBoard(board);
        game.Play(Direction.NORTH);
        boolean contain2 = false;
        for (int i = 0; i < game.getBoard().getSIDE(); i++) {
            for (int j = 0; j < game.getBoard().getSIDE(); j++) {
                if (board.getToken(new Position(i, j)) != null
                        && (board.getToken(new Position(i, j)).getValue() == 2
                        || board.getToken(new Position(i, j)).getValue() == 4));
                {
                    contain2 = true;
                    break;
                }
            }
        }
        boolean expResult = false;
        boolean result = game.getBoard().getToken(new Position(0, 0)).getValue() == 4
                && game.getBoard().getToken(new Position(0, 3)).getValue() == 8
                && !contain2;
        assertEquals(expResult, result);
    }

    /**
     * Test of Play method, of class Game.
     */
    @Test
    public void testPlay() {
        Game game = new Game();
        Token[][] tokens = {
            {new Token(16), null, null, new Token(16)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };
        Board board = new Board(tokens);
        game.setBoard(board);
        game.Play(Direction.EAST);
        boolean contain2 = false;
        boolean contain32 = false;

        for (int i = 0; i < game.getBoard().getSIDE(); i++) {
            for (int j = 0; j < game.getBoard().getSIDE(); j++) {
                if (board.getToken(new Position(i, j)) != null
                        && (board.getToken(new Position(i, j)).getValue() == 2
                        || board.getToken(new Position(i, j)).getValue() == 4)) {
                    contain2 = true;
                }
                if (board.getToken(new Position(i, j)) != null
                        && (board.getToken(new Position(i, j)).getValue() == 32)) {
                    contain32 = true;
                }
            }
        }

        boolean expResult = true;
        boolean result = contain2 && contain32;
        assertEquals(expResult, result);
    }
}
