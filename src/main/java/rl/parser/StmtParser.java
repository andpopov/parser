package rl.parser;

import rl.Parser;
import rl.ast.Assign;
import rl.ast.Expr;
import rl.ast.Ident;
import rl.ast.Stmt;

import static rl.Token.Type.*;

class StmtParser extends AstParser {
    public StmtParser(Parser parser) {
        super(parser);
    }

    public boolean parse() {
        markPos();

        AssignParser assignParser = new AssignParser(parser);
        if(assignParser.parse()) {
            Stmt stmt = new Stmt();
            stmt.expr = (Expr) assignParser.getResult();
            setResult(stmt);
            return true;
        }

        resetPos();
        return false;
    }
}
