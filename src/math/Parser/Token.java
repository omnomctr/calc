package math.Parser;

public class Token {
    TokenType kind;
    Double number;

    public enum TokenType {
        LPAREN,
        RPAREN,
        PLUS,
        MINUS,
        TIMES,
        DIVIDE,
        MODULO,
        NUMBER,
        POW,
        EOF,
    }

    public Token(TokenType t) {
        kind = t;
    }

    public Token(Double num) {
        kind = TokenType.NUMBER;
        number = num;
    }

    public TokenType getKind() {
        return kind;
    }

    public Double getNum() throws RuntimeException {
        if (getKind() != TokenType.NUMBER) {
            throw new RuntimeException("tried to get number from non-number token");
        } else {
            return number;
        }
    }

    public boolean isEOF() {
        return getKind() == TokenType.EOF;
    }

    public String toString() {
        switch (getKind()) {
            case LPAREN: return "{LPAREN}";
            case RPAREN: return "{RPAREN}";
            case PLUS: return "{PLUS}";
            case MINUS: return "{MINUS}";
            case TIMES: return "{TIMES}";
            case DIVIDE: return "{DIVIDE}";
            case MODULO: return "{MODULO}";
            case NUMBER: return "{NUMBER " + getNum() + "}";
            case EOF: return "{EOF}"; 
            case POW: return "{POW}";
        }

        return "what";
    }
    
}
