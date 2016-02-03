package javassist.compiler;

public class Lex
        implements TokenId {
    private static final int[] equalOps = {350, 0, 0, 0, 351, 352, 0, 0, 0, 353, 354, 0, 355, 0, 356, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 357, 358, 359, 0};
    private static final KeywordTable ktable = new KeywordTable();
    private Token currentToken = new Token();
    private String input;
    private int lastChar = -1;
    private int lineNumber;
    private Token lookAheadTokens = null;
    private int maxlen;
    private int position;
    private StringBuffer textBuffer = new StringBuffer();

    static {
        ktable.append("abstract", 300);
        ktable.append("boolean", 301);
        ktable.append("break", 302);
        ktable.append("byte", 303);
        ktable.append("case", 304);
        ktable.append("catch", 305);
        ktable.append("char", 306);
        ktable.append("class", 307);
        ktable.append("const", 308);
        ktable.append("continue", 309);
        ktable.append("default", 310);
        ktable.append("do", 311);
        ktable.append("double", 312);
        ktable.append("else", 313);
        ktable.append("extends", 314);
        ktable.append("false", 411);
        ktable.append("final", 315);
        ktable.append("finally", 316);
        ktable.append("float", 317);
        ktable.append("for", 318);
        ktable.append("goto", 319);
        ktable.append("if", 320);
        ktable.append("implements", 321);
        ktable.append("import", 322);
        ktable.append("instanceof", 323);
        ktable.append("int", 324);
        ktable.append("interface", 325);
        ktable.append("long", 326);
        ktable.append("native", 327);
        ktable.append("new", 328);
        ktable.append("null", 412);
        ktable.append("package", 329);
        ktable.append("private", 330);
        ktable.append("protected", 331);
        ktable.append("public", 332);
        ktable.append("return", 333);
        ktable.append("short", 334);
        ktable.append("static", 335);
        ktable.append("strictfp", 347);
        ktable.append("super", 336);
        ktable.append("switch", 337);
        ktable.append("synchronized", 338);
        ktable.append("this", 339);
        ktable.append("throw", 340);
        ktable.append("throws", 341);
        ktable.append("transient", 342);
        ktable.append("true", 410);
        ktable.append("try", 343);
        ktable.append("void", 344);
        ktable.append("volatile", 345);
        ktable.append("while", 346);
    }

    public Lex(String paramString) {
        this.input = paramString;
        this.position = 0;
        this.maxlen = paramString.length();
        this.lineNumber = 0;
    }

    private int get(Token paramToken) {
        int i;
        do {
            i = readLine(paramToken);
        } while (i == 10);
        paramToken.tokenId = i;
        return i;
    }

    private int getNextNonWhiteChar() {
        int j = getc();
        int i = j;
        if (j == 47) {
            i = getc();
            if (i != 47) {
                break label61;
            }
            do {
                j = getc();
                i = j;
                if (j == 10) {
                    break;
                }
                i = j;
                if (j == 13) {
                    break;
                }
            } while (j != -1);
            i = j;
        }
        while (!isBlank(i)) {
            return i;
            label61:
            if (i == 42) {
                for (; ; ) {
                    j = getc();
                    i = j;
                    if (j == -1) {
                        break;
                    }
                    if (j == 42) {
                        i = getc();
                        if (i == 47) {
                            i = 32;
                            break;
                        }
                        ungetc(i);
                    }
                }
            }
            ungetc(i);
            i = 47;
        }
    }

    private int getc() {
        int i = -1;
        if (this.lastChar < 0) {
            if (this.position < this.maxlen) {
                String str = this.input;
                i = this.position;
                this.position = (i + 1);
                i = str.charAt(i);
            }
            return i;
        }
        i = this.lastChar;
        this.lastChar = -1;
        return i;
    }

    private static boolean isBlank(int paramInt) {
        return (paramInt == 32) || (paramInt == 9) || (paramInt == 12) || (paramInt == 13) || (paramInt == 10);
    }

    private static boolean isDigit(int paramInt) {
        return (48 <= paramInt) && (paramInt <= 57);
    }

    private int readCharConst(Token paramToken) {
        int i = 0;
        for (; ; ) {
            int j = getc();
            if (j == 39) {
                break;
            }
            if (j == 92) {
                i = readEscapeChar();
            } else {
                if (j < 32) {
                    if (j == 10) {
                        this.lineNumber += 1;
                    }
                    return 500;
                }
                i = j;
            }
        }
        paramToken.longValue = i;
        return 401;
    }

    private int readDouble(StringBuffer paramStringBuffer, int paramInt, Token paramToken) {
        int i = paramInt;
        if (paramInt != 69) {
            i = paramInt;
            if (paramInt != 101) {
                i = paramInt;
                if (paramInt != 68) {
                    i = paramInt;
                    if (paramInt != 100) {
                        paramStringBuffer.append((char) paramInt);
                        for (; ; ) {
                            paramInt = getc();
                            i = paramInt;
                            if (48 > paramInt) {
                                break;
                            }
                            i = paramInt;
                            if (paramInt > 57) {
                                break;
                            }
                            paramStringBuffer.append((char) paramInt);
                        }
                    }
                }
            }
        }
        paramInt = i;
        if (paramInt != 69) {
            i = paramInt;
            if (paramInt != 101) {
            }
        } else {
            paramStringBuffer.append((char) paramInt);
            i = getc();
            if (i != 43) {
                paramInt = i;
                if (i != 45) {
                }
            } else {
                paramStringBuffer.append((char) i);
            }
            for (paramInt = getc(); ; paramInt = getc()) {
                i = paramInt;
                if (48 > paramInt) {
                    break;
                }
                i = paramInt;
                if (paramInt > 57) {
                    break;
                }
                paramStringBuffer.append((char) paramInt);
            }
        }
        try {
            paramToken.doubleValue = Double.parseDouble(paramStringBuffer.toString());
            if ((i == 70) || (i == 102)) {
                return 404;
            }
        } catch (NumberFormatException paramStringBuffer) {
            return 500;
        }
        if ((i != 68) && (i != 100)) {
            ungetc(i);
        }
        return 405;
    }

    private int readEscapeChar() {
        int i = getc();
        if (i == 110) {
            return 10;
        }
        if (i == 116) {
            return 9;
        }
        if (i == 114) {
            return 13;
        }
        if (i == 102) {
            return 12;
        }
        if (i == 10) {
            this.lineNumber += 1;
        }
        return i;
    }

    private int readIdentifier(int paramInt, Token paramToken) {
        Object localObject = this.textBuffer;
        ((StringBuffer) localObject).setLength(0);
        int i;
        do {
            ((StringBuffer) localObject).append((char) paramInt);
            i = getc();
            paramInt = i;
        } while (Character.isJavaIdentifierPart((char) i));
        ungetc(i);
        localObject = ((StringBuffer) localObject).toString();
        paramInt = ktable.lookup((String) localObject);
        if (paramInt >= 0) {
            return paramInt;
        }
        paramToken.textValue = ((String) localObject);
        return 400;
    }

    private int readLine(Token paramToken) {
        int i = getNextNonWhiteChar();
        if (i < 0) {
            return i;
        }
        if (i == 10) {
            this.lineNumber += 1;
            return 10;
        }
        if (i == 39) {
            return readCharConst(paramToken);
        }
        if (i == 34) {
            return readStringL(paramToken);
        }
        if ((48 <= i) && (i <= 57)) {
            return readNumber(i, paramToken);
        }
        if (i == 46) {
            i = getc();
            if ((48 <= i) && (i <= 57)) {
                StringBuffer localStringBuffer = this.textBuffer;
                localStringBuffer.setLength(0);
                localStringBuffer.append('.');
                return readDouble(localStringBuffer, i, paramToken);
            }
            ungetc(i);
            return readSeparator(46);
        }
        if (Character.isJavaIdentifierStart((char) i)) {
            return readIdentifier(i, paramToken);
        }
        return readSeparator(i);
    }

    private int readNumber(int paramInt, Token paramToken) {
        long l2 = 0L;
        int i = getc();
        if (paramInt == 48) {
            l1 = l2;
            if (i != 88) {
                if (i == 120) {
                    l1 = l2;
                }
            } else {
                for (; ; ) {
                    paramInt = getc();
                    if ((48 <= paramInt) && (paramInt <= 57)) {
                        l1 = l1 * 16L + (paramInt - 48);
                    } else if ((65 <= paramInt) && (paramInt <= 70)) {
                        l1 = l1 * 16L + (paramInt - 65 + 10);
                    } else {
                        if ((97 > paramInt) || (paramInt > 102)) {
                            break;
                        }
                        l1 = l1 * 16L + (paramInt - 97 + 10);
                    }
                }
                paramToken.longValue = l1;
                if ((paramInt == 76) || (paramInt == 108)) {
                    return 403;
                }
                ungetc(paramInt);
                return 402;
            }
            if ((48 <= i) && (i <= 55)) {
                for (l1 = i - 48; ; l1 = l1 * 8L + (paramInt - 48)) {
                    paramInt = getc();
                    if ((48 > paramInt) || (paramInt > 55)) {
                        break;
                    }
                }
                paramToken.longValue = l1;
                if ((paramInt == 76) || (paramInt == 108)) {
                    return 403;
                }
                ungetc(paramInt);
                return 402;
            }
        }
        long l1 = paramInt - 48;
        for (paramInt = i; (48 <= paramInt) && (paramInt <= 57); paramInt = getc()) {
            l1 = paramInt + l1 * 10L - 48L;
        }
        paramToken.longValue = l1;
        if ((paramInt == 70) || (paramInt == 102)) {
            paramToken.doubleValue = l1;
            return 404;
        }
        if ((paramInt == 69) || (paramInt == 101) || (paramInt == 68) || (paramInt == 100) || (paramInt == 46)) {
            StringBuffer localStringBuffer = this.textBuffer;
            localStringBuffer.setLength(0);
            localStringBuffer.append(l1);
            return readDouble(localStringBuffer, paramInt, paramToken);
        }
        if ((paramInt == 76) || (paramInt == 108)) {
            return 403;
        }
        ungetc(paramInt);
        return 402;
    }

    private int readSeparator(int paramInt) {
        int k;
        int j;
        int i;
        if ((33 <= paramInt) && (paramInt <= 63)) {
            k = equalOps[(paramInt - 33)];
            if (k == 0) {
                return paramInt;
            }
            j = getc();
            if (paramInt == j) {
                switch (paramInt) {
                    default:
                        i = j;
                }
            }
        }
        do {
            do {
                do {
                    ungetc(i);
                    return paramInt;
                    return 358;
                    return 362;
                    return 363;
                    return 369;
                    paramInt = getc();
                    if (paramInt == 61) {
                        return 365;
                    }
                    ungetc(paramInt);
                    return 364;
                    paramInt = getc();
                    if (paramInt == 61) {
                        return 367;
                    }
                    if (paramInt == 62) {
                        paramInt = getc();
                        if (paramInt == 61) {
                            return 371;
                        }
                        ungetc(paramInt);
                        return 370;
                    }
                    ungetc(paramInt);
                    return 366;
                    i = j;
                } while (j != 61);
                return k;
                if (paramInt != 94) {
                    break;
                }
                j = getc();
                i = j;
            } while (j != 61);
            return 360;
            if (paramInt != 124) {
                break;
            }
            j = getc();
            if (j == 61) {
                return 361;
            }
            i = j;
        } while (j != 124);
        return 368;
    }

    private int readStringL(Token paramToken) {
        StringBuffer localStringBuffer = this.textBuffer;
        localStringBuffer.setLength(0);
        int i;
        label57:
        do {
            int j = getc();
            if (j != 34) {
                if (j == 92) {
                    i = readEscapeChar();
                }
                do {
                    localStringBuffer.append((char) i);
                    break;
                    if (j == 10) {
                        break label57;
                    }
                    i = j;
                } while (j >= 0);
                this.lineNumber += 1;
                return 500;
            }
            do {
                for (; ; ) {
                    i = getc();
                    if (i != 10) {
                        break;
                    }
                    this.lineNumber += 1;
                }
            } while (isBlank(i));
        } while (i == 34);
        ungetc(i);
        paramToken.textValue = localStringBuffer.toString();
        return 406;
    }

    private void ungetc(int paramInt) {
        this.lastChar = paramInt;
    }

    public int get() {
        if (this.lookAheadTokens == null) {
            return get(this.currentToken);
        }
        Token localToken = this.lookAheadTokens;
        this.currentToken = localToken;
        this.lookAheadTokens = this.lookAheadTokens.next;
        return localToken.tokenId;
    }

    public double getDouble() {
        return this.currentToken.doubleValue;
    }

    public long getLong() {
        return this.currentToken.longValue;
    }

    public String getString() {
        return this.currentToken.textValue;
    }

    public String getTextAround() {
        int j = this.position - 10;
        int i = j;
        if (j < 0) {
            i = 0;
        }
        int k = this.position + 10;
        j = k;
        if (k > this.maxlen) {
            j = this.maxlen;
        }
        return this.input.substring(i, j);
    }

    public int lookAhead() {
        return lookAhead(0);
    }

    public int lookAhead(int paramInt) {
        Token localToken2 = this.lookAheadTokens;
        Token localToken1 = localToken2;
        int i = paramInt;
        if (localToken2 == null) {
            localToken1 = this.currentToken;
            this.lookAheadTokens = localToken1;
            localToken1.next = null;
            get(localToken1);
            i = paramInt;
        }
        while (i > 0) {
            if (localToken1.next == null) {
                localToken2 = new Token();
                localToken1.next = localToken2;
                get(localToken2);
            }
            localToken1 = localToken1.next;
            i -= 1;
        }
        this.currentToken = localToken1;
        return localToken1.tokenId;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/Lex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */