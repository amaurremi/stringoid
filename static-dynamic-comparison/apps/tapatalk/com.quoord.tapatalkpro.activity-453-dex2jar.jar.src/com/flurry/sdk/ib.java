package com.flurry.sdk;

import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class ib
        extends ht {
    protected static final char[] g = ;
    protected static final int[] h = sk.f();
    protected final ie i;
    protected final Writer j;
    protected int[] k = h;
    protected int l;
    protected id m;
    protected hp n;
    protected char[] o;
    protected int p = 0;
    protected int q = 0;
    protected int r;
    protected char[] s;

    public ib(ie paramie, int paramInt, hn paramhn, Writer paramWriter) {
        super(paramInt, paramhn);
        this.i = paramie;
        this.j = paramWriter;
        this.o = paramie.h();
        this.r = this.o.length;
        if (a(hf.a.g)) {
            a(127);
        }
    }

    private final int a(char[] paramArrayOfChar, int paramInt1, int paramInt2, char paramChar, int paramInt3)
            throws IOException, he {
        Object localObject;
        if (paramInt3 >= 0) {
            if ((paramInt1 > 1) && (paramInt1 < paramInt2)) {
                paramInt1 -= 2;
                paramArrayOfChar[paramInt1] = '\\';
                paramArrayOfChar[(paramInt1 + 1)] = ((char) paramInt3);
                return paramInt1;
            }
            localObject = this.s;
            paramArrayOfChar = (char[]) localObject;
            if (localObject == null) {
                paramArrayOfChar = q();
            }
            paramArrayOfChar[1] = ((char) paramInt3);
            this.j.write(paramArrayOfChar, 0, 2);
            return paramInt1;
        }
        if (paramInt3 != -2) {
            if ((paramInt1 > 5) && (paramInt1 < paramInt2)) {
                paramInt1 -= 6;
                paramInt2 = paramInt1 + 1;
                paramArrayOfChar[paramInt1] = '\\';
                paramInt1 = paramInt2 + 1;
                paramArrayOfChar[paramInt2] = 'u';
                if (paramChar > 'ÿ') {
                    paramInt2 = paramChar >> '\b' & 0xFF;
                    paramInt3 = paramInt1 + 1;
                    paramArrayOfChar[paramInt1] = g[(paramInt2 >> 4)];
                    paramInt1 = paramInt3 + 1;
                    paramArrayOfChar[paramInt3] = g[(paramInt2 & 0xF)];
                    paramChar = (char) (paramChar & 0xFF);
                }
                for (; ; ) {
                    paramInt2 = paramInt1 + 1;
                    paramArrayOfChar[paramInt1] = g[(paramChar >> '\004')];
                    paramArrayOfChar[paramInt2] = g[(paramChar & 0xF)];
                    return paramInt2 - 5;
                    paramInt2 = paramInt1 + 1;
                    paramArrayOfChar[paramInt1] = '0';
                    paramInt1 = paramInt2 + 1;
                    paramArrayOfChar[paramInt2] = '0';
                }
            }
            localObject = this.s;
            paramArrayOfChar = (char[]) localObject;
            if (localObject == null) {
                paramArrayOfChar = q();
            }
            this.p = this.q;
            if (paramChar > 'ÿ') {
                paramInt2 = paramChar >> '\b' & 0xFF;
                paramChar &= 0xFF;
                paramArrayOfChar[10] = g[(paramInt2 >> 4)];
                paramArrayOfChar[11] = g[(paramInt2 & 0xF)];
                paramArrayOfChar[12] = g[(paramChar >> '\004')];
                paramArrayOfChar[13] = g[(paramChar & 0xF)];
                this.j.write(paramArrayOfChar, 8, 6);
                return paramInt1;
            }
            paramArrayOfChar[6] = g[(paramChar >> '\004')];
            paramArrayOfChar[7] = g[(paramChar & 0xF)];
            this.j.write(paramArrayOfChar, 2, 6);
            return paramInt1;
        }
        if (this.n == null) {
            localObject = this.m.a(paramChar).a();
        }
        for (; ; ) {
            paramChar = ((String) localObject).length();
            if ((paramInt1 < paramChar) || (paramInt1 >= paramInt2)) {
                break;
            }
            paramInt1 -= paramChar;
            ((String) localObject).getChars(0, paramChar, paramArrayOfChar, paramInt1);
            return paramInt1;
            localObject = this.n.a();
            this.n = null;
        }
        this.j.write((String) localObject);
        return paramInt1;
    }

    private final void a(char paramChar, int paramInt)
            throws IOException, he {
        char[] arrayOfChar;
        Object localObject;
        if (paramInt >= 0) {
            if (this.q >= 2) {
                paramChar = this.q - 2;
                this.p = paramChar;
                this.o[paramChar] = '\\';
                this.o[(paramChar + '\001')] = ((char) paramInt);
                return;
            }
            arrayOfChar = this.s;
            localObject = arrayOfChar;
            if (arrayOfChar == null) {
                localObject = q();
            }
            this.p = this.q;
            localObject[1] = ((char) paramInt);
            this.j.write((char[]) localObject, 0, 2);
            return;
        }
        if (paramInt != -2) {
            if (this.q >= 6) {
                localObject = this.o;
                paramInt = this.q - 6;
                this.p = paramInt;
                localObject[paramInt] = 92;
                paramInt += 1;
                localObject[paramInt] = 117;
                if (paramChar > 'ÿ') {
                    int i1 = paramChar >> '\b' & 0xFF;
                    paramInt += 1;
                    localObject[paramInt] = g[(i1 >> 4)];
                    paramInt += 1;
                    localObject[paramInt] = g[(i1 & 0xF)];
                    paramChar = (char) (paramChar & 0xFF);
                }
                for (; ; ) {
                    paramInt += 1;
                    localObject[paramInt] = g[(paramChar >> '\004')];
                    localObject[(paramInt + 1)] = g[(paramChar & 0xF)];
                    return;
                    paramInt += 1;
                    localObject[paramInt] = 48;
                    paramInt += 1;
                    localObject[paramInt] = 48;
                }
            }
            arrayOfChar = this.s;
            localObject = arrayOfChar;
            if (arrayOfChar == null) {
                localObject = q();
            }
            this.p = this.q;
            if (paramChar > 'ÿ') {
                paramInt = paramChar >> '\b' & 0xFF;
                paramChar &= 0xFF;
                localObject[10] = g[(paramInt >> 4)];
                localObject[11] = g[(paramInt & 0xF)];
                localObject[12] = g[(paramChar >> '\004')];
                localObject[13] = g[(paramChar & 0xF)];
                this.j.write((char[]) localObject, 8, 6);
                return;
            }
            localObject[6] = g[(paramChar >> '\004')];
            localObject[7] = g[(paramChar & 0xF)];
            this.j.write((char[]) localObject, 2, 6);
            return;
        }
        if (this.n == null) {
            localObject = this.m.a(paramChar).a();
        }
        for (; ; ) {
            paramChar = ((String) localObject).length();
            if (this.q < paramChar) {
                break;
            }
            paramInt = this.q - paramChar;
            this.p = paramInt;
            ((String) localObject).getChars(0, paramChar, this.o, paramInt);
            return;
            localObject = this.n.a();
            this.n = null;
        }
        this.p = this.q;
        this.j.write((String) localObject);
    }

    private void a(int paramInt1, int paramInt2)
            throws IOException, he {
        int i2 = this.q + paramInt1;
        int[] arrayOfInt = this.k;
        int i3 = Math.min(arrayOfInt.length, this.l + 1);
        if (this.q < i2) {
            label124:
            do {
                int i1 = this.o[this.q];
                if (i1 < i3) {
                    paramInt1 = arrayOfInt[i1];
                    if (paramInt1 == 0) {
                    }
                } else {
                    for (; ; ) {
                        int i4 = this.q - this.p;
                        if (i4 > 0) {
                            this.j.write(this.o, this.p, i4);
                        }
                        this.q += 1;
                        a(i1, paramInt1);
                        break;
                        if (i1 <= paramInt2) {
                            break label124;
                        }
                        paramInt1 = -1;
                    }
                }
                paramInt1 = this.q + 1;
                this.q = paramInt1;
            } while (paramInt1 < i2);
        }
    }

    private final void a(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
            throws IOException, he {
        int i5 = paramInt2 + paramInt1;
        int[] arrayOfInt = this.k;
        int i6 = Math.min(arrayOfInt.length, paramInt3 + 1);
        int i2 = 0;
        paramInt2 = paramInt1;
        paramInt1 = i2;
        for (; ; ) {
            int i4;
            int i1;
            int i3;
            if (paramInt2 < i5) {
                i2 = paramInt2;
                i4 = paramInt1;
                i1 = paramArrayOfChar[i2];
                if (i1 >= i6) {
                    break label144;
                }
                i3 = arrayOfInt[i1];
                paramInt1 = i3;
                if (i3 == 0) {
                    break label159;
                }
                paramInt1 = i3;
                label74:
                i3 = i2 - paramInt2;
                if (i3 >= 32) {
                    break label186;
                }
                if (this.q + i3 > this.r) {
                    o();
                }
                if (i3 > 0) {
                    System.arraycopy(paramArrayOfChar, paramInt2, this.o, this.q, i3);
                    this.q += i3;
                }
            }
            for (; ; ) {
                if (i2 < i5) {
                    break label204;
                }
                return;
                label144:
                paramInt1 = i4;
                if (i1 > paramInt3) {
                    paramInt1 = -1;
                    break label74;
                }
                label159:
                i3 = i2 + 1;
                i4 = paramInt1;
                i2 = i3;
                if (i3 < i5) {
                    break;
                }
                i2 = i3;
                break label74;
                label186:
                o();
                this.j.write(paramArrayOfChar, paramInt2, i3);
            }
            label204:
            paramInt2 = i2 + 1;
            b(i1, paramInt1);
        }
    }

    private final void b(char paramChar, int paramInt)
            throws IOException, he {
        Object localObject;
        if (paramInt >= 0) {
            if (this.q + 2 > this.r) {
                o();
            }
            localObject = this.o;
            paramChar = this.q;
            this.q = (paramChar + '\001');
            localObject[paramChar] = 92;
            localObject = this.o;
            paramChar = this.q;
            this.q = (paramChar + '\001');
            localObject[paramChar] = ((char) paramInt);
            return;
        }
        if (paramInt != -2) {
            if (this.q + 2 > this.r) {
                o();
            }
            paramInt = this.q;
            localObject = this.o;
            int i1 = paramInt + 1;
            localObject[paramInt] = 92;
            paramInt = i1 + 1;
            localObject[i1] = 117;
            if (paramChar > 'ÿ') {
                i1 = paramChar >> '\b' & 0xFF;
                int i2 = paramInt + 1;
                localObject[paramInt] = g[(i1 >> 4)];
                paramInt = i2 + 1;
                localObject[i2] = g[(i1 & 0xF)];
                paramChar = (char) (paramChar & 0xFF);
            }
            for (; ; ) {
                i1 = paramInt + 1;
                localObject[paramInt] = g[(paramChar >> '\004')];
                localObject[i1] = g[(paramChar & 0xF)];
                this.q = i1;
                return;
                i1 = paramInt + 1;
                localObject[paramInt] = 48;
                paramInt = i1 + 1;
                localObject[i1] = 48;
            }
        }
        if (this.n == null) {
            localObject = this.m.a(paramChar).a();
        }
        for (; ; ) {
            paramChar = ((String) localObject).length();
            if (this.q + paramChar <= this.r) {
                break;
            }
            o();
            if (paramChar <= this.r) {
                break;
            }
            this.j.write((String) localObject);
            return;
            localObject = this.n.a();
            this.n = null;
        }
        ((String) localObject).getChars(0, paramChar, this.o, this.q);
        this.q += paramChar;
    }

    private final void b(int paramInt1, int paramInt2)
            throws IOException, he {
        int i2 = 0;
        int[] arrayOfInt = this.k;
        int i7 = Math.min(arrayOfInt.length, this.l + 1);
        int i4 = 0;
        int i3 = 0;
        for (; ; ) {
            int i6;
            int i1;
            if (i3 < paramInt1) {
                i6 = i2;
                i1 = this.o[i3];
                if (i1 >= i7) {
                    break label98;
                }
                i2 = arrayOfInt[i1];
                if (i2 == 0) {
                    break label113;
                }
            }
            for (; ; ) {
                int i5 = i3 - i4;
                if (i5 <= 0) {
                    break label140;
                }
                this.j.write(this.o, i4, i5);
                if (i3 < paramInt1) {
                    break label140;
                }
                return;
                label98:
                i2 = i6;
                if (i1 > paramInt2) {
                    i2 = -1;
                } else {
                    label113:
                    i5 = i3 + 1;
                    i6 = i2;
                    i3 = i5;
                    if (i5 < paramInt1) {
                        break;
                    }
                    i3 = i5;
                }
            }
            label140:
            i3 += 1;
            i4 = a(this.o, i3, paramInt1, i1, i2);
        }
    }

    private final void b(long paramLong)
            throws IOException {
        if (this.q + 23 >= this.r) {
            o();
        }
        char[] arrayOfChar = this.o;
        int i1 = this.q;
        this.q = (i1 + 1);
        arrayOfChar[i1] = '"';
        this.q = ij.a(paramLong, this.o, this.q);
        arrayOfChar = this.o;
        i1 = this.q;
        this.q = (i1 + 1);
        arrayOfChar[i1] = '"';
    }

    private final void c(int paramInt)
            throws IOException {
        if (this.q + 13 >= this.r) {
            o();
        }
        char[] arrayOfChar = this.o;
        int i1 = this.q;
        this.q = (i1 + 1);
        arrayOfChar[i1] = '"';
        this.q = ij.a(paramInt, this.o, this.q);
        arrayOfChar = this.o;
        paramInt = this.q;
        this.q = (paramInt + 1);
        arrayOfChar[paramInt] = '"';
    }

    private final void c(Object paramObject)
            throws IOException {
        if (this.q >= this.r) {
            o();
        }
        char[] arrayOfChar = this.o;
        int i1 = this.q;
        this.q = (i1 + 1);
        arrayOfChar[i1] = '"';
        c(paramObject.toString());
        if (this.q >= this.r) {
            o();
        }
        paramObject = this.o;
        i1 = this.q;
        this.q = (i1 + 1);
        paramObject[i1] = 34;
    }

    private final void c(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws IOException, he {
        if (this.m != null) {
            d(paramArrayOfChar, paramInt1, paramInt2);
        }
        label50:
        label58:
        label78:
        label168:
        label189:
        label205:
        for (; ; ) {
            return;
            if (this.l != 0) {
                a(paramArrayOfChar, paramInt1, paramInt2, this.l);
                return;
            }
            int i2 = paramInt2 + paramInt1;
            int[] arrayOfInt = this.k;
            int i3 = arrayOfInt.length;
            int i1;
            if (paramInt1 < i2) {
                paramInt2 = paramInt1;
                i1 = paramArrayOfChar[paramInt2];
                if ((i1 >= i3) || (arrayOfInt[i1] == 0)) {
                    break label168;
                }
                i1 = paramInt2 - paramInt1;
                if (i1 >= 32) {
                    break label189;
                }
                if (this.q + i1 > this.r) {
                    o();
                }
                if (i1 > 0) {
                    System.arraycopy(paramArrayOfChar, paramInt1, this.o, this.q, i1);
                    this.q += i1;
                }
            }
            for (; ; ) {
                if (paramInt2 >= i2) {
                    break label205;
                }
                paramInt1 = paramInt2 + 1;
                char c = paramArrayOfChar[paramInt2];
                b(c, arrayOfInt[c]);
                break label50;
                break;
                i1 = paramInt2 + 1;
                paramInt2 = i1;
                if (i1 < i2) {
                    break label58;
                }
                paramInt2 = i1;
                break label78;
                o();
                this.j.write(paramArrayOfChar, paramInt1, i1);
            }
        }
    }

    private void d(int paramInt)
            throws IOException, he {
        paramInt = this.q + paramInt;
        int[] arrayOfInt = this.k;
        int i1 = arrayOfInt.length;
        if (this.q < paramInt) {
            int i2;
            do {
                i2 = this.o[this.q];
                if ((i2 < i1) && (arrayOfInt[i2] != 0)) {
                    i2 = this.q - this.p;
                    if (i2 > 0) {
                        this.j.write(this.o, this.p, i2);
                    }
                    char[] arrayOfChar = this.o;
                    i2 = this.q;
                    this.q = (i2 + 1);
                    char c = arrayOfChar[i2];
                    a(c, arrayOfInt[c]);
                    break;
                }
                i2 = this.q + 1;
                this.q = i2;
            } while (i2 < paramInt);
        }
    }

    private final void d(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws IOException, he {
        int i6 = paramInt2 + paramInt1;
        int[] arrayOfInt = this.k;
        int i3;
        int i7;
        id localid;
        int i2;
        if (this.l < 1) {
            i3 = 65535;
            i7 = Math.min(arrayOfInt.length, i3 + 1);
            localid = this.m;
            i2 = 0;
            paramInt2 = paramInt1;
            paramInt1 = i2;
        }
        for (; ; ) {
            int i5;
            label61:
            int i1;
            int i4;
            if (paramInt2 < i6) {
                i2 = paramInt2;
                i5 = paramInt1;
                i1 = paramArrayOfChar[i2];
                if (i1 >= i7) {
                    break label171;
                }
                i4 = arrayOfInt[i1];
                paramInt1 = i4;
                if (i4 == 0) {
                    break label212;
                }
                paramInt1 = i4;
                label92:
                i4 = i2 - paramInt2;
                if (i4 >= 32) {
                    break label239;
                }
                if (this.q + i4 > this.r) {
                    o();
                }
                if (i4 > 0) {
                    System.arraycopy(paramArrayOfChar, paramInt2, this.o, this.q, i4);
                    this.q += i4;
                }
            }
            for (; ; ) {
                if (i2 < i6) {
                    break label257;
                }
                return;
                i3 = this.l;
                break;
                label171:
                if (i1 > i3) {
                    paramInt1 = -1;
                    break label92;
                }
                hp localhp = localid.a(i1);
                this.n = localhp;
                paramInt1 = i5;
                if (localhp != null) {
                    paramInt1 = -2;
                    break label92;
                }
                label212:
                i4 = i2 + 1;
                i5 = paramInt1;
                i2 = i4;
                if (i4 < i6) {
                    break label61;
                }
                i2 = i4;
                break label92;
                label239:
                o();
                this.j.write(paramArrayOfChar, paramInt2, i4);
            }
            label257:
            paramInt2 = i2 + 1;
            b(i1, paramInt1);
        }
    }

    private final void e(int paramInt)
            throws IOException, he {
        int[] arrayOfInt = this.k;
        int i5 = arrayOfInt.length;
        int i2 = 0;
        int i1;
        for (int i3 = 0; ; i3 = a(this.o, i2, paramInt, i1, arrayOfInt[i1])) {
            if (i2 < paramInt) {
                i1 = this.o[i2];
                if ((i1 >= i5) || (arrayOfInt[i1] == 0)) {
                    break label73;
                }
            }
            for (; ; ) {
                int i4 = i2 - i3;
                if (i4 <= 0) {
                    break label93;
                }
                this.j.write(this.o, i3, i4);
                if (i2 < paramInt) {
                    break label93;
                }
                return;
                label73:
                i4 = i2 + 1;
                i2 = i4;
                if (i4 < paramInt) {
                    break;
                }
                i2 = i4;
            }
            label93:
            i2 += 1;
        }
    }

    private void f(int paramInt)
            throws IOException, he {
        int i3 = this.q + paramInt;
        int[] arrayOfInt = this.k;
        int i2;
        int i4;
        id localid;
        if (this.l < 1) {
            i2 = 65535;
            i4 = Math.min(arrayOfInt.length, i2 + 1);
            localid = this.m;
            label42:
            if (this.q >= i3) {
            }
        } else {
            label171:
            do {
                int i1 = this.o[this.q];
                if (i1 < i4) {
                    paramInt = arrayOfInt[i1];
                    if (paramInt == 0) {
                    }
                } else {
                    for (; ; ) {
                        int i5 = this.q - this.p;
                        if (i5 > 0) {
                            this.j.write(this.o, this.p, i5);
                        }
                        this.q += 1;
                        a(i1, paramInt);
                        break label42;
                        i2 = this.l;
                        break;
                        if (i1 > i2) {
                            paramInt = -1;
                        } else {
                            hp localhp = localid.a(i1);
                            this.n = localhp;
                            if (localhp == null) {
                                break label171;
                            }
                            paramInt = -2;
                        }
                    }
                }
                paramInt = this.q + 1;
                this.q = paramInt;
            } while (paramInt < i3);
        }
    }

    private final void g(int paramInt)
            throws IOException, he {
        int i3 = 0;
        int[] arrayOfInt = this.k;
        int i4;
        int i8;
        id localid;
        int i5;
        int i2;
        if (this.l < 1) {
            i4 = 65535;
            i8 = Math.min(arrayOfInt.length, this.l + 1);
            localid = this.m;
            i5 = 0;
            i2 = 0;
        }
        for (; ; ) {
            int i7;
            label55:
            int i1;
            if (i3 < paramInt) {
                i7 = i2;
                i1 = this.o[i3];
                if (i1 >= i8) {
                    break label121;
                }
                i2 = arrayOfInt[i1];
                if (i2 == 0) {
                    break label160;
                }
            }
            for (; ; ) {
                int i6 = i3 - i5;
                if (i6 <= 0) {
                    break label186;
                }
                this.j.write(this.o, i5, i6);
                if (i3 < paramInt) {
                    break label186;
                }
                return;
                i4 = this.l;
                break;
                label121:
                if (i1 > i4) {
                    i2 = -1;
                } else {
                    hp localhp = localid.a(i1);
                    this.n = localhp;
                    i2 = i7;
                    if (localhp != null) {
                        i2 = -2;
                    } else {
                        label160:
                        i6 = i3 + 1;
                        i7 = i2;
                        i3 = i6;
                        if (i6 < paramInt) {
                            break label55;
                        }
                        i3 = i6;
                    }
                }
            }
            label186:
            i3 += 1;
            i5 = a(this.o, i3, paramInt, i1, i2);
        }
    }

    private void j(String paramString)
            throws IOException, he {
        int i2 = this.r - this.q;
        paramString.getChars(0, i2, this.o, this.q);
        this.q += i2;
        o();
        int i1 = paramString.length() - i2;
        while (i1 > this.r) {
            int i3 = this.r;
            paramString.getChars(i2, i2 + i3, this.o, 0);
            this.p = 0;
            this.q = i3;
            o();
            i2 += i3;
            i1 -= i3;
        }
        paramString.getChars(i2, i2 + i1, this.o, 0);
        this.p = 0;
        this.q = i1;
    }

    private void k(String paramString)
            throws IOException, he {
        int i1 = paramString.length();
        if (i1 > this.r) {
            l(paramString);
            return;
        }
        if (this.q + i1 > this.r) {
            o();
        }
        paramString.getChars(0, i1, this.o, this.q);
        if (this.m != null) {
            f(i1);
            return;
        }
        if (this.l != 0) {
            a(i1, this.l);
            return;
        }
        d(i1);
    }

    private void l(String paramString)
            throws IOException, he {
        o();
        int i4 = paramString.length();
        int i1 = 0;
        int i3 = this.r;
        int i2 = i3;
        if (i1 + i3 > i4) {
            i2 = i4 - i1;
        }
        paramString.getChars(i1, i1 + i2, this.o, 0);
        if (this.m != null) {
            g(i2);
        }
        for (; ; ) {
            i2 = i1 + i2;
            i1 = i2;
            if (i2 < i4) {
                break;
            }
            return;
            if (this.l != 0) {
                b(i2, this.l);
            } else {
                e(i2);
            }
        }
    }

    private final void p()
            throws IOException {
        if (this.q + 4 >= this.r) {
            o();
        }
        int i1 = this.q;
        char[] arrayOfChar = this.o;
        arrayOfChar[i1] = 'n';
        i1 += 1;
        arrayOfChar[i1] = 'u';
        i1 += 1;
        arrayOfChar[i1] = 'l';
        i1 += 1;
        arrayOfChar[i1] = 'l';
        this.q = (i1 + 1);
    }

    private char[] q() {
        char[] arrayOfChar = new char[14];
        arrayOfChar[0] = '\\';
        arrayOfChar[2] = '\\';
        arrayOfChar[3] = 'u';
        arrayOfChar[4] = '0';
        arrayOfChar[5] = '0';
        arrayOfChar[8] = '\\';
        arrayOfChar[9] = 'u';
        this.s = arrayOfChar;
        return arrayOfChar;
    }

    public hf a(int paramInt) {
        int i1 = paramInt;
        if (paramInt < 0) {
            i1 = 0;
        }
        this.l = i1;
        return this;
    }

    public hf a(id paramid) {
        this.m = paramid;
        if (paramid == null) {
            this.k = h;
            return this;
        }
        this.k = paramid.a();
        return this;
    }

    public void a(char paramChar)
            throws IOException, he {
        if (this.q >= this.r) {
            o();
        }
        char[] arrayOfChar = this.o;
        int i1 = this.q;
        this.q = (i1 + 1);
        arrayOfChar[i1] = paramChar;
    }

    public void a(double paramDouble)
            throws IOException, he {
        if ((this.d) || (((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble))) && (a(hf.a.d)))) {
            b(String.valueOf(paramDouble));
            return;
        }
        h("write number");
        c(String.valueOf(paramDouble));
    }

    public void a(float paramFloat)
            throws IOException, he {
        if ((this.d) || (((Float.isNaN(paramFloat)) || (Float.isInfinite(paramFloat))) && (a(hf.a.d)))) {
            b(String.valueOf(paramFloat));
            return;
        }
        h("write number");
        c(String.valueOf(paramFloat));
    }

    public void a(long paramLong)
            throws IOException, he {
        h("write number");
        if (this.d) {
            b(paramLong);
            return;
        }
        if (this.q + 21 >= this.r) {
            o();
        }
        this.q = ij.a(paramLong, this.o, this.q);
    }

    public void a(ha paramha, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
            throws IOException, he {
        h("write binary value");
        if (this.q >= this.r) {
            o();
        }
        char[] arrayOfChar = this.o;
        int i1 = this.q;
        this.q = (i1 + 1);
        arrayOfChar[i1] = '"';
        b(paramha, paramArrayOfByte, paramInt1, paramInt1 + paramInt2);
        if (this.q >= this.r) {
            o();
        }
        paramha = this.o;
        paramInt1 = this.q;
        this.q = (paramInt1 + 1);
        paramha[paramInt1] = 34;
    }

    public final void a(hp paramhp)
            throws IOException, he {
        boolean bool = true;
        int i1 = this.e.a(paramhp.a());
        if (i1 == 4) {
            i("Can not write a field name, expecting a value");
        }
        if (i1 == 1) {
        }
        for (; ; ) {
            a(paramhp, bool);
            return;
            bool = false;
        }
    }

    public void a(hp paramhp, boolean paramBoolean)
            throws IOException, he {
        if (this.a != null) {
            b(paramhp, paramBoolean);
            return;
        }
        if (this.q + 1 >= this.r) {
            o();
        }
        if (paramBoolean) {
            arrayOfChar = this.o;
            i1 = this.q;
            this.q = (i1 + 1);
            arrayOfChar[i1] = ',';
        }
        paramhp = paramhp.b();
        if (!a(hf.a.c)) {
            b(paramhp, 0, paramhp.length);
            return;
        }
        char[] arrayOfChar = this.o;
        int i1 = this.q;
        this.q = (i1 + 1);
        arrayOfChar[i1] = '"';
        i1 = paramhp.length;
        if (this.q + i1 + 1 >= this.r) {
            b(paramhp, 0, i1);
            if (this.q >= this.r) {
                o();
            }
            paramhp = this.o;
            i1 = this.q;
            this.q = (i1 + 1);
            paramhp[i1] = 34;
            return;
        }
        System.arraycopy(paramhp, 0, this.o, this.q, i1);
        this.q += i1;
        paramhp = this.o;
        i1 = this.q;
        this.q = (i1 + 1);
        paramhp[i1] = 34;
    }

    public final void a(im paramim)
            throws IOException, he {
        boolean bool = true;
        int i1 = this.e.a(paramim.a());
        if (i1 == 4) {
            i("Can not write a field name, expecting a value");
        }
        if (i1 == 1) {
        }
        for (; ; ) {
            a(paramim, bool);
            return;
            bool = false;
        }
    }

    public final void a(String paramString)
            throws IOException, he {
        boolean bool = true;
        int i1 = this.e.a(paramString);
        if (i1 == 4) {
            i("Can not write a field name, expecting a value");
        }
        if (i1 == 1) {
        }
        for (; ; ) {
            b(paramString, bool);
            return;
            bool = false;
        }
    }

    public final void a(String paramString1, String paramString2)
            throws IOException, he {
        a(paramString1);
        b(paramString2);
    }

    public void a(BigDecimal paramBigDecimal)
            throws IOException, he {
        h("write number");
        if (paramBigDecimal == null) {
            p();
            return;
        }
        if (this.d) {
            c(paramBigDecimal);
            return;
        }
        c(paramBigDecimal.toString());
    }

    public void a(BigInteger paramBigInteger)
            throws IOException, he {
        h("write number");
        if (paramBigInteger == null) {
            p();
            return;
        }
        if (this.d) {
            c(paramBigInteger);
            return;
        }
        c(paramBigInteger.toString());
    }

    public void a(boolean paramBoolean)
            throws IOException, he {
        h("write boolean value");
        if (this.q + 5 >= this.r) {
            o();
        }
        int i1 = this.q;
        char[] arrayOfChar = this.o;
        if (paramBoolean) {
            arrayOfChar[i1] = 't';
            i1 += 1;
            arrayOfChar[i1] = 'r';
            i1 += 1;
            arrayOfChar[i1] = 'u';
            i1 += 1;
            arrayOfChar[i1] = 'e';
        }
        for (; ; ) {
            this.q = (i1 + 1);
            return;
            arrayOfChar[i1] = 'f';
            i1 += 1;
            arrayOfChar[i1] = 'a';
            i1 += 1;
            arrayOfChar[i1] = 'l';
            i1 += 1;
            arrayOfChar[i1] = 's';
            i1 += 1;
            arrayOfChar[i1] = 'e';
        }
    }

    public void a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws IOException, he {
        h("write text value");
        if (this.q >= this.r) {
            o();
        }
        char[] arrayOfChar = this.o;
        int i1 = this.q;
        this.q = (i1 + 1);
        arrayOfChar[i1] = '"';
        c(paramArrayOfChar, paramInt1, paramInt2);
        if (this.q >= this.r) {
            o();
        }
        paramArrayOfChar = this.o;
        paramInt1 = this.q;
        this.q = (paramInt1 + 1);
        paramArrayOfChar[paramInt1] = '"';
    }

    public final void b()
            throws IOException, he {
        h("start an array");
        this.e = this.e.h();
        if (this.a != null) {
            this.a.e(this);
            return;
        }
        if (this.q >= this.r) {
            o();
        }
        char[] arrayOfChar = this.o;
        int i1 = this.q;
        this.q = (i1 + 1);
        arrayOfChar[i1] = '[';
    }

    public void b(int paramInt)
            throws IOException, he {
        h("write number");
        if (this.d) {
            c(paramInt);
            return;
        }
        if (this.q + 11 >= this.r) {
            o();
        }
        this.q = ij.a(paramInt, this.o, this.q);
    }

    protected void b(ha paramha, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
            throws IOException, he {
        int i4 = this.r - 6;
        int i2 = paramha.c() >> 2;
        int i1 = paramInt1;
        paramInt1 = i2;
        int i3;
        while (i1 <= paramInt2 - 3) {
            if (this.q > i4) {
                o();
            }
            i2 = i1 + 1;
            i1 = paramArrayOfByte[i1];
            i3 = i2 + 1;
            int i5 = paramArrayOfByte[i2];
            i2 = i3 + 1;
            this.q = paramha.a((i5 & 0xFF | i1 << 8) << 8 | paramArrayOfByte[i3] & 0xFF, this.o, this.q);
            i3 = paramInt1 - 1;
            paramInt1 = i3;
            i1 = i2;
            if (i3 <= 0) {
                char[] arrayOfChar = this.o;
                paramInt1 = this.q;
                this.q = (paramInt1 + 1);
                arrayOfChar[paramInt1] = '\\';
                arrayOfChar = this.o;
                paramInt1 = this.q;
                this.q = (paramInt1 + 1);
                arrayOfChar[paramInt1] = 'n';
                paramInt1 = paramha.c() >> 2;
                i1 = i2;
            }
        }
        i2 = paramInt2 - i1;
        if (i2 > 0) {
            if (this.q > i4) {
                o();
            }
            i3 = i1 + 1;
            paramInt2 = paramArrayOfByte[i1] << 16;
            paramInt1 = paramInt2;
            if (i2 == 2) {
                paramInt1 = paramInt2 | (paramArrayOfByte[i3] & 0xFF) << 8;
            }
            this.q = paramha.a(paramInt1, i2, this.o, this.q);
        }
    }

    public final void b(hp paramhp)
            throws IOException, he {
        h("write text value");
        if (this.q >= this.r) {
            o();
        }
        char[] arrayOfChar = this.o;
        int i1 = this.q;
        this.q = (i1 + 1);
        arrayOfChar[i1] = '"';
        paramhp = paramhp.b();
        i1 = paramhp.length;
        if (i1 < 32) {
            if (i1 > this.r - this.q) {
                o();
            }
            System.arraycopy(paramhp, 0, this.o, this.q, i1);
            this.q += i1;
        }
        for (; ; ) {
            if (this.q >= this.r) {
                o();
            }
            paramhp = this.o;
            i1 = this.q;
            this.q = (i1 + 1);
            paramhp[i1] = 34;
            return;
            o();
            this.j.write(paramhp, 0, i1);
        }
    }

    protected final void b(hp paramhp, boolean paramBoolean)
            throws IOException, he {
        if (paramBoolean) {
            this.a.c(this);
        }
        for (; ; ) {
            paramhp = paramhp.b();
            if (!a(hf.a.c)) {
                break;
            }
            if (this.q >= this.r) {
                o();
            }
            char[] arrayOfChar = this.o;
            int i1 = this.q;
            this.q = (i1 + 1);
            arrayOfChar[i1] = '"';
            b(paramhp, 0, paramhp.length);
            if (this.q >= this.r) {
                o();
            }
            paramhp = this.o;
            i1 = this.q;
            this.q = (i1 + 1);
            paramhp[i1] = 34;
            return;
            this.a.h(this);
        }
        b(paramhp, 0, paramhp.length);
    }

    public void b(String paramString)
            throws IOException, he {
        h("write text value");
        if (paramString == null) {
            p();
            return;
        }
        if (this.q >= this.r) {
            o();
        }
        char[] arrayOfChar = this.o;
        int i1 = this.q;
        this.q = (i1 + 1);
        arrayOfChar[i1] = '"';
        k(paramString);
        if (this.q >= this.r) {
            o();
        }
        paramString = this.o;
        i1 = this.q;
        this.q = (i1 + 1);
        paramString[i1] = 34;
    }

    protected final void b(String paramString, int paramInt)
            throws IOException, he {
        switch (paramInt) {
            default:
                m();
        }
        do {
            return;
            this.a.f(this);
            return;
            this.a.d(this);
            return;
            this.a.a(this);
            return;
            if (this.e.a()) {
                this.a.g(this);
                return;
            }
        } while (!this.e.c());
        this.a.h(this);
    }

    protected void b(String paramString, boolean paramBoolean)
            throws IOException, he {
        if (this.a != null) {
            c(paramString, paramBoolean);
            return;
        }
        if (this.q + 1 >= this.r) {
            o();
        }
        if (paramBoolean) {
            arrayOfChar = this.o;
            i1 = this.q;
            this.q = (i1 + 1);
            arrayOfChar[i1] = ',';
        }
        if (!a(hf.a.c)) {
            k(paramString);
            return;
        }
        char[] arrayOfChar = this.o;
        int i1 = this.q;
        this.q = (i1 + 1);
        arrayOfChar[i1] = '"';
        k(paramString);
        if (this.q >= this.r) {
            o();
        }
        paramString = this.o;
        i1 = this.q;
        this.q = (i1 + 1);
        paramString[i1] = 34;
    }

    public void b(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws IOException, he {
        if (paramInt2 < 32) {
            if (paramInt2 > this.r - this.q) {
                o();
            }
            System.arraycopy(paramArrayOfChar, paramInt1, this.o, this.q, paramInt2);
            this.q += paramInt2;
            return;
        }
        o();
        this.j.write(paramArrayOfChar, paramInt1, paramInt2);
    }

    public final void c()
            throws IOException, he {
        if (!this.e.a()) {
            i("Current context not an ARRAY but " + this.e.d());
        }
        if (this.a != null) {
            this.a.b(this, this.e.e());
        }
        for (; ; ) {
            this.e = this.e.j();
            return;
            if (this.q >= this.r) {
                o();
            }
            char[] arrayOfChar = this.o;
            int i1 = this.q;
            this.q = (i1 + 1);
            arrayOfChar[i1] = ']';
        }
    }

    public void c(String paramString)
            throws IOException, he {
        int i3 = paramString.length();
        int i2 = this.r - this.q;
        int i1 = i2;
        if (i2 == 0) {
            o();
            i1 = this.r - this.q;
        }
        if (i1 >= i3) {
            paramString.getChars(0, i3, this.o, this.q);
            this.q += i3;
            return;
        }
        j(paramString);
    }

    protected final void c(String paramString, boolean paramBoolean)
            throws IOException, he {
        if (paramBoolean) {
            this.a.c(this);
        }
        while (a(hf.a.c)) {
            if (this.q >= this.r) {
                o();
            }
            char[] arrayOfChar = this.o;
            int i1 = this.q;
            this.q = (i1 + 1);
            arrayOfChar[i1] = '"';
            k(paramString);
            if (this.q >= this.r) {
                o();
            }
            paramString = this.o;
            i1 = this.q;
            this.q = (i1 + 1);
            paramString[i1] = 34;
            return;
            this.a.h(this);
        }
        k(paramString);
    }

    public void close()
            throws IOException {
        super.close();
        if ((this.o != null) && (a(hf.a.b))) {
            for (; ; ) {
                hx localhx = h();
                if (localhx.a()) {
                    c();
                } else {
                    if (!localhx.c()) {
                        break;
                    }
                    e();
                }
            }
        }
        o();
        if (this.j != null) {
            if ((!this.i.c()) && (!a(hf.a.a))) {
                break label97;
            }
            this.j.close();
        }
        for (; ; ) {
            n();
            return;
            label97:
            if (a(hf.a.f)) {
                this.j.flush();
            }
        }
    }

    public final void d()
            throws IOException, he {
        h("start an object");
        this.e = this.e.i();
        if (this.a != null) {
            this.a.b(this);
            return;
        }
        if (this.q >= this.r) {
            o();
        }
        char[] arrayOfChar = this.o;
        int i1 = this.q;
        this.q = (i1 + 1);
        arrayOfChar[i1] = '{';
    }

    public final void e()
            throws IOException, he {
        if (!this.e.c()) {
            i("Current context not an object but " + this.e.d());
        }
        this.e = this.e.j();
        if (this.a != null) {
            this.a.a(this, this.e.e());
            return;
        }
        if (this.q >= this.r) {
            o();
        }
        char[] arrayOfChar = this.o;
        int i1 = this.q;
        this.q = (i1 + 1);
        arrayOfChar[i1] = '}';
    }

    public void e(String paramString)
            throws IOException, he {
        h("write number");
        if (this.d) {
            c(paramString);
            return;
        }
        c(paramString);
    }

    public void f()
            throws IOException, he {
        h("write null value");
        p();
    }

    public final void g()
            throws IOException {
        o();
        if ((this.j != null) && (a(hf.a.f))) {
            this.j.flush();
        }
    }

    protected final void h(String paramString)
            throws IOException, he {
        int i2 = this.e.k();
        if (i2 == 5) {
            i("Can not " + paramString + ", expecting field name");
        }
        if (this.a == null) {
            int i1;
            switch (i2) {
                default:
                    return;
                case 1:
                    i1 = 44;
            }
            for (; ; ) {
                if (this.q >= this.r) {
                    o();
                }
                this.o[this.q] = i1;
                this.q += 1;
                return;
                i1 = 58;
                continue;
                i1 = 32;
            }
        }
        b(paramString, i2);
    }

    protected void n() {
        char[] arrayOfChar = this.o;
        if (arrayOfChar != null) {
            this.o = null;
            this.i.b(arrayOfChar);
        }
    }

    protected final void o()
            throws IOException {
        int i1 = this.q - this.p;
        if (i1 > 0) {
            int i2 = this.p;
            this.p = 0;
            this.q = 0;
            this.j.write(this.o, i2, i1);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */