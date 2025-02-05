package math.Expr;

public class Mult extends AExpr {
    AExpr lhs;
    AExpr rhs;

    public Mult(AExpr a, AExpr b) {
        lhs = a; rhs = b;
    }

    public String toString() {
        return "(" + lhs.toString() + " * " + rhs.toString() + ")";
    }

    public double eval() {
        return lhs.eval() * rhs.eval();
    }
}
