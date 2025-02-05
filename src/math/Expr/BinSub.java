package math.Expr;

/* binary minus operator (subtraction) */
public class BinSub extends AbstractExpr {
    AbstractExpr lhs;
    AbstractExpr rhs;

    public BinSub(AbstractExpr a, AbstractExpr b) {
        lhs = a; rhs = b;
    }
    
    public String toString() {
        return "(" + rhs.toString() + " - " + rhs.toString() + ")";
    }

    public double eval() {
        return lhs.eval() - rhs.eval();
    }
}
