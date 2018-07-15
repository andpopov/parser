package rl.lexer.recognizer;

import rl.Token;
import rl.lexer.Lexer;

public class OperationRecognizer extends Recognizer {
    public boolean match(Lexer lexer) {
        token = null;

        if(lexer.EOF()) return false;

        switch (lexer.getChar()) {
            case '+':
            case '-':
            case '*':
            case '/':
                token = new Token(Token.Type.OPERATION);
                token.setValue(new char[] {lexer.getChar()});
                return true;
        }
        return false;
    }
}
