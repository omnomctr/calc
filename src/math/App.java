package math;

import math.Expr.AExpr;
import math.Parser.*;

public class App {
    public static AExpr parseExpr(String s) throws ParserException {
        return new Parser(new Lexer(s)).parse();
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            String in = System.console().readLine();

            AExpr expr = parseExpr(in);
            
            System.out.println("expr: " + expr.toString() + " value: " + expr.eval());
        }
    }
}
