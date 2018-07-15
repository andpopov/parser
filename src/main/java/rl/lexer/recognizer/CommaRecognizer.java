package rl.lexer.recognizer;

import rl.Token;
import rl.lexer.Lexer;

public class CommaRecognizer extends Recognizer {
    public boolean match(Lexer lexer) {
        token = null;

        if(lexer.EOF()) return false;

        switch (lexer.getChar()) {
            case ',':
                token = new Token(Token.Type.COMMA);
                return true;
        }
        return false;
    }
}
