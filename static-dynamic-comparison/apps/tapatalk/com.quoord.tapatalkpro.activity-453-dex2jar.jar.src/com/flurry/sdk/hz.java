package com.flurry.sdk;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class hz
        extends ht {
    static final byte[] g = ;
    protected static final int[] h = sk.f();
    private static final byte[] u = {110, 117, 108, 108};
    private static final byte[] v = {116, 114, 117, 101};
    private static final byte[] w = {102, 97, 108, 115, 101};
    protected final ie i;
    protected final OutputStream j;
    protected int[] k = h;
    protected int l;
    protected id m;
    protected byte[] n;
    protected int o = 0;
    protected final int p;
    protected final int q;
    protected char[] r;
    protected final int s;
    protected boolean t;

    public hz(ie paramie, int paramInt, hn paramhn, OutputStream paramOutputStream) {
        super(paramInt, paramhn);
        this.i = paramie;
        this.j = paramOutputStream;
        this.t = true;
        this.n = paramie.f();
        this.p = this.n.length;
        this.q = (this.p >> 3);
        this.r = paramie.h();
        this.s = this.r.length;
        if (a(hf.a.g)) {
            a(127);
        }
    }

    private final int a(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
            throws IOException {
        if ((paramInt1 >= 55296) && (paramInt1 <= 57343)) {
            if (paramInt2 >= paramInt3) {
                i("Split surrogate on writeRaw() input (last character)");
            }
            a(paramInt1, paramArrayOfChar[paramInt2]);
            return paramInt2 + 1;
        }
        paramArrayOfChar = this.n;
        paramInt3 = this.o;
        this.o = (paramInt3 + 1);
        paramArrayOfChar[paramInt3] = ((byte) (paramInt1 >> 12 | 0xE0));
        paramInt3 = this.o;
        this.o = (paramInt3 + 1);
        paramArrayOfChar[paramInt3] = ((byte) (paramInt1 >> 6 & 0x3F | 0x80));
        paramInt3 = this.o;
        this.o = (paramInt3 + 1);
        paramArrayOfChar[paramInt3] = ((byte) (paramInt1 & 0x3F | 0x80));
        return paramInt2;
    }

    private int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
            throws IOException, he {
        int i2 = paramArrayOfByte2.length;
        int i1;
        if (paramInt1 + i2 > paramInt2) {
            this.o = paramInt1;
            o();
            i1 = this.o;
            if (i2 > paramArrayOfByte1.length) {
                this.j.write(paramArrayOfByte2, 0, i2);
                return i1;
            }
            System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, i1, i2);
            paramInt1 = i1 + i2;
        }
        for (; ; ) {
            i1 = paramInt1;
            if (paramInt3 * 6 + paramInt1 <= paramInt2) {
                break;
            }
            o();
            return this.o;
        }
    }

    private int a(byte[] paramArrayOfByte, int paramInt1, hp paramhp, int paramInt2)
            throws IOException, he {
        paramhp = paramhp.c();
        int i1 = paramhp.length;
        if (i1 > 6) {
            return a(paramArrayOfByte, paramInt1, this.p, paramhp, paramInt2);
        }
        System.arraycopy(paramhp, 0, paramArrayOfByte, paramInt1, i1);
        return i1 + paramInt1;
    }

    private final void b(long paramLong)
            throws IOException {
        if (this.o + 23 >= this.p) {
            o();
        }
        byte[] arrayOfByte = this.n;
        int i1 = this.o;
        this.o = (i1 + 1);
        arrayOfByte[i1] = 34;
        this.o = ij.a(paramLong, this.n, this.o);
        arrayOfByte = this.n;
        i1 = this.o;
        this.o = (i1 + 1);
        arrayOfByte[i1] = 34;
    }

    private final void b(byte[] paramArrayOfByte)
            throws IOException {
        int i1 = paramArrayOfByte.length;
        if (this.o + i1 > this.p) {
            o();
            if (i1 > 512) {
                this.j.write(paramArrayOfByte, 0, i1);
                return;
            }
        }
        System.arraycopy(paramArrayOfByte, 0, this.n, this.o, i1);
        this.o = (i1 + this.o);
    }

    private final int c(int paramInt1, int paramInt2)
            throws IOException {
        byte[] arrayOfByte = this.n;
        if ((paramInt1 >= 55296) && (paramInt1 <= 57343)) {
            i1 = paramInt2 + 1;
            arrayOfByte[paramInt2] = 92;
            paramInt2 = i1 + 1;
            arrayOfByte[i1] = 117;
            i1 = paramInt2 + 1;
            arrayOfByte[paramInt2] = g[(paramInt1 >> 12 & 0xF)];
            paramInt2 = i1 + 1;
            arrayOfByte[i1] = g[(paramInt1 >> 8 & 0xF)];
            i1 = paramInt2 + 1;
            arrayOfByte[paramInt2] = g[(paramInt1 >> 4 & 0xF)];
            arrayOfByte[i1] = g[(paramInt1 & 0xF)];
            return i1 + 1;
        }
        int i1 = paramInt2 + 1;
        arrayOfByte[paramInt2] = ((byte) (paramInt1 >> 12 | 0xE0));
        paramInt2 = i1 + 1;
        arrayOfByte[i1] = ((byte) (paramInt1 >> 6 & 0x3F | 0x80));
        arrayOfByte[paramInt2] = ((byte) (paramInt1 & 0x3F | 0x80));
        return paramInt2 + 1;
    }

    private final void c(int paramInt)
            throws IOException {
        if (this.o + 13 >= this.p) {
            o();
        }
        byte[] arrayOfByte = this.n;
        int i1 = this.o;
        this.o = (i1 + 1);
        arrayOfByte[i1] = 34;
        this.o = ij.a(paramInt, this.n, this.o);
        arrayOfByte = this.n;
        paramInt = this.o;
        this.o = (paramInt + 1);
        arrayOfByte[paramInt] = 34;
    }

    private final void c(Object paramObject)
            throws IOException {
        if (this.o >= this.p) {
            o();
        }
        byte[] arrayOfByte = this.n;
        int i1 = this.o;
        this.o = (i1 + 1);
        arrayOfByte[i1] = 34;
        c(paramObject.toString());
        if (this.o >= this.p) {
            o();
        }
        paramObject = this.n;
        i1 = this.o;
        this.o = (i1 + 1);
        paramObject[i1] = 34;
    }

    private final void c(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws IOException, he {
        if (this.o >= this.p) {
            o();
        }
        paramArrayOfChar = this.n;
        paramInt1 = this.o;
        this.o = (paramInt1 + 1);
        paramArrayOfChar[paramInt1] = '"';
        e(this.r, 0, paramInt2);
        if (this.o >= this.p) {
            o();
        }
        paramArrayOfChar = this.n;
        paramInt1 = this.o;
        this.o = (paramInt1 + 1);
        paramArrayOfChar[paramInt1] = '"';
    }

    private int d(int paramInt1, int paramInt2)
            throws IOException {
        byte[] arrayOfByte = this.n;
        int i1 = paramInt2 + 1;
        arrayOfByte[paramInt2] = 92;
        paramInt2 = i1 + 1;
        arrayOfByte[i1] = 117;
        if (paramInt1 > 255) {
            i1 = paramInt1 >> 8 & 0xFF;
            int i2 = paramInt2 + 1;
            arrayOfByte[paramInt2] = g[(i1 >> 4)];
            paramInt2 = i2 + 1;
            arrayOfByte[i2] = g[(i1 & 0xF)];
            paramInt1 &= 0xFF;
        }
        for (; ; ) {
            i1 = paramInt2 + 1;
            arrayOfByte[paramInt2] = g[(paramInt1 >> 4)];
            arrayOfByte[i1] = g[(paramInt1 & 0xF)];
            return i1 + 1;
            i1 = paramInt2 + 1;
            arrayOfByte[paramInt2] = 48;
            paramInt2 = i1 + 1;
            arrayOfByte[i1] = 48;
        }
    }

    private final void d(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws IOException, he {
        int i2 = this.p;
        byte[] arrayOfByte = this.n;
        label17:
        int i1;
        int i3;
        if (paramInt1 < paramInt2) {
            i1 = paramArrayOfChar[paramInt1];
            if (i1 >= 128) {
                if (this.o + 3 >= this.p) {
                    o();
                }
                i1 = paramInt1 + 1;
                paramInt1 = paramArrayOfChar[paramInt1];
                if (paramInt1 >= 2048) {
                    break label175;
                }
                i3 = this.o;
                this.o = (i3 + 1);
                arrayOfByte[i3] = ((byte) (paramInt1 >> 6 | 0xC0));
                i3 = this.o;
                this.o = (i3 + 1);
                arrayOfByte[i3] = ((byte) (paramInt1 & 0x3F | 0x80));
            }
        }
        for (; ; ) {
            paramInt1 = i1;
            break;
            if (this.o >= i2) {
                o();
            }
            i3 = this.o;
            this.o = (i3 + 1);
            arrayOfByte[i3] = ((byte) i1);
            i1 = paramInt1 + 1;
            paramInt1 = i1;
            if (i1 < paramInt2) {
                break label17;
            }
            return;
            label175:
            a(paramInt1, paramArrayOfChar, i1, paramInt2);
        }
    }

    private final void e(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws IOException, he {
        int i1;
        do {
            i1 = Math.min(this.q, paramInt2);
            if (this.o + i1 > this.p) {
                o();
            }
            f(paramArrayOfChar, paramInt1, i1);
            paramInt1 += i1;
            i1 = paramInt2 - i1;
            paramInt2 = i1;
        } while (i1 > 0);
    }

    private final void f(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws IOException, he {
        int i2 = paramInt2 + paramInt1;
        int i1 = this.o;
        byte[] arrayOfByte = this.n;
        int[] arrayOfInt = this.k;
        paramInt2 = paramInt1;
        paramInt1 = i1;
        for (; ; ) {
            if (paramInt2 < i2) {
                i1 = paramArrayOfChar[paramInt2];
                if ((i1 <= 127) && (arrayOfInt[i1] == 0)) {
                }
            } else {
                this.o = paramInt1;
                if (paramInt2 < i2) {
                    if (this.m == null) {
                        break;
                    }
                    i(paramArrayOfChar, paramInt2, i2);
                }
                return;
            }
            arrayOfByte[paramInt1] = ((byte) i1);
            paramInt2 += 1;
            paramInt1 += 1;
        }
        if (this.l == 0) {
            g(paramArrayOfChar, paramInt2, i2);
            return;
        }
        h(paramArrayOfChar, paramInt2, i2);
    }

    private final void g(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws IOException, he {
        if (this.o + (paramInt2 - paramInt1) * 6 > this.p) {
            o();
        }
        int i2 = this.o;
        byte[] arrayOfByte = this.n;
        int[] arrayOfInt = this.k;
        int i1 = paramInt1;
        paramInt1 = i2;
        while (i1 < paramInt2) {
            i2 = i1 + 1;
            i1 = paramArrayOfChar[i1];
            int i3;
            if (i1 <= 127) {
                if (arrayOfInt[i1] == 0) {
                    arrayOfByte[paramInt1] = ((byte) i1);
                    paramInt1 += 1;
                    i1 = i2;
                } else {
                    i3 = arrayOfInt[i1];
                    if (i3 > 0) {
                        i1 = paramInt1 + 1;
                        arrayOfByte[paramInt1] = 92;
                        paramInt1 = i1 + 1;
                        arrayOfByte[i1] = ((byte) i3);
                        i1 = i2;
                    } else {
                        paramInt1 = d(i1, paramInt1);
                        i1 = i2;
                    }
                }
            } else {
                if (i1 <= 2047) {
                    i3 = paramInt1 + 1;
                    arrayOfByte[paramInt1] = ((byte) (i1 >> 6 | 0xC0));
                    paramInt1 = i3 + 1;
                    arrayOfByte[i3] = ((byte) (i1 & 0x3F | 0x80));
                }
                for (; ; ) {
                    i1 = i2;
                    break;
                    paramInt1 = c(i1, paramInt1);
                }
            }
        }
        this.o = paramInt1;
    }

    private final void h(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws IOException, he {
        if (this.o + (paramInt2 - paramInt1) * 6 > this.p) {
            o();
        }
        int i2 = this.o;
        byte[] arrayOfByte = this.n;
        int[] arrayOfInt = this.k;
        int i3 = this.l;
        int i1 = paramInt1;
        paramInt1 = i2;
        while (i1 < paramInt2) {
            i2 = i1 + 1;
            i1 = paramArrayOfChar[i1];
            int i4;
            if (i1 <= 127) {
                if (arrayOfInt[i1] == 0) {
                    arrayOfByte[paramInt1] = ((byte) i1);
                    paramInt1 += 1;
                    i1 = i2;
                } else {
                    i4 = arrayOfInt[i1];
                    if (i4 > 0) {
                        i1 = paramInt1 + 1;
                        arrayOfByte[paramInt1] = 92;
                        paramInt1 = i1 + 1;
                        arrayOfByte[i1] = ((byte) i4);
                        i1 = i2;
                    } else {
                        paramInt1 = d(i1, paramInt1);
                        i1 = i2;
                    }
                }
            } else if (i1 > i3) {
                paramInt1 = d(i1, paramInt1);
                i1 = i2;
            } else {
                if (i1 <= 2047) {
                    i4 = paramInt1 + 1;
                    arrayOfByte[paramInt1] = ((byte) (i1 >> 6 | 0xC0));
                    paramInt1 = i4 + 1;
                    arrayOfByte[i4] = ((byte) (i1 & 0x3F | 0x80));
                }
                for (; ; ) {
                    i1 = i2;
                    break;
                    paramInt1 = c(i1, paramInt1);
                }
            }
        }
        this.o = paramInt1;
    }

    private final void i(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws IOException, he {
        if (this.o + (paramInt2 - paramInt1) * 6 > this.p) {
            o();
        }
        int i2 = this.o;
        byte[] arrayOfByte = this.n;
        int[] arrayOfInt = this.k;
        int i3;
        id localid;
        int i1;
        if (this.l <= 0) {
            i3 = 65535;
            localid = this.m;
            i1 = paramInt1;
            paramInt1 = i2;
        }
        for (; ; ) {
            if (i1 < paramInt2) {
                i2 = i1 + 1;
                i1 = paramArrayOfChar[i1];
                int i4;
                hp localhp;
                if (i1 <= 127) {
                    if (arrayOfInt[i1] == 0) {
                        arrayOfByte[paramInt1] = ((byte) i1);
                        paramInt1 += 1;
                        i1 = i2;
                        continue;
                        i3 = this.l;
                        break;
                    }
                    i4 = arrayOfInt[i1];
                    if (i4 > 0) {
                        i1 = paramInt1 + 1;
                        arrayOfByte[paramInt1] = 92;
                        paramInt1 = i1 + 1;
                        arrayOfByte[i1] = ((byte) i4);
                        i1 = i2;
                        continue;
                    }
                    if (i4 == -2) {
                        localhp = localid.a(i1);
                        if (localhp == null) {
                            throw new he("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(i1) + ", although was supposed to have one");
                        }
                        paramInt1 = a(arrayOfByte, paramInt1, localhp, paramInt2 - i2);
                        i1 = i2;
                        continue;
                    }
                    paramInt1 = d(i1, paramInt1);
                    i1 = i2;
                    continue;
                }
                if (i1 > i3) {
                    paramInt1 = d(i1, paramInt1);
                    i1 = i2;
                } else {
                    localhp = localid.a(i1);
                    if (localhp != null) {
                        paramInt1 = a(arrayOfByte, paramInt1, localhp, paramInt2 - i2);
                        i1 = i2;
                    } else {
                        if (i1 <= 2047) {
                            i4 = paramInt1 + 1;
                            arrayOfByte[paramInt1] = ((byte) (i1 >> 6 | 0xC0));
                            paramInt1 = i4 + 1;
                            arrayOfByte[i4] = ((byte) (i1 & 0x3F | 0x80));
                        }
                        for (; ; ) {
                            i1 = i2;
                            break;
                            paramInt1 = c(i1, paramInt1);
                        }
                    }
                }
            }
        }
        this.o = paramInt1;
    }

    private final void k(String paramString)
            throws IOException, he {
        if (this.o >= this.p) {
            o();
        }
        byte[] arrayOfByte = this.n;
        int i1 = this.o;
        this.o = (i1 + 1);
        arrayOfByte[i1] = 34;
        l(paramString);
        if (this.o >= this.p) {
            o();
        }
        paramString = this.n;
        i1 = this.o;
        this.o = (i1 + 1);
        paramString[i1] = 34;
    }

    private final void l(String paramString)
            throws IOException, he {
        int i1 = paramString.length();
        char[] arrayOfChar = this.r;
        int i2 = 0;
        while (i1 > 0) {
            int i3 = Math.min(this.q, i1);
            paramString.getChars(i2, i2 + i3, arrayOfChar, 0);
            if (this.o + i3 > this.p) {
                o();
            }
            f(arrayOfChar, 0, i3);
            i2 += i3;
            i1 -= i3;
        }
    }

    private final void p()
            throws IOException {
        if (this.o + 4 >= this.p) {
            o();
        }
        System.arraycopy(u, 0, this.n, this.o, 4);
        this.o += 4;
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
        if (this.o + 3 >= this.p) {
            o();
        }
        byte[] arrayOfByte = this.n;
        int i1;
        if (paramChar <= '') {
            i1 = this.o;
            this.o = (i1 + 1);
            arrayOfByte[i1] = ((byte) paramChar);
            return;
        }
        if (paramChar < 'ࠀ') {
            i1 = this.o;
            this.o = (i1 + 1);
            arrayOfByte[i1] = ((byte) (paramChar >> '\006' | 0xC0));
            i1 = this.o;
            this.o = (i1 + 1);
            arrayOfByte[i1] = ((byte) (paramChar & 0x3F | 0x80));
            return;
        }
        a(paramChar, null, 0, 0);
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

    protected final void a(int paramInt1, int paramInt2)
            throws IOException {
        paramInt1 = b(paramInt1, paramInt2);
        if (this.o + 4 > this.p) {
            o();
        }
        byte[] arrayOfByte = this.n;
        paramInt2 = this.o;
        this.o = (paramInt2 + 1);
        arrayOfByte[paramInt2] = ((byte) (paramInt1 >> 18 | 0xF0));
        paramInt2 = this.o;
        this.o = (paramInt2 + 1);
        arrayOfByte[paramInt2] = ((byte) (paramInt1 >> 12 & 0x3F | 0x80));
        paramInt2 = this.o;
        this.o = (paramInt2 + 1);
        arrayOfByte[paramInt2] = ((byte) (paramInt1 >> 6 & 0x3F | 0x80));
        paramInt2 = this.o;
        this.o = (paramInt2 + 1);
        arrayOfByte[paramInt2] = ((byte) (paramInt1 & 0x3F | 0x80));
    }

    public void a(long paramLong)
            throws IOException, he {
        h("write number");
        if (this.d) {
            b(paramLong);
            return;
        }
        if (this.o + 21 >= this.p) {
            o();
        }
        this.o = ij.a(paramLong, this.n, this.o);
    }

    public void a(ha paramha, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
            throws IOException, he {
        h("write binary value");
        if (this.o >= this.p) {
            o();
        }
        byte[] arrayOfByte = this.n;
        int i1 = this.o;
        this.o = (i1 + 1);
        arrayOfByte[i1] = 34;
        b(paramha, paramArrayOfByte, paramInt1, paramInt1 + paramInt2);
        if (this.o >= this.p) {
            o();
        }
        paramha = this.n;
        paramInt1 = this.o;
        this.o = (paramInt1 + 1);
        paramha[paramInt1] = 34;
    }

    public final void a(hp paramhp)
            throws IOException, he {
        boolean bool = true;
        int i1 = this.e.a(paramhp.a());
        if (i1 == 4) {
            i("Can not write a field name, expecting a value");
        }
        if (this.a != null) {
            if (i1 == 1) {
            }
            for (; ; ) {
                a(paramhp, bool);
                return;
                bool = false;
            }
        }
        if (i1 == 1) {
            if (this.o >= this.p) {
                o();
            }
            byte[] arrayOfByte = this.n;
            i1 = this.o;
            this.o = (i1 + 1);
            arrayOfByte[i1] = 44;
        }
        c(paramhp);
    }

    protected final void a(hp paramhp, boolean paramBoolean)
            throws IOException, he {
        if (paramBoolean) {
            this.a.c(this);
        }
        for (; ; ) {
            paramBoolean = a(hf.a.c);
            int i1;
            if (paramBoolean) {
                if (this.o >= this.p) {
                    o();
                }
                byte[] arrayOfByte = this.n;
                i1 = this.o;
                this.o = (i1 + 1);
                arrayOfByte[i1] = 34;
            }
            b(paramhp.d());
            if (paramBoolean) {
                if (this.o >= this.p) {
                    o();
                }
                paramhp = this.n;
                i1 = this.o;
                this.o = (i1 + 1);
                paramhp[i1] = 34;
            }
            return;
            this.a.h(this);
        }
    }

    public final void a(im paramim)
            throws IOException, he {
        boolean bool = true;
        int i1 = this.e.a(paramim.a());
        if (i1 == 4) {
            i("Can not write a field name, expecting a value");
        }
        if (this.a != null) {
            if (i1 == 1) {
            }
            for (; ; ) {
                a(paramim, bool);
                return;
                bool = false;
            }
        }
        if (i1 == 1) {
            if (this.o >= this.p) {
                o();
            }
            byte[] arrayOfByte = this.n;
            i1 = this.o;
            this.o = (i1 + 1);
            arrayOfByte[i1] = 44;
        }
        c(paramim);
    }

    public final void a(String paramString)
            throws IOException, he {
        boolean bool = true;
        int i1 = this.e.a(paramString);
        if (i1 == 4) {
            i("Can not write a field name, expecting a value");
        }
        if (this.a != null) {
            if (i1 == 1) {
            }
            for (; ; ) {
                b(paramString, bool);
                return;
                bool = false;
            }
        }
        if (i1 == 1) {
            if (this.o >= this.p) {
                o();
            }
            byte[] arrayOfByte = this.n;
            i1 = this.o;
            this.o = (i1 + 1);
            arrayOfByte[i1] = 44;
        }
        j(paramString);
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
        if (this.o + 5 >= this.p) {
            o();
        }
        if (paramBoolean) {
        }
        for (byte[] arrayOfByte = v; ; arrayOfByte = w) {
            int i1 = arrayOfByte.length;
            System.arraycopy(arrayOfByte, 0, this.n, this.o, i1);
            this.o += i1;
            return;
        }
    }

    public void a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws IOException, he {
        h("write text value");
        if (this.o >= this.p) {
            o();
        }
        byte[] arrayOfByte = this.n;
        int i1 = this.o;
        this.o = (i1 + 1);
        arrayOfByte[i1] = 34;
        if (paramInt2 <= this.q) {
            if (this.o + paramInt2 > this.p) {
                o();
            }
            f(paramArrayOfChar, paramInt1, paramInt2);
        }
        for (; ; ) {
            if (this.o >= this.p) {
                o();
            }
            paramArrayOfChar = this.n;
            paramInt1 = this.o;
            this.o = (paramInt1 + 1);
            paramArrayOfChar[paramInt1] = '"';
            return;
            e(paramArrayOfChar, paramInt1, paramInt2);
        }
    }

    protected final int b(int paramInt1, int paramInt2)
            throws IOException {
        if ((paramInt2 < 56320) || (paramInt2 > 57343)) {
            i("Incomplete surrogate pair: first char 0x" + Integer.toHexString(paramInt1) + ", second 0x" + Integer.toHexString(paramInt2));
        }
        return 65536 + (paramInt1 - 55296 << 10) + (paramInt2 - 56320);
    }

    public final void b()
            throws IOException, he {
        h("start an array");
        this.e = this.e.h();
        if (this.a != null) {
            this.a.e(this);
            return;
        }
        if (this.o >= this.p) {
            o();
        }
        byte[] arrayOfByte = this.n;
        int i1 = this.o;
        this.o = (i1 + 1);
        arrayOfByte[i1] = 91;
    }

    public void b(int paramInt)
            throws IOException, he {
        h("write number");
        if (this.o + 11 >= this.p) {
            o();
        }
        if (this.d) {
            c(paramInt);
            return;
        }
        this.o = ij.a(paramInt, this.n, this.o);
    }

    protected void b(ha paramha, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
            throws IOException, he {
        int i4 = this.p - 6;
        int i2 = paramha.c() >> 2;
        int i1 = paramInt1;
        paramInt1 = i2;
        int i3;
        while (i1 <= paramInt2 - 3) {
            if (this.o > i4) {
                o();
            }
            i2 = i1 + 1;
            i1 = paramArrayOfByte[i1];
            i3 = i2 + 1;
            int i5 = paramArrayOfByte[i2];
            i2 = i3 + 1;
            this.o = paramha.a((i5 & 0xFF | i1 << 8) << 8 | paramArrayOfByte[i3] & 0xFF, this.n, this.o);
            i3 = paramInt1 - 1;
            paramInt1 = i3;
            i1 = i2;
            if (i3 <= 0) {
                byte[] arrayOfByte = this.n;
                paramInt1 = this.o;
                this.o = (paramInt1 + 1);
                arrayOfByte[paramInt1] = 92;
                arrayOfByte = this.n;
                paramInt1 = this.o;
                this.o = (paramInt1 + 1);
                arrayOfByte[paramInt1] = 110;
                paramInt1 = paramha.c() >> 2;
                i1 = i2;
            }
        }
        i2 = paramInt2 - i1;
        if (i2 > 0) {
            if (this.o > i4) {
                o();
            }
            i3 = i1 + 1;
            paramInt2 = paramArrayOfByte[i1] << 16;
            paramInt1 = paramInt2;
            if (i2 == 2) {
                paramInt1 = paramInt2 | (paramArrayOfByte[i3] & 0xFF) << 8;
            }
            this.o = paramha.a(paramInt1, i2, this.n, this.o);
        }
    }

    public final void b(hp paramhp)
            throws IOException, he {
        h("write text value");
        if (this.o >= this.p) {
            o();
        }
        byte[] arrayOfByte = this.n;
        int i1 = this.o;
        this.o = (i1 + 1);
        arrayOfByte[i1] = 34;
        b(paramhp.d());
        if (this.o >= this.p) {
            o();
        }
        paramhp = this.n;
        i1 = this.o;
        this.o = (i1 + 1);
        paramhp[i1] = 34;
    }

    public void b(String paramString)
            throws IOException, he {
        h("write text value");
        if (paramString == null) {
            p();
            return;
        }
        int i1 = paramString.length();
        if (i1 > this.s) {
            k(paramString);
            return;
        }
        paramString.getChars(0, i1, this.r, 0);
        if (i1 > this.q) {
            c(this.r, 0, i1);
            return;
        }
        if (this.o + i1 >= this.p) {
            o();
        }
        paramString = this.n;
        int i2 = this.o;
        this.o = (i2 + 1);
        paramString[i2] = 34;
        f(this.r, 0, i1);
        if (this.o >= this.p) {
            o();
        }
        paramString = this.n;
        i1 = this.o;
        this.o = (i1 + 1);
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

    protected final void b(String paramString, boolean paramBoolean)
            throws IOException, he {
        int i1;
        if (paramBoolean) {
            this.a.c(this);
            if (!a(hf.a.c)) {
                break label194;
            }
            if (this.o >= this.p) {
                o();
            }
            byte[] arrayOfByte = this.n;
            i1 = this.o;
            this.o = (i1 + 1);
            arrayOfByte[i1] = 34;
            i1 = paramString.length();
            if (i1 > this.s) {
                break label186;
            }
            paramString.getChars(0, i1, this.r, 0);
            if (i1 > this.q) {
                break label173;
            }
            if (this.o + i1 > this.p) {
                o();
            }
            f(this.r, 0, i1);
        }
        for (; ; ) {
            if (this.o >= this.p) {
                o();
            }
            paramString = this.n;
            i1 = this.o;
            this.o = (i1 + 1);
            paramString[i1] = 34;
            return;
            this.a.h(this);
            break;
            label173:
            e(this.r, 0, i1);
            continue;
            label186:
            l(paramString);
        }
        label194:
        l(paramString);
    }

    public final void b(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws IOException, he {
        int i1 = paramInt2 + paramInt2 + paramInt2;
        if (this.o + i1 > this.p) {
            if (this.p < i1) {
                d(paramArrayOfChar, paramInt1, paramInt2);
                return;
            }
            o();
        }
        i1 = paramInt2 + paramInt1;
        label47:
        label53:
        byte[] arrayOfByte;
        int i2;
        if (paramInt1 < i1) {
            paramInt2 = paramArrayOfChar[paramInt1];
            if (paramInt2 <= 127) {
                break label151;
            }
            paramInt2 = paramInt1 + 1;
            paramInt1 = paramArrayOfChar[paramInt1];
            if (paramInt1 >= 2048) {
                break label191;
            }
            arrayOfByte = this.n;
            i2 = this.o;
            this.o = (i2 + 1);
            arrayOfByte[i2] = ((byte) (paramInt1 >> 6 | 0xC0));
            arrayOfByte = this.n;
            i2 = this.o;
            this.o = (i2 + 1);
            arrayOfByte[i2] = ((byte) (paramInt1 & 0x3F | 0x80));
        }
        for (; ; ) {
            paramInt1 = paramInt2;
            break label47;
            break;
            label151:
            arrayOfByte = this.n;
            i2 = this.o;
            this.o = (i2 + 1);
            arrayOfByte[i2] = ((byte) paramInt2);
            paramInt2 = paramInt1 + 1;
            paramInt1 = paramInt2;
            if (paramInt2 < i1) {
                break label53;
            }
            return;
            label191:
            a(paramInt1, paramArrayOfChar, paramInt2, i1);
        }
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
            if (this.o >= this.p) {
                o();
            }
            byte[] arrayOfByte = this.n;
            int i1 = this.o;
            this.o = (i1 + 1);
            arrayOfByte[i1] = 93;
        }
    }

    protected final void c(hp paramhp)
            throws IOException, he {
        paramhp = paramhp.d();
        if (!a(hf.a.c)) {
            b(paramhp);
            return;
        }
        if (this.o >= this.p) {
            o();
        }
        byte[] arrayOfByte = this.n;
        int i1 = this.o;
        this.o = (i1 + 1);
        arrayOfByte[i1] = 34;
        i1 = paramhp.length;
        if (this.o + i1 + 1 < this.p) {
            System.arraycopy(paramhp, 0, this.n, this.o, i1);
            this.o += i1;
            paramhp = this.n;
            i1 = this.o;
            this.o = (i1 + 1);
            paramhp[i1] = 34;
            return;
        }
        b(paramhp);
        if (this.o >= this.p) {
            o();
        }
        paramhp = this.n;
        i1 = this.o;
        this.o = (i1 + 1);
        paramhp[i1] = 34;
    }

    public void c(String paramString)
            throws IOException, he {
        int i1 = paramString.length();
        int i2 = 0;
        while (i1 > 0) {
            char[] arrayOfChar = this.r;
            int i4 = arrayOfChar.length;
            int i3 = i4;
            if (i1 < i4) {
                i3 = i1;
            }
            paramString.getChars(i2, i2 + i3, arrayOfChar, 0);
            b(arrayOfChar, 0, i3);
            i2 += i3;
            i1 -= i3;
        }
    }

    public void close()
            throws IOException {
        super.close();
        if ((this.n != null) && (a(hf.a.b))) {
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
        if (this.o >= this.p) {
            o();
        }
        byte[] arrayOfByte = this.n;
        int i1 = this.o;
        this.o = (i1 + 1);
        arrayOfByte[i1] = 123;
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
        if (this.o >= this.p) {
            o();
        }
        byte[] arrayOfByte = this.n;
        int i1 = this.o;
        this.o = (i1 + 1);
        arrayOfByte[i1] = 125;
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
                if (this.o >= this.p) {
                    o();
                }
                this.n[this.o] = i1;
                this.o += 1;
                return;
                i1 = 58;
                continue;
                i1 = 32;
            }
        }
        b(paramString, i2);
    }

    protected final void j(String paramString)
            throws IOException, he {
        if (!a(hf.a.c)) {
            l(paramString);
            return;
        }
        if (this.o >= this.p) {
            o();
        }
        byte[] arrayOfByte = this.n;
        int i1 = this.o;
        this.o = (i1 + 1);
        arrayOfByte[i1] = 34;
        i1 = paramString.length();
        if (i1 <= this.s) {
            paramString.getChars(0, i1, this.r, 0);
            if (i1 <= this.q) {
                if (this.o + i1 > this.p) {
                    o();
                }
                f(this.r, 0, i1);
            }
        }
        for (; ; ) {
            if (this.o >= this.p) {
                o();
            }
            paramString = this.n;
            i1 = this.o;
            this.o = (i1 + 1);
            paramString[i1] = 34;
            return;
            e(this.r, 0, i1);
            continue;
            l(paramString);
        }
    }

    protected void n() {
        Object localObject = this.n;
        if ((localObject != null) && (this.t)) {
            this.n = null;
            this.i.b((byte[]) localObject);
        }
        localObject = this.r;
        if (localObject != null) {
            this.r = null;
            this.i.b((char[]) localObject);
        }
    }

    protected final void o()
            throws IOException {
        int i1 = this.o;
        if (i1 > 0) {
            this.o = 0;
            this.j.write(this.n, 0, i1);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/hz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */