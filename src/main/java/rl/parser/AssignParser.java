package rl.parser;

import rl.Parser;
import rl.ast.Assign;
import rl.ast.Expr;
import rl.ast.Ident;

import static rl.Token.Type.*;

class AssignParser extends AstParser {
    public AssignParser(Parser parser) {
        super(parser);
    }

    public boolean parse() {
        markPos();

        if(match(VAR)) {
            Assign assign = new Assign();

            if(match(ID)) {
                Ident ident = new Ident();
                ident.name = token().toStr();
                assign.ident = ident;

                if(match(ASSIGN)) {
                    ExprParser exprParser = new ExprParser(parser);
                    if(exprParser.parse() && match(SEMICOLON)) {
                        assign.expr = (Expr) exprParser.getResult();
                        setResult(assign);
                        return true;
                    }
                }
            }
        }

        resetPos();
        return false;
    }
}
