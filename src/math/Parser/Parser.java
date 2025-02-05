package math.Parser;

import math.Expr.*;
import math.Expr.Number;
import math.Parser.Token.TokenType;

public class Parser {
    Lexer lex;
    Token currentToken;

    public Parser(Lexer l) throws ParserException {
        lex = l;
        currentToken = l.nextToken();
    }

    public AExpr parse() throws ParserException {
        return expr();
    }

    /* thank you javatpoint https://www.javatpoint.com/recursive-descent-parser */

    private void nextToken() throws ParserException {
        currentToken = lex.nextToken();
    }

    private Token eat(TokenType t) throws ParserException {
        if (currentToken.kind == t) {
            Token ret = currentToken;
            nextToken();
            return ret;
        } else {
            throw new ParserException("expected " + t.toString() + " got " + currentToken.kind.toString());
        }
    }

    private AExpr factor() throws ParserException {
        Token token = currentToken;

        if (token.kind == TokenType.NUMBER) {
            eat(TokenType.NUMBER);
            return new Number(token.getNum());
        } else if (token.kind == TokenType.LPAREN) {
            eat(TokenType.LPAREN);
            AExpr ret = expr();
            eat(TokenType.RPAREN);

            return ret;
        }

        throw new ParserException("not implemented");
    }

    private AExpr term() throws ParserException {
        AExpr ret = factor();
        while (currentToken.kind == TokenType.TIMES || currentToken.kind == TokenType.DIVIDE) {
            Token tok = currentToken;
            if (tok.kind == TokenType.TIMES) {
                eat(TokenType.TIMES);
                ret = new Mult(ret, factor());
            } else if (tok.kind == TokenType.DIVIDE) {
                eat(TokenType.DIVIDE);
                ret = new Div(ret, factor());
            }
        }

        return ret;
    }

    private AExpr expr() throws ParserException {
        AExpr ret = term();
        while (currentToken.kind == TokenType.PLUS || currentToken.kind == TokenType.MINUS) {
            Token tok = currentToken;
            if (tok.kind == TokenType.PLUS) {
                eat(TokenType.PLUS);
                ret = new Add(ret, term());
            } else if (tok.kind == TokenType.MINUS) {
                eat(TokenType.MINUS);
                ret = new BinSub(ret, term());
            }
        }
        return ret;
    }
}
