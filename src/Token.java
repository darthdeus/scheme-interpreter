
public class Token {
    public String string;
    public TokenType type;
    public int intValue;
    public char value;

    public Token(char value) {
        switch (value) {
            case '(':
                type = TokenType.LEFT_PAREN;
                break;
            case ')':
                type = TokenType.RIGHT_PAREN;
                break;
            default:
                throw new IllegalArgumentException(String.format("Invalid token %c", value));
        }
        this.value = value;
    }

    public Token(int value) {
        this.type = TokenType.NUMBER;
        this.intValue = value;
    }

    public Token(String value) {
        this.type = TokenType.SYMBOL;
        this.string = value;
    }

    @Override
    public String toString() {
        if (type == TokenType.NUMBER) {
            return String.format("NUMBER(%d)", intValue);
        } else if (type == TokenType.SYMBOL) {
            return String.format("SYMBOL(%s)", string);
        } else {
            return Character.toString(value);
        }
    }
}
