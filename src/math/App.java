package math;

import math.Expr.AbstractExpr;
import math.Parser.*;

public class App {
    public static AbstractExpr parseExpr(String s) throws ParserException {
        return new Parser(new Lexer(s)).parse();
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            String in = System.console().readLine();

            AbstractExpr expr = parseExpr(in);
            
            System.out.println("expr: " + expr.toString() + " value: " + expr.eval());
        }
    }
}
