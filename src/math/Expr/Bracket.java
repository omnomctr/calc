package math.Expr;

public class Bracket extends AExpr {
    AExpr value;

    public Bracket(AExpr val) {
        value = val;
    }

    public String toString() {
        return "(" + value.toString() + ")";
    }

    public double eval() {
        return value.eval();
    }
}
