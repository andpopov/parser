package rl.lexer;

import rl.Source;
import rl.Token;
import rl.lexer.recognizer.Recognizer;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private Source source;
    private int pos = -1;
    private int lineNum = -1;

    public Lexer(Source source) {
        this.source = source;
    }

    public Token[] tokens() {
        List<Token> tokens = new ArrayList<Token>();

        loop: while (!EOF()) {
            read();

            skipWhitespaces();
            if(EOF()) continue;

            for (Recognizer recognizer : RecognizerRegistry.getRecognizers()) {
                if(recognizer.match(this)) {
                    tokens.add(recognizer.getToken());
                    continue loop;
                }
            }

            if(!EOF()) {
                throw new RuntimeException("Unexpected char ^^^" + getChar() + ": lineNum=" + lineNum + ", pos=" + pos);
            }
        }
        return tokens.toArray(new Token[tokens.size()]);
    }

    public char getChar() {
        return source.getText().charAt(pos);
    }

    public void read() {
        pos++;
        if(!EOF() && getChar() == '\n') {
            lineNum++;
        }
    }

    private void read(char ch) {
        read();
        if (getChar() != ch) {
            throw new RuntimeException("Expected '" + ch + "'");
        }
    }

    public void unread() {
        unread(1);
    }

    private void unread(int count) {
        while(count > 0) {
            pos--;
            count--;
            if(getChar() == '\n') {
                lineNum--;
            }
        }
    }

    private void skipWhitespaces() {
        while (!EOF() && Character.isWhitespace(getChar())) {
            read();
        }
    }

    public boolean EOF() {
        return pos == source.getText().length();
    }
}
