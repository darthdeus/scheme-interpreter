import sexp.*;

import java.util.ArrayList;
import java.util.List;

public class SExpressionParser {
    public SExpression parse(TokenStream tokens) throws ParseError {
        // List or a lambda
        if (tokens.peekLeft()) {
            tokens.consume();

            SExpression result;
            if (tokens.peekSymbol("lambda")) {
                result = parseLambda(tokens);
            } else {
                result = parseList(tokens);
            }

            if (tokens.peekRight()) {
                tokens.consume();

                return result;
            } else {
                throw new ParseError("Ocekavana koncova zavorka");
            }
        } else if (tokens.peekType(TokenType.NUMBER)) {
            int value = tokens.number();

            return new SNumber(value);
        } else if (tokens.peekType(TokenType.SYMBOL)) {
            String value = tokens.string();

            return new SAtom(value);
        } else {
            throw new ParseError(String.format("Neocekavany token %s", tokens.peek().toString()));
        }
    }

    private SList parseList(TokenStream tokens) throws ParseError {
        List<SExpression> exps = new ArrayList<>();

        while (!tokens.peekRight()) {
            exps.add(parse(tokens));
        }

        return new SList(exps);
    }

    private SLambda parseLambda(TokenStream tokens) throws ParseError {
        SList parameters = parseList(tokens);
        SExpression body = parse(tokens);

        return new SLambda(parameters.getExpressions(), body);
    }
}
