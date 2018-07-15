package rl.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * Stmt := Assign ;
 * | Expr;
 */
public class Program extends Node {
    public List<Stmt> stmtList = new ArrayList<Stmt>();
}
