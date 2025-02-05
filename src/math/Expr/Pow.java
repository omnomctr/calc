package math.Expr;

public class Pow extends AbstractExpr {
    AbstractExpr base;
    AbstractExpr exponent;

    public Pow(AbstractExpr a, AbstractExpr b) {
        base = a; 
        exponent = b;
    }

    public String toString() {
        return "(" + base.toString() + "^(" + exponent.toString() + "))"; 
    }

    public double eval() {
        return Math.pow(base.eval(), exponent.eval());
    }
}
