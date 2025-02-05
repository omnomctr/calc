package math.Parser;

import java.util.ArrayList;

import math.Parser.Token.TokenType;

public class Lexer {
    String input;
    int pos;
    char ch;

    public Lexer(String str) {
        input = str;
        pos = 0;
        ch = input.charAt(pos);
    }

    public Token nextToken() throws ParserException {
        skipWhitespace();

        Token ret;
        switch (ch) {
            case '\0': {
                ret = new Token(TokenType.EOF);
            } break;
            case '(': {
                ret = new Token(TokenType.LPAREN);
            } break;
            case ')': {
                ret = new Token(TokenType.RPAREN);
            } break;
            case '+': {
                ret = new Token(TokenType.PLUS);
            } break;
            case '-': {
                ret = new Token(TokenType.MINUS);
            } break;
            case '*': {
                ret = new Token(TokenType.TIMES);
            } break;
            case '/': {
                ret = new Token(TokenType.DIVIDE);
            } break;
            case '%': {
                ret = new Token(TokenType.MODULO);
            } break;
            case '^': {
                ret = new Token(TokenType.POW);
            } break;

            default: {
                if (Character.isDigit(ch)) {
                    return readNumber();
                } else {
                    throw new ParserException("illegal token \"" + ch + '\"');
                }
            }
        }

        readChar();
        return ret;
    }

    private void skipWhitespace() {
        while (ch == ' ' || ch == '\t' || ch == '\r' || ch == '\n')
            readChar();
    }

    private void readChar() {
        pos++;
        ch = pos >= input.length() ? '\0' : input.charAt(pos);
    }

    private Token readNumber() {
        int start = pos;
        boolean period = false;

        while ((input.length() > pos) && (Character.isDigit(ch) || (ch == '.' && !period))) {
            if (ch == '.') period = true;

            readChar();
        }

        return new Token(Double.parseDouble(input.substring(start, pos)));
    }

    public ArrayList<Token> collect() throws ParserException {
        Token t = nextToken();
        var tokens = new ArrayList<Token>();

        while (!t.isEOF()) {
            tokens.add(t);
            t = nextToken();
        }

        return tokens;
    }
}
