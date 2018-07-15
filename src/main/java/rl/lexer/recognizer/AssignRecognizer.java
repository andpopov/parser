package rl.lexer.recognizer;

import rl.Token;
import rl.lexer.Lexer;

public class AssignRecognizer extends Recognizer {
    public boolean match(Lexer lexer) {
        token = null;

        if(lexer.EOF()) return false;

        switch (lexer.getChar()) {
            case '=':
                token = new Token(Token.Type.ASSIGN);
                return true;
        }
        return false;
    }
}
