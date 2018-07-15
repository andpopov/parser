package rl.lexer.recognizer;

import rl.Token;
import rl.lexer.Lexer;
import rl.lexer.RecognizerRegistry;

public class SemicolonRecognizer extends Recognizer {
    public boolean match(Lexer lexer) {
        token = null;

        if(lexer.EOF()) return false;

        switch (lexer.getChar()) {
            case ';':
                token = new Token(Token.Type.SEMICOLON);
                return true;
        }
        return false;
    }
}
