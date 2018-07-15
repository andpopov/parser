package rl.lexer.recognizer;

import rl.Token;
import rl.lexer.Lexer;

abstract public class Recognizer {
    Lexer lexer;
    protected Token token;

    public abstract boolean match(Lexer lexer);

    public Token getToken() {
        return token;
    }
}
