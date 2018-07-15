package rl.parser;

import rl.Parser;
import rl.Token;
import rl.ast.Node;

public abstract class AstParser {
    protected Parser parser;
    protected int markPos = -1;

    public AstParser(Parser parser) {
        this.parser = parser;
    }

    protected void markPos() {
        markPos = pos();
    }

    protected void resetPos() {
        pos(markPos);
    }

    protected Node result;

    public Node getResult() {
        return result;
    }

    public void setResult(Node result) {
        this.result = result;
    }

    abstract public boolean parse();

    protected boolean match(Token.Type... tokenTypes) {
        markPos();

        boolean allMatched = true;

        for (Token.Type tokenType : tokenTypes) {
            if(!match(tokenType)) {
                allMatched = false;
                break;
            }
        }

        if(!allMatched) {
            resetPos();
        }

        return allMatched;
    }

    public boolean match(Token.Type tokenType) {
        nextToken();
        if(pos() < tokenCount()) {
            if(token().getType() == tokenType) {
//                nextToken();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Token token() {
        return parser.token();
    }

    public int tokenCount() {
        return parser.tokens.length;
    }

    public void nextToken() {
        parser.pos++;
    }

    protected int pos() {
        return parser.pos;
    }

    protected void pos(int pos) {
        parser.pos = pos;
    }
}
