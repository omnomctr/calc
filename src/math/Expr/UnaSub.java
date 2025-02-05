package math.Expr;

/* unary minus ie -1 */
public class UnaSub extends AExpr {
    AExpr negValue;

    public UnaSub(AExpr val) {
        negValue = val;
    }

    public String toString() {
        return "(-" + negValue + ")";
    }

    public double eval() {
        return negValue.eval() * -1;
    }
}
