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

    public AbstractExpr parse() throws ParserException {
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

    private AbstractExpr factor() throws ParserException {
        Token token = currentToken;

        if (token.kind == TokenType.NUMBER) {
            eat(TokenType.NUMBER);
            AbstractExpr ret = new Number(token.getNum());
            if (currentToken.kind == TokenType.LPAREN) {
                ret = new Mult(ret, factor());
            }
            return ret;
        } else if (token.kind == TokenType.MINUS) { /* unary minus */
            eat(TokenType.MINUS);
            return new UnaSub(factor());
        } else if (token.kind == TokenType.LPAREN) {
            eat(TokenType.LPAREN);
            AbstractExpr ret = expr();
            eat(TokenType.RPAREN);

            return ret;
        }

        throw new ParserException("invalid factor form");
    }

    private AbstractExpr term() throws ParserException {
        AbstractExpr ret = factor();
        while (currentToken.kind == TokenType.TIMES || currentToken.kind == TokenType.DIVIDE
            || currentToken.kind == TokenType.POW) {
            Token tok = currentToken;
            if (tok.kind == TokenType.TIMES) {
                eat(TokenType.TIMES);
                ret = new Mult(ret, factor());
            } else if (tok.kind == TokenType.DIVIDE) {
                eat(TokenType.DIVIDE);
                ret = new Div(ret, factor());
            } else if (tok.kind == TokenType.POW) {
                eat(TokenType.POW);
                ret = new Pow(ret, term());
            }
        }

        return ret;
    }

    private AbstractExpr expr() throws ParserException {
        AbstractExpr ret = term();
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
