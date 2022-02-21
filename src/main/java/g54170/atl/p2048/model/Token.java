package g54170.atl.p2048.model;

/**
 * The content of a cell of the board
 *
 * @author Nicolas, g54170
 */
public class Token {

    private int value;

    /**
     * Constructor of a Token
     */
    Token() {
        this.value = 0;
    }

    /**
     * Constructor of a Token with a given value
     *
     * @param val the given new value
     */
    Token(int val) {
        this.value = val;
    }

    /**
     * gets the value of a Token
     *
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * merges the value of a Token
     *
     * @param token the token to merge
     */
    void mergeToken(Token token) {
        if (token.getValue() < 0) {
            throw new IllegalArgumentException("The value must be positive!");
        }
        this.value = token.getValue() * 2;
    }

    /**
     * resets the value of a token
     */
    void resetValue() {
        this.value = 0;
    }

}
