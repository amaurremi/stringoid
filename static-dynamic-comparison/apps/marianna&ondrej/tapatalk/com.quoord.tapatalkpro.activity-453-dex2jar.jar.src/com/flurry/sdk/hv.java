package com.flurry.sdk;

import java.io.IOException;

public abstract class hv
        extends hj {
    protected hv() {
    }

    protected hv(int paramInt) {
        super(paramInt);
    }

    protected static final String c(int paramInt) {
        char c = (char) paramInt;
        if (Character.isISOControl(c)) {
            return "(CTRL-CHAR, code " + paramInt + ")";
        }
        if (paramInt > 255) {
            return "'" + c + "' (code " + paramInt + " / 0x" + Integer.toHexString(paramInt) + ")";
        }
        return "'" + c + "' (code " + paramInt + ")";
    }

    protected abstract void H()
            throws hi;

    protected void R()
            throws hi {
        throw a("Unexpected end-of-String in base64 content");
    }

    protected void S()
            throws hi {
        c(" in " + this.b);
    }

    protected void T()
            throws hi {
        c(" in a value");
    }

    protected final void U() {
        throw new RuntimeException("Internal error: this code path should never get executed");
    }

    protected char a(char paramChar)
            throws hk {
        if (a(hj.a.f)) {
        }
        while ((paramChar == '\'') && (a(hj.a.d))) {
            return paramChar;
        }
        d("Unrecognized character escape " + c(paramChar));
        return paramChar;
    }

    protected void a(ha paramha, char paramChar, int paramInt, String paramString)
            throws hi {
        if (paramChar <= ' ') {
            paramha = "Illegal white space character (code 0x" + Integer.toHexString(paramChar) + ") as character #" + (paramInt + 1) + " of 4-char base64 unit: can only used between units";
        }
        for (; ; ) {
            Object localObject = paramha;
            if (paramString != null) {
                localObject = paramha + ": " + paramString;
            }
            throw a((String) localObject);
            if (paramha.a(paramChar)) {
                paramha = "Unexpected padding character ('" + paramha.b() + "') as character #" + (paramInt + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
            } else if ((!Character.isDefined(paramChar)) || (Character.isISOControl(paramChar))) {
                paramha = "Illegal character (code 0x" + Integer.toHexString(paramChar) + ") in base64 content";
            } else {
                paramha = "Illegal character '" + paramChar + "' (code 0x" + Integer.toHexString(paramChar) + ") in base64 content";
            }
        }
    }

    protected void a(String paramString, sj paramsj, ha paramha)
            throws IOException, hi {
        int k = paramString.length();
        int i = 0;
        if (i < k) {
        }
        for (; ; ) {
            int j = i + 1;
            char c = paramString.charAt(i);
            if (j >= k) {
                return;
            }
            if (c > ' ') {
                int m = paramha.b(c);
                if (m < 0) {
                    a(paramha, c, 0, null);
                }
                if (j >= k) {
                    R();
                }
                i = j + 1;
                c = paramString.charAt(j);
                j = paramha.b(c);
                if (j < 0) {
                    a(paramha, c, 1, null);
                }
                m = m << 6 | j;
                if (i >= k) {
                    if (!paramha.a()) {
                        paramsj.a(m >> 4);
                        return;
                    }
                    R();
                }
                j = i + 1;
                c = paramString.charAt(i);
                i = paramha.b(c);
                if (i < 0) {
                    if (i != -2) {
                        a(paramha, c, 2, null);
                    }
                    if (j >= k) {
                        R();
                    }
                    i = j + 1;
                    c = paramString.charAt(j);
                    if (!paramha.a(c)) {
                        a(paramha, c, 3, "expected padding character '" + paramha.b() + "'");
                    }
                    paramsj.a(m >> 4);
                    break;
                }
                m = m << 6 | i;
                if (j >= k) {
                    if (!paramha.a()) {
                        paramsj.b(m >> 2);
                        return;
                    }
                    R();
                }
                i = j + 1;
                c = paramString.charAt(j);
                j = paramha.b(c);
                if (j < 0) {
                    if (j != -2) {
                        a(paramha, c, 3, null);
                    }
                    paramsj.b(m >> 2);
                    break;
                }
                paramsj.c(m << 6 | j);
                break;
            }
            i = j;
        }
    }

    protected final void a(String paramString, Throwable paramThrowable)
            throws hi {
        throw b(paramString, paramThrowable);
    }

    protected final hi b(String paramString, Throwable paramThrowable) {
        return new hi(paramString, i(), paramThrowable);
    }

    public abstract hm b()
            throws IOException, hi;

    protected void b(int paramInt)
            throws hi {
        paramInt = (char) paramInt;
        d("Illegal character (" + c(paramInt) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
    }

    protected void b(int paramInt, String paramString)
            throws hi {
        String str2 = "Unexpected character (" + c(paramInt) + ")";
        String str1 = str2;
        if (paramString != null) {
            str1 = str2 + ": " + paramString;
        }
        d(str1);
    }

    protected void c(int paramInt, String paramString)
            throws hi {
        if ((!a(hj.a.e)) || (paramInt >= 32)) {
            paramInt = (char) paramInt;
            d("Illegal unquoted character (" + c(paramInt) + "): has to be escaped using backslash to be included in " + paramString);
        }
    }

    protected void c(String paramString)
            throws hi {
        d("Unexpected end-of-input" + paramString);
    }

    public hj d()
            throws IOException, hi {
        if ((this.b != hm.b) && (this.b != hm.d)) {
            return this;
        }
        int i = 1;
        int j;
        do {
            for (; ; ) {
                hm localhm = b();
                if (localhm == null) {
                    H();
                    return this;
                }
                switch (1. a[localhm.ordinal()])
                {
                    default:
                        break;
                    case 1:
                    case 2:
                        i += 1;
                }
            }
            j = i - 1;
            i = j;
        } while (j != 0);
        return this;
    }

    protected final void d(String paramString)
            throws hi {
        throw a(paramString);
    }

    public abstract String k()
            throws IOException, hi;
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/hv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */