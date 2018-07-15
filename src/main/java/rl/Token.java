package rl;


import java.util.Arrays;

public class Token {
    public enum Type {
        ID, NUMBER, OPERATION, SP, COMMA, OPEN_PARENTHESES, COLON, SEMICOLON, PERIOD, OPEN_BRACE, CLOSE_BRACE, OPEN_BRACKET, CLOSE_BRACKET, CLOSE_PARENTHESES, ASSIGN, VAR;
    };

    private Source source;
    private int startPos;
    private int endPos;

    private Type type;
    private char[] value;

    public Token(Type type) {
        this.type = type;
    }

    public char[] getValue() {
        return value;
    }

    public String toStr() {
        return new String(value);
    }

    public int toInt() {
        return Integer.parseInt(new String(value));
    }

    public void setValue(char[] value) {
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", value=" + Arrays.toString(value) +
                '}';
    }
};