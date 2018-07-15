package rl.lexer.recognizer;

import rl.Token;
import rl.lexer.Lexer;

public class CloseBraceRecognizer extends Recognizer {
    public boolean match(Lexer lexer) {
        token = null;

        if(lexer.EOF()) return false;

        switch (lexer.getChar()) {
            case '{':
                token = new Token(Token.Type.CLOSE_BRACE);
                return true;
        }
        return false;
    }
}
