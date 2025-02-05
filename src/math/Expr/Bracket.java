package math.Expr;

public class Bracket extends AbstractExpr {
    AbstractExpr value;

    public Bracket(AbstractExpr val) {
        value = val;
    }

    public String toString() {
        return "(" + value.toString() + ")";
    }

    public double eval() {
        return value.eval();
    }
}
