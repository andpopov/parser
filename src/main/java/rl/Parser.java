package rl;

import rl.ast.Assign;
import rl.ast.Ident;
import rl.ast.Node;
import rl.ast.Number;
import rl.ast.Stmt;
import rl.lexer.Lexer;
import rl.parser.AstParser;
import rl.parser.ParserRegistry;
import rl.parser.ProgramParser;

import static rl.Token.Type.*;

public class Parser {
    private Lexer lexer;

    public Token[] tokens;
    public int pos = -1;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
    }

    public Node parse() {
        tokens = lexer.tokens();
//        nextToken();

        ProgramParser programParser = new ProgramParser(this);
        if(programParser.parse()) {
            return programParser.getResult();
        } else {
            throw new RuntimeException("Parser error");
        }
    }

    public int tokenCount() {
        return tokens.length;
    }

    public void nextToken() {
        pos++;
    }

    public Token token() {
        return tokens[pos];
    }

}
