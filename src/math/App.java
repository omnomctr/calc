package math;

import math.Expr.AbstractExpr;
import math.Parser.*;

public class App {
    public static AbstractExpr parseExpr(String s) throws ParserException {
        return new Parser(new Lexer(s)).parse();
    }

    public static void main(String[] args) throws Exception {
        while (true) try {
            String in = System.console().readLine();

            AbstractExpr expr = parseExpr(in);
            
            System.out.println("expr: " + expr.toString() + " value: " + expr.eval());
        } catch (ParserException e) {
            System.err.println("Parser Error: " + e.getMessage());
        }
    }
}
