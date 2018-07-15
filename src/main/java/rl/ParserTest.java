package rl;

import rl.ast.Node;
import rl.lexer.Lexer;

import java.util.Arrays;

public class ParserTest {
    public static void main(String[] args) {
        Lexer lexer = new Lexer(new Source(
                "var a1 = 10;"
        ));

        Parser parser = new Parser(lexer);
        Node result = parser.parse();
        System.out.println(result);
    }
}
