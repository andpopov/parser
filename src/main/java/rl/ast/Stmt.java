package rl.ast;

/**
 * Stmt := Assign ;
 * | Expr;
 */
public class Stmt extends Node {
    public Expr expr;
}
