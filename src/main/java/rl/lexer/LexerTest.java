package rl.lexer;

import rl.Source;
import rl.lexer.Lexer;

import java.util.Arrays;

public class LexerTest {
    public static void main(String[] args) {
        Lexer lexer = new Lexer(new Source(
                "var a1 = 10;" + "\n" +
                "a1 = 20;"
        ));
//        Lexer lexer = new Lexer(new Source("1+3"));
        System.out.println(Arrays.toString(lexer.tokens()));
    }
}
