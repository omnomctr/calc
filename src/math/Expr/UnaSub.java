package math.Expr;

/* unary minus ie -1 */
public class UnaSub extends AbstractExpr {
    AbstractExpr negValue;

    public UnaSub(AbstractExpr val) {
        negValue = val;
    }

    public String toString() {
        return "(-" + negValue + ")";
    }

    public double eval() {
        return negValue.eval() * -1;
    }
}
