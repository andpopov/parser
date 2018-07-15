package rl.lexer.recognizer;

import rl.Token;
import rl.lexer.Lexer;

public class PeriodRecognizer extends Recognizer {
    public boolean match(Lexer lexer) {
        token = null;

        if(lexer.EOF()) return false;

        switch (lexer.getChar()) {
            case ':':
                token = new Token(Token.Type.PERIOD);
                return true;
        }
        return false;
    }
}
