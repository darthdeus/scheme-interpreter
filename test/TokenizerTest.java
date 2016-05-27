import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.List;

import static org.junit.Assert.*;

public class TokenizerTest {

    public BufferedReader stringStream(String str) {
        return new BufferedReader(new StringReader(str));
    }

    @Test
    public void testTokenize() throws Exception {
        List<Token> tokens = new Tokenizer().tokenize(stringStream("(+ 1 (- 3 4))"));

        assertEquals(tokens.get(0).type, TokenType.LEFT_PAREN);
        assertEquals(tokens.get(1).type, TokenType.SYMBOL);
        assertEquals(tokens.get(2).type, TokenType.NUMBER);
        assertEquals(tokens.get(3).type, TokenType.LEFT_PAREN);
        assertEquals(tokens.get(4).type, TokenType.SYMBOL);
        assertEquals(tokens.get(5).type, TokenType.NUMBER);
        assertEquals(tokens.get(6).type, TokenType.NUMBER);
        assertEquals(tokens.get(7).type, TokenType.RIGHT_PAREN);
        assertEquals(tokens.get(8).type, TokenType.RIGHT_PAREN);
    }

//    @Test
//    public void testTokenize() throws Exception {
//        List<Token> tokens = new Tokenizer().tokenize(stringStream("suma=suma+index"));
//
//        assertEquals(tokens.get(0).type, TokenType.SYMBOL);
//        assertEquals(tokens.get(1).type, TokenType.OP);
//        assertEquals(tokens.get(2).type, TokenType.SYMBOL);
//        assertEquals(tokens.get(3).type, TokenType.OP);
//        assertEquals(tokens.get(4).type, TokenType.SYMBOL);
//
//        for (Token token : tokens) {
//            System.out.println(token);
//        }
//    }
//
//    @Test
//    public void testComplexExpr() throws Exception {
//
//        List<Token> tokens = new Tokenizer().tokenize(stringStream("for i=0 to index"));
//
//        for (Token token : tokens) {
//            System.out.println(token);
//        }
//

//        assertEquals(tokens.get(0).string, "for");
//        assertEquals(tokens.get(1).string, "i");
//        assertEquals(tokens.get(2).value, '=');
//        assertEquals(tokens.get(3).intValue, "for");
//        assertEquals(tokens.get(0).string, "for");
//        assertEquals(tokens.get(0).string, "for");

//    }

}