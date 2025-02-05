package math.Expr;

/* binary minus operator (subtraction) */
public class BinSub extends AExpr {
    AExpr lhs;
    AExpr rhs;

    public BinSub(AExpr a, AExpr b) {
        lhs = a; rhs = b;
    }
    
    public String toString() {
        return "(" + rhs.toString() + " - " + rhs.toString() + ")";
    }

    public double eval() {
        return lhs.eval() - rhs.eval();
    }
}
