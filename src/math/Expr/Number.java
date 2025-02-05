package math.Expr;

public class Number extends AbstractExpr {
    double value;

    public Number(double n) {
        value = n;
    }

    public String toString() {
        return Double.toString(value);
    }

    public double eval() {
        return value;
    }
}
