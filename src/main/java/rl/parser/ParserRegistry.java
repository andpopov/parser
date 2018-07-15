package rl.parser;

import java.util.Arrays;

public class ParserRegistry {
    public static AstParser[] parsers = new AstParser[0];

    static {
        loadParsers();
    }

    static private void loadParsers() {
//        register(new AssignParser());
    }

    static protected void register(AstParser parser) {
        parsers = Arrays.copyOf(parsers, parsers.length + 1);
        parsers[parsers.length - 1] = parser;
    }

    static public AstParser[] getParsers() {
        return parsers;
    }

}
