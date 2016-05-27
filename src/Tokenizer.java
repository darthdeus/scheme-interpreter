import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Tokenizer {

    public void chyba(String msg) throws ParseError {
        throw new ParseError(msg);
    }

    public List<Token> tokenize(BufferedReader reader) throws IOException, ParseError {
        List<Token> tokens = new LinkedList<>();

        // TODO - tokenize negative numbers
        int i;
        boolean number = false;
        boolean symbol = false;
        StringBuilder builder = new StringBuilder();
        while ((i = reader.read()) != -1) {
            char c = (char) i;

            if (Character.isWhitespace(c) || c == '(' || c == ')') {
                if (builder.length() > 0) {
                    if (symbol) {
                        tokens.add(new Token(builder.toString()));
                    } else if (number) {
                        tokens.add(new Token(Integer.parseInt(builder.toString())));
                    }

                    builder = new StringBuilder();
                    symbol = false;
                    number = false;
                }

                switch  (c) {
                    case '(':
                    case ')':
                        tokens.add(new Token(c));
                        break;
                    default:
                        // Intentionally doing nothing
                }
            } else if (Character.isDigit(c)) {
                builder.append(c);
                if (!symbol) {
                    number = true;
                }
            } else {
                if (number) {
                    chyba("Cislo obsahujici symbol");
                }

                symbol = true;

                builder.append(c);
            }
        }

        if (builder.length() > 0) {
            if (symbol) {
                tokens.add(new Token(builder.toString()));
            } else {
                tokens.add(new Token(Integer.parseInt(builder.toString())));
            }
        }

        return tokens;
    }
}
