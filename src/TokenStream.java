import java.util.List;
import java.util.Objects;

public class TokenStream {
    private List<Token> tokens;
    private int index = 0;
    public boolean inside = false;

    public TokenStream(List<Token> tokens) {
        this.tokens = tokens;
    }

    public Token peek() {
        if (tokens.size() > index) {
            return tokens.get(index);
        }
        return null;
    }

    public boolean peekType(TokenType type) {
        return tokens.size() > index && tokens.get(index).type == type;
    }

    public boolean peekSymbol(String symbol) {
        if (peekType(TokenType.SYMBOL)) {
            return Objects.equals(tokens.get(index).string, symbol);
        } else {
            return false;
        }
    }

    public boolean peekLeft() {
        return peekType(TokenType.LEFT_PAREN);
    }

    public boolean peekRight() {
        return peekType(TokenType.RIGHT_PAREN);
    }

    public Token consume() throws ParseError {
        if (index >= tokens.size()) {
            throw new ParseError(String.format("chybi token v radce %s", tokens));
        }
        return tokens.get(index++);
    }

    public int number() {
        if (peekType(TokenType.NUMBER)) {
            return tokens.get(index).intValue;
        } else {
            throw new RuntimeException(
                    String.format("Stream doesn't contain a NUMBER, instead it contains %s", tokens.get(index)));
        }
    }

    public String string() {
        if (peekType(TokenType.SYMBOL)) {
            return tokens.get(index).string;
        } else {
            throw new RuntimeException(
                    String.format("Stream doesn't contain a SYMBOL, instead it contains %s", tokens.get(index)));
        }
    }

    public int remaining() {
        return tokens.size() - index;
    }

    public boolean isEmpty() {
        return index >= tokens.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("TokenStream{ ");

        for (int i = index; i < tokens.size(); i++) {
            builder.append(tokens.get(i).toString());
            builder.append(", ");
        }

        builder.append(" }");

        return builder.toString();
    }
}
