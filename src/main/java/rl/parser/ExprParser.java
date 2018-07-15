package rl.parser;

import rl.Parser;
import rl.ast.*;
import rl.ast.Number;

import static rl.Token.Type.*;

class ExprParser extends AstParser {
    public ExprParser(Parser parser) {
        super(parser);
    }

    public boolean parse() {
        markPos();

        if(match(NUMBER)) {
            Number expr = new Number();
            expr.value = token().toInt();
            result = expr;
            return true;
        }

        if(match(ID)) {
            Ident ident = new Ident();
            ident.name = token().toStr();
            result = ident;
            return true;
        }

        resetPos();
        return false;
    }
}
