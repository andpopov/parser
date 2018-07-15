package rl.lexer.recognizer;

import rl.Token;
import rl.lexer.Lexer;

public class IDRecognizer extends Recognizer {
    public boolean match(Lexer lexer) {
        token = null;

        if(lexer.EOF()) return false;

        if (Character.isLetter(lexer.getChar()) || lexer.getChar() == '_') {
            token = new Token(Token.Type.ID);
            StringBuilder builder = new StringBuilder();
            builder.append(lexer.getChar());

            while(true) {
                lexer.read();
                if(lexer.EOF()) {
                    token.setValue(builder.toString().toCharArray());
                    return true;
                } else if (Character.isLetterOrDigit(lexer.getChar()) || lexer.getChar() == '_') {
                    builder.append(lexer.getChar());
                } else {
                    token.setValue(builder.toString().toCharArray());
                    lexer.unread();
                    return true;
                }
            }
        }
        return false;
    }
}
