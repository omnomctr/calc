package math.Expr;

public class Mod extends AbstractExpr {
    AbstractExpr lhs;
    AbstractExpr rhs;

    public Mod(AbstractExpr a, AbstractExpr b) {
        lhs = a; 
        rhs = b;
    }

    public String toString() {
        return "(" + lhs.toString() + " % " + rhs.toString() + ")";
    }

    public double eval() {
        return lhs.eval() % rhs.eval();
    }
}
