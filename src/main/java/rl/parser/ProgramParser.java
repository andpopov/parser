package rl.parser;

import rl.Parser;
import rl.ast.Program;
import rl.ast.Stmt;

public class ProgramParser extends AstParser {
    public ProgramParser(Parser parser) {
        super(parser);
    }

    public boolean parse() {
        markPos();

        StmtParser stmtParser = new StmtParser(parser);
        if(stmtParser.parse()) {
            Program program = new Program();
            program.stmtList.add((Stmt) stmtParser.getResult());
            setResult(program);
            return true;
        }

        resetPos();
        return false;
    }
}
