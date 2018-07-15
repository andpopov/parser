package rl.lexer.recognizer;

import rl.Token;
import rl.lexer.Lexer;

public class VarRecognizer extends Recognizer {
    public boolean match(Lexer lexer) {
        token = null;

        if(lexer.EOF()) return false;

        if (Character.isLetter(lexer.getChar()) && lexer.getChar() == 'v') {
            token = new Token(Token.Type.VAR);
            StringBuilder builder = new StringBuilder();
            builder.append(lexer.getChar());

            while(true) {
                lexer.read();
                if(lexer.EOF()) {
                    token.setValue(builder.toString().toCharArray());
                    if("var".equals(builder.toString())) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (Character.isLetter(lexer.getChar())) {
                    builder.append(lexer.getChar());
                } else {
                    token.setValue(builder.toString().toCharArray());
                    lexer.unread();
                    if("var".equals(builder.toString())) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
