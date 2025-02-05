package math.Expr;

public class Div extends AExpr {
    AExpr lhs;
    AExpr rhs;

    public Div(AExpr a, AExpr b) {
        lhs = a; rhs = b;
    }

    public String toString() {
        return "(" + lhs.toString() + " / " + rhs.toString() + ")";
    }

    public double eval() {
        return lhs.eval() / rhs.eval();
    }
}
