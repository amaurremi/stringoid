package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;

public final class ia
        extends hu {
    private static final int[] P = ;
    private static final int[] Q = sk.a();
    protected hn I;
    protected final sa J;
    protected int[] K = new int[16];
    protected boolean L = false;
    protected InputStream M;
    protected byte[] N;
    protected boolean O;
    private int R;

    public ia(ie paramie, int paramInt1, InputStream paramInputStream, hn paramhn, sa paramsa, byte[] paramArrayOfByte, int paramInt2, int paramInt3, boolean paramBoolean) {
        super(paramie, paramInt1);
        this.M = paramInputStream;
        this.I = paramhn;
        this.J = paramsa;
        this.N = paramArrayOfByte;
        this.f = paramInt2;
        this.g = paramInt3;
        this.O = paramBoolean;
        if (!hj.a.j.a(paramInt1)) {
            U();
        }
    }

    private final hm a(char[] paramArrayOfChar, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
            throws IOException, hi {
        int i = 0;
        int j = 0;
        int m = 0;
        int k;
        label55:
        Object localObject;
        if (paramInt2 == 46) {
            k = paramInt1 + 1;
            paramArrayOfChar[paramInt1] = ((char) paramInt2);
            j = paramInt2;
            paramInt1 = k;
            paramInt2 = i;
            if ((this.f >= this.g) && (!E())) {
                i = 1;
                if (paramInt2 == 0) {
                    a(j, "Decimal point not followed by a digit");
                }
                k = paramInt2;
                paramInt2 = j;
                localObject = paramArrayOfChar;
            }
        }
        for (; ; ) {
            label196:
            label251:
            label335:
            int n;
            int i1;
            if ((paramInt2 == 101) || (paramInt2 == 69)) {
                j = paramInt1;
                paramArrayOfChar = (char[]) localObject;
                if (paramInt1 >= localObject.length) {
                    paramArrayOfChar = this.p.m();
                    j = 0;
                }
                paramInt1 = j + 1;
                paramArrayOfChar[j] = ((char) paramInt2);
                if (this.f >= this.g) {
                    D();
                }
                localObject = this.N;
                paramInt2 = this.f;
                this.f = (paramInt2 + 1);
                j = localObject[paramInt2] & 0xFF;
                if ((j == 45) || (j == 43)) {
                    if (paramInt1 >= paramArrayOfChar.length) {
                        paramArrayOfChar = this.p.m();
                        paramInt1 = 0;
                        paramArrayOfChar[paramInt1] = ((char) j);
                        if (this.f >= this.g) {
                            D();
                        }
                        localObject = this.N;
                        paramInt2 = this.f;
                        this.f = (paramInt2 + 1);
                        j = localObject[paramInt2] & 0xFF;
                        paramInt1 += 1;
                        paramInt2 = 0;
                        if ((j <= 57) && (j >= 48)) {
                            paramInt2 += 1;
                            m = paramInt1;
                            localObject = paramArrayOfChar;
                            if (paramInt1 >= paramArrayOfChar.length) {
                                localObject = this.p.m();
                                m = 0;
                            }
                            paramInt1 = m + 1;
                            localObject[m] = ((char) j);
                            if ((this.f >= this.g) && (!E())) {
                                m = paramInt2;
                                paramInt2 = 1;
                                i = paramInt1;
                                paramInt1 = m;
                                m = paramInt1;
                                n = paramInt2;
                                i1 = i;
                                if (paramInt1 == 0) {
                                    a(j, "Exponent indicator not followed by a digit");
                                    i1 = i;
                                    n = paramInt2;
                                    m = paramInt1;
                                }
                                label367:
                                if (n == 0) {
                                    this.f -= 1;
                                }
                                this.p.a(i1);
                                return b(paramBoolean, paramInt3, k, m);
                                localObject = this.N;
                                i = this.f;
                                this.f = (i + 1);
                                k = localObject[i] & 0xFF;
                                i = m;
                                j = k;
                                if (k < 48) {
                                    break label55;
                                }
                                i = m;
                                j = k;
                                if (k > 57) {
                                    break label55;
                                }
                                paramInt2 += 1;
                                if (paramInt1 < paramArrayOfChar.length) {
                                    break label577;
                                }
                                paramArrayOfChar = this.p.m();
                                paramInt1 = 0;
                            }
                        }
                    }
                }
            }
            label577:
            for (; ; ) {
                i = paramInt1 + 1;
                paramArrayOfChar[paramInt1] = ((char) k);
                paramInt1 = i;
                j = k;
                break;
                paramArrayOfChar = this.N;
                j = this.f;
                this.f = (j + 1);
                j = paramArrayOfChar[j] & 0xFF;
                paramArrayOfChar = (char[]) localObject;
                break label251;
                m = paramInt1;
                paramInt1 = paramInt2;
                paramInt2 = i;
                i = m;
                break label335;
                break label196;
                paramInt2 = 0;
                break label251;
                m = 0;
                n = i;
                i1 = paramInt1;
                break label367;
            }
            k = 0;
            localObject = paramArrayOfChar;
            i = j;
        }
    }

    private final hm a(char[] paramArrayOfChar, int paramInt1, boolean paramBoolean, int paramInt2)
            throws IOException, hi {
        if ((this.f >= this.g) && (!E())) {
            this.p.a(paramInt1);
            return a(paramBoolean, paramInt2);
        }
        byte[] arrayOfByte = this.N;
        int i = this.f;
        this.f = (i + 1);
        int j = arrayOfByte[i] & 0xFF;
        if ((j > 57) || (j < 48)) {
            if ((j == 46) || (j == 101) || (j == 69)) {
                return a(paramArrayOfChar, paramInt1, j, paramBoolean, paramInt2);
            }
        } else {
            if (paramInt1 < paramArrayOfChar.length) {
                break label177;
            }
            paramArrayOfChar = this.p.m();
            paramInt1 = 0;
        }
        label177:
        for (; ; ) {
            i = paramInt1 + 1;
            paramArrayOfChar[paramInt1] = ((char) j);
            paramInt2 += 1;
            paramInt1 = i;
            break;
            this.f -= 1;
            this.p.a(paramInt1);
            return a(paramBoolean, paramInt2);
        }
    }

    private final sc a(int paramInt1, int paramInt2, int paramInt3)
            throws IOException, hi {
        return a(this.K, 0, paramInt1, paramInt2, paramInt3);
    }

    private final sc a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
            throws IOException, hi {
        this.K[0] = paramInt1;
        return a(this.K, 1, paramInt2, paramInt3, paramInt4);
    }

    private final sc a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
            throws hi {
        int i3 = (paramInt1 << 2) - 4 + paramInt2;
        int i2;
        Object localObject1;
        int m;
        int i;
        label49:
        int j;
        int k;
        int i1;
        int n;
        label120:
        Object localObject2;
        if (paramInt2 < 4) {
            i2 = paramArrayOfInt[(paramInt1 - 1)];
            paramArrayOfInt[(paramInt1 - 1)] = (i2 << (4 - paramInt2 << 3));
            localObject1 = this.p.k();
            m = 0;
            i = 0;
            if (i >= i3) {
                break label520;
            }
            j = paramArrayOfInt[(i >> 2)] >> (3 - (i & 0x3) << 3) & 0xFF;
            k = i + 1;
            i1 = j;
            n = k;
            if (j <= 127) {
                break label558;
            }
            if ((j & 0xE0) != 192) {
                break label455;
            }
            i = j & 0x1F;
            j = 1;
            if (k + j > i3) {
                c(" in field name");
            }
            i1 = paramArrayOfInt[(k >> 2)] >> (3 - (k & 0x3) << 3);
            n = k + 1;
            if ((i1 & 0xC0) != 128) {
                l(i1);
            }
            i1 = i << 6 | i1 & 0x3F;
            k = i1;
            i = n;
            if (j > 1) {
                i = paramArrayOfInt[(n >> 2)] >> (3 - (n & 0x3) << 3);
                n += 1;
                if ((i & 0xC0) != 128) {
                    l(i);
                }
                i1 = i1 << 6 | i & 0x3F;
                k = i1;
                i = n;
                if (j > 2) {
                    k = paramArrayOfInt[(n >> 2)] >> (3 - (n & 0x3) << 3);
                    i = n + 1;
                    if ((k & 0xC0) != 128) {
                        l(k & 0xFF);
                    }
                    k = i1 << 6 | k & 0x3F;
                }
            }
            i1 = k;
            n = i;
            if (j <= 2) {
                break label558;
            }
            j = k - 65536;
            localObject2 = localObject1;
            if (m >= localObject1.length) {
                localObject2 = this.p.n();
            }
            localObject2[m] = ((char) (55296 + (j >> 10)));
            k = m + 1;
            localObject1 = localObject2;
            j = j & 0x3FF | 0xDC00;
        }
        for (; ; ) {
            localObject2 = localObject1;
            if (k >= localObject1.length) {
                localObject2 = this.p.n();
            }
            m = k + 1;
            localObject2[k] = ((char) j);
            localObject1 = localObject2;
            break label49;
            i2 = 0;
            break;
            label455:
            if ((j & 0xF0) == 224) {
                i = j & 0xF;
                j = 2;
                break label120;
            }
            if ((j & 0xF8) == 240) {
                i = j & 0x7;
                j = 3;
                break label120;
            }
            k(j);
            i = 1;
            j = 1;
            break label120;
            label520:
            localObject1 = new String((char[]) localObject1, 0, m);
            if (paramInt2 < 4) {
                paramArrayOfInt[(paramInt1 - 1)] = i2;
            }
            return this.J.a((String) localObject1, paramArrayOfInt, paramInt1);
            label558:
            j = i1;
            i = n;
            k = m;
        }
    }

    private final sc a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
            throws hi {
        int[] arrayOfInt = paramArrayOfInt;
        if (paramInt1 >= paramArrayOfInt.length) {
            arrayOfInt = a(paramArrayOfInt, paramArrayOfInt.length);
            this.K = arrayOfInt;
        }
        int i = paramInt1 + 1;
        arrayOfInt[paramInt1] = paramInt2;
        sc localsc = this.J.a(arrayOfInt, i);
        paramArrayOfInt = localsc;
        if (localsc == null) {
            paramArrayOfInt = a(arrayOfInt, i, paramInt3);
        }
        return paramArrayOfInt;
    }

    private final void a(char[] paramArrayOfChar, int paramInt)
            throws IOException, hi {
        int[] arrayOfInt = P;
        byte[] arrayOfByte = this.N;
        char[] arrayOfChar = paramArrayOfChar;
        int i;
        int j;
        int k;
        for (; ; ) {
            i = this.f;
            j = i;
            if (i >= this.g) {
                D();
                j = this.f;
            }
            paramArrayOfChar = arrayOfChar;
            i = paramInt;
            if (paramInt >= arrayOfChar.length) {
                paramArrayOfChar = this.p.m();
                i = 0;
            }
            k = Math.min(this.g, paramArrayOfChar.length - i + j);
            while (j < k) {
                paramInt = j + 1;
                j = arrayOfByte[j] & 0xFF;
                if (arrayOfInt[j] != 0) {
                    this.f = paramInt;
                    if (j != 34) {
                        break label160;
                    }
                    this.p.a(i);
                    return;
                }
                paramArrayOfChar[i] = ((char) j);
                j = paramInt;
                i += 1;
            }
            this.f = j;
            arrayOfChar = paramArrayOfChar;
            paramInt = i;
        }
        label160:
        switch (arrayOfInt[j]) {
            default:
                if (j < 32) {
                    c(j, "string value");
                    paramInt = j;
                    label214:
                    if (i < paramArrayOfChar.length) {
                        break label379;
                    }
                    paramArrayOfChar = this.p.m();
                    i = 0;
                }
                break;
        }
        label379:
        for (; ; ) {
            j = i + 1;
            paramArrayOfChar[i] = ((char) paramInt);
            arrayOfChar = paramArrayOfChar;
            paramInt = j;
            break;
            paramInt = Q();
            break label214;
            paramInt = n(j);
            break label214;
            if (this.g - this.f >= 2) {
                paramInt = p(j);
                break label214;
            }
            paramInt = o(j);
            break label214;
            k = q(j);
            j = i + 1;
            paramArrayOfChar[i] = ((char) (0xD800 | k >> 10));
            paramInt = j;
            arrayOfChar = paramArrayOfChar;
            if (j >= paramArrayOfChar.length) {
                arrayOfChar = this.p.m();
                paramInt = 0;
            }
            i = paramInt;
            paramInt = k & 0x3FF | 0xDC00;
            paramArrayOfChar = arrayOfChar;
            break label214;
            j(j);
            paramInt = j;
            break label214;
        }
    }

    public static int[] a(int[] paramArrayOfInt, int paramInt) {
        if (paramArrayOfInt == null) {
            return new int[paramInt];
        }
        int i = paramArrayOfInt.length;
        int[] arrayOfInt = new int[i + paramInt];
        System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i);
        return arrayOfInt;
    }

    private final hm ac() {
        this.r = false;
        hm localhm = this.o;
        this.o = null;
        if (localhm == hm.d) {
            this.n = this.n.b(this.l, this.m);
        }
        for (; ; ) {
            this.b = localhm;
            return localhm;
            if (localhm == hm.b) {
                this.n = this.n.c(this.l, this.m);
            }
        }
    }

    private final int ad()
            throws IOException, hi {
        if ((this.f >= this.g) && (!E())) {
        }
        int j;
        do {
            for (int i = 48; (this.f >= this.g) && (!E()); i = j) {
                do {
                    return i;
                    j = this.N[this.f] & 0xFF;
                    if ((j < 48) || (j > 57)) {
                        return 48;
                    }
                    if (!a(hj.a.g)) {
                        b("Leading zeroes not allowed");
                    }
                    this.f += 1;
                    i = j;
                } while (j != 48);
            }
            j = this.N[this.f] & 0xFF;
            if ((j < 48) || (j > 57)) {
                return 48;
            }
            this.f += 1;
            i = j;
        } while (j == 48);
        return j;
    }

    private final int ae()
            throws IOException, hi {
        while ((this.f < this.g) || (E())) {
            byte[] arrayOfByte = this.N;
            int i = this.f;
            this.f = (i + 1);
            i = arrayOfByte[i] & 0xFF;
            if (i > 32) {
                if (i != 47) {
                    return i;
                }
                ag();
            } else if (i != 32) {
                if (i == 10) {
                    ab();
                } else if (i == 13) {
                    aa();
                } else if (i != 9) {
                    b(i);
                }
            }
        }
        throw a("Unexpected end-of-input within/between " + this.n.d() + " entries");
    }

    private final int af()
            throws IOException, hi {
        while ((this.f < this.g) || (E())) {
            byte[] arrayOfByte = this.N;
            int i = this.f;
            this.f = (i + 1);
            i = arrayOfByte[i] & 0xFF;
            if (i > 32) {
                if (i != 47) {
                    return i;
                }
                ag();
            } else if (i != 32) {
                if (i == 10) {
                    ab();
                } else if (i == 13) {
                    aa();
                } else if (i != 9) {
                    b(i);
                }
            }
        }
        H();
        return -1;
    }

    private final void ag()
            throws IOException, hi {
        if (!a(hj.a.b)) {
            b(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if ((this.f >= this.g) && (!E())) {
            c(" in a comment");
        }
        byte[] arrayOfByte = this.N;
        int i = this.f;
        this.f = (i + 1);
        i = arrayOfByte[i] & 0xFF;
        if (i == 47) {
            ai();
            return;
        }
        if (i == 42) {
            ah();
            return;
        }
        b(i, "was expecting either '*' or '/' for a comment");
    }

    private final void ah()
            throws IOException, hi {
        int[] arrayOfInt = sk.e();
        while ((this.f < this.g) || (E())) {
            byte[] arrayOfByte = this.N;
            int i = this.f;
            this.f = (i + 1);
            i = arrayOfByte[i] & 0xFF;
            int j = arrayOfInt[i];
            if (j != 0) {
                switch (j) {
                    default:
                        j(i);
                        break;
                    case 42:
                        if (this.N[this.f] == 47) {
                            this.f += 1;
                            return;
                        }
                        break;
                    case 10:
                        ab();
                        break;
                    case 13:
                        aa();
                        break;
                    case 2:
                        r(i);
                        break;
                    case 3:
                        s(i);
                        break;
                    case 4:
                        t(i);
                }
            }
        }
        c(" in a comment");
    }

    private final void ai()
            throws IOException, hi {
        int[] arrayOfInt = sk.e();
        for (; ; ) {
            int i;
            int j;
            if ((this.f < this.g) || (E())) {
                byte[] arrayOfByte = this.N;
                i = this.f;
                this.f = (i + 1);
                i = arrayOfByte[i] & 0xFF;
                j = arrayOfInt[i];
                if (j == 0) {
                }
            } else {
                switch (j) {
                    case 42:
                    default:
                        j(i);
                        break;
                    case 10:
                        ab();
                        return;
                    case 13:
                        aa();
                        return;
                    case 2:
                        r(i);
                        break;
                    case 3:
                        s(i);
                        break;
                    case 4:
                        t(i);
                }
            }
        }
    }

    private int aj()
            throws IOException, hi {
        if (this.f >= this.g) {
            D();
        }
        byte[] arrayOfByte = this.N;
        int i = this.f;
        this.f = (i + 1);
        return arrayOfByte[i] & 0xFF;
    }

    private final sc b(int paramInt1, int paramInt2)
            throws hi {
        sc localsc = this.J.a(paramInt1);
        if (localsc != null) {
            return localsc;
        }
        this.K[0] = paramInt1;
        return a(this.K, 1, paramInt2);
    }

    private final sc b(int paramInt1, int paramInt2, int paramInt3)
            throws hi {
        sc localsc = this.J.a(paramInt1, paramInt2);
        if (localsc != null) {
            return localsc;
        }
        this.K[0] = paramInt1;
        this.K[1] = paramInt2;
        return a(this.K, 2, paramInt3);
    }

    private final hm m(int paramInt)
            throws IOException, hi {
        if (paramInt == 34) {
            this.L = true;
            localhm = hm.h;
            this.b = localhm;
            return localhm;
        }
        switch (paramInt) {
            default:
                localhm = h(paramInt);
                this.b = localhm;
                return localhm;
            case 91:
                this.n = this.n.b(this.l, this.m);
                localhm = hm.d;
                this.b = localhm;
                return localhm;
            case 123:
                this.n = this.n.c(this.l, this.m);
                localhm = hm.b;
                this.b = localhm;
                return localhm;
            case 93:
            case 125:
                b(paramInt, "expected a value");
            case 116:
                a("true", 1);
                localhm = hm.k;
                this.b = localhm;
                return localhm;
            case 102:
                a("false", 1);
                localhm = hm.l;
                this.b = localhm;
                return localhm;
            case 110:
                a("null", 1);
                localhm = hm.m;
                this.b = localhm;
                return localhm;
        }
        hm localhm = d(paramInt);
        this.b = localhm;
        return localhm;
    }

    private final int n(int paramInt)
            throws IOException, hi {
        if (this.f >= this.g) {
            D();
        }
        byte[] arrayOfByte = this.N;
        int i = this.f;
        this.f = (i + 1);
        i = arrayOfByte[i];
        if ((i & 0xC0) != 128) {
            a(i & 0xFF, this.f);
        }
        return i & 0x3F | (paramInt & 0x1F) << 6;
    }

    private final int o(int paramInt)
            throws IOException, hi {
        if (this.f >= this.g) {
            D();
        }
        byte[] arrayOfByte = this.N;
        int i = this.f;
        this.f = (i + 1);
        i = arrayOfByte[i];
        if ((i & 0xC0) != 128) {
            a(i & 0xFF, this.f);
        }
        if (this.f >= this.g) {
            D();
        }
        arrayOfByte = this.N;
        int j = this.f;
        this.f = (j + 1);
        j = arrayOfByte[j];
        if ((j & 0xC0) != 128) {
            a(j & 0xFF, this.f);
        }
        return ((paramInt & 0xF) << 6 | i & 0x3F) << 6 | j & 0x3F;
    }

    private final int p(int paramInt)
            throws IOException, hi {
        byte[] arrayOfByte = this.N;
        int i = this.f;
        this.f = (i + 1);
        i = arrayOfByte[i];
        if ((i & 0xC0) != 128) {
            a(i & 0xFF, this.f);
        }
        arrayOfByte = this.N;
        int j = this.f;
        this.f = (j + 1);
        j = arrayOfByte[j];
        if ((j & 0xC0) != 128) {
            a(j & 0xFF, this.f);
        }
        return ((paramInt & 0xF) << 6 | i & 0x3F) << 6 | j & 0x3F;
    }

    private final int q(int paramInt)
            throws IOException, hi {
        if (this.f >= this.g) {
            D();
        }
        byte[] arrayOfByte = this.N;
        int i = this.f;
        this.f = (i + 1);
        i = arrayOfByte[i];
        if ((i & 0xC0) != 128) {
            a(i & 0xFF, this.f);
        }
        if (this.f >= this.g) {
            D();
        }
        arrayOfByte = this.N;
        int j = this.f;
        this.f = (j + 1);
        j = arrayOfByte[j];
        if ((j & 0xC0) != 128) {
            a(j & 0xFF, this.f);
        }
        if (this.f >= this.g) {
            D();
        }
        arrayOfByte = this.N;
        int k = this.f;
        this.f = (k + 1);
        k = arrayOfByte[k];
        if ((k & 0xC0) != 128) {
            a(k & 0xFF, this.f);
        }
        return (((i & 0x3F | (paramInt & 0x7) << 6) << 6 | j & 0x3F) << 6 | k & 0x3F) - 65536;
    }

    private final void r(int paramInt)
            throws IOException, hi {
        if (this.f >= this.g) {
            D();
        }
        byte[] arrayOfByte = this.N;
        paramInt = this.f;
        this.f = (paramInt + 1);
        paramInt = arrayOfByte[paramInt];
        if ((paramInt & 0xC0) != 128) {
            a(paramInt & 0xFF, this.f);
        }
    }

    private final void s(int paramInt)
            throws IOException, hi {
        if (this.f >= this.g) {
            D();
        }
        byte[] arrayOfByte = this.N;
        paramInt = this.f;
        this.f = (paramInt + 1);
        paramInt = arrayOfByte[paramInt];
        if ((paramInt & 0xC0) != 128) {
            a(paramInt & 0xFF, this.f);
        }
        if (this.f >= this.g) {
            D();
        }
        arrayOfByte = this.N;
        paramInt = this.f;
        this.f = (paramInt + 1);
        paramInt = arrayOfByte[paramInt];
        if ((paramInt & 0xC0) != 128) {
            a(paramInt & 0xFF, this.f);
        }
    }

    private final void t(int paramInt)
            throws IOException, hi {
        if (this.f >= this.g) {
            D();
        }
        byte[] arrayOfByte = this.N;
        paramInt = this.f;
        this.f = (paramInt + 1);
        paramInt = arrayOfByte[paramInt];
        if ((paramInt & 0xC0) != 128) {
            a(paramInt & 0xFF, this.f);
        }
        if (this.f >= this.g) {
            D();
        }
        arrayOfByte = this.N;
        paramInt = this.f;
        this.f = (paramInt + 1);
        paramInt = arrayOfByte[paramInt];
        if ((paramInt & 0xC0) != 128) {
            a(paramInt & 0xFF, this.f);
        }
        if (this.f >= this.g) {
            D();
        }
        arrayOfByte = this.N;
        paramInt = this.f;
        this.f = (paramInt + 1);
        paramInt = arrayOfByte[paramInt];
        if ((paramInt & 0xC0) != 128) {
            a(paramInt & 0xFF, this.f);
        }
    }

    protected final boolean E()
            throws IOException {
        boolean bool2 = false;
        this.h += this.g;
        this.j -= this.g;
        boolean bool1 = bool2;
        int i;
        if (this.M != null) {
            i = this.M.read(this.N, 0, this.N.length);
            if (i <= 0) {
                break label74;
            }
            this.f = 0;
            this.g = i;
            bool1 = true;
        }
        label74:
        do {
            return bool1;
            F();
            bool1 = bool2;
        } while (i != 0);
        throw new IOException("InputStream.read() returned 0 characters when trying to read " + this.N.length + " bytes");
    }

    protected void F()
            throws IOException {
        if (this.M != null) {
            if ((this.d.c()) || (a(hj.a.a))) {
                this.M.close();
            }
            this.M = null;
        }
    }

    protected void G()
            throws IOException {
        super.G();
        if (this.O) {
            byte[] arrayOfByte = this.N;
            if (arrayOfByte != null) {
                this.N = null;
                this.d.a(arrayOfByte);
            }
        }
    }

    protected final char Q()
            throws IOException, hi {
        int i = 0;
        if ((this.f >= this.g) && (!E())) {
            c(" in character escape sequence");
        }
        byte[] arrayOfByte = this.N;
        int j = this.f;
        this.f = (j + 1);
        j = arrayOfByte[j];
        switch (j) {
            default:
                return a((char) i(j));
            case 98:
                return '\b';
            case 116:
                return '\t';
            case 110:
                return '\n';
            case 102:
                return '\f';
            case 114:
                return '\r';
            case 34:
            case 47:
            case 92:
                return (char) j;
        }
        j = 0;
        while (i < 4) {
            if ((this.f >= this.g) && (!E())) {
                c(" in character escape sequence");
            }
            arrayOfByte = this.N;
            int k = this.f;
            this.f = (k + 1);
            k = arrayOfByte[k];
            int m = sk.a(k);
            if (m < 0) {
                b(k, "expected a hex-digit for character escape sequence");
            }
            j = j << 4 | m;
            i += 1;
        }
        return (char) j;
    }

    protected sc V()
            throws IOException, hi {
        if ((this.f >= this.g) && (!E())) {
            c(": was expecting closing '\"' for name");
        }
        byte[] arrayOfByte = this.N;
        int i = this.f;
        this.f = (i + 1);
        i = arrayOfByte[i] & 0xFF;
        if (i == 34) {
            return sa.e();
        }
        return a(this.K, 0, 0, i, 0);
    }

    protected final sc W()
            throws IOException, hi {
        if ((this.f >= this.g) && (!E())) {
            c(": was expecting closing ''' for name");
        }
        Object localObject1 = this.N;
        int i = this.f;
        this.f = (i + 1);
        int m = localObject1[i] & 0xFF;
        if (m == 39) {
            return sa.e();
        }
        localObject1 = this.K;
        int[] arrayOfInt = Q;
        int j = 0;
        int k = 0;
        i = 0;
        Object localObject2;
        int n;
        if (m == 39) {
            if (j <= 0) {
                break label556;
            }
            localObject2 = localObject1;
            if (i >= localObject1.length) {
                localObject2 = a((int[]) localObject1, localObject1.length);
                this.K = ((int[]) localObject2);
            }
            localObject2[i] = k;
            localObject1 = localObject2;
            i += 1;
            localObject2 = this.J.a((int[]) localObject1, i);
            if (localObject2 == null) {
                return a((int[]) localObject1, i, j);
            }
        } else {
            n = m;
            if (m == 34) {
                break label565;
            }
            n = m;
            if (arrayOfInt[m] == 0) {
                break label565;
            }
            if (m != 92) {
                c(m, "name");
                label197:
                n = m;
                if (m <= 127) {
                    break label565;
                }
                if (j < 4) {
                    break label562;
                }
                localObject2 = localObject1;
                if (i >= localObject1.length) {
                    localObject2 = a((int[]) localObject1, localObject1.length);
                    this.K = ((int[]) localObject2);
                }
                localObject2[i] = k;
                j = 0;
                i += 1;
                k = 0;
                localObject1 = localObject2;
                label257:
                if (m >= 2048) {
                    break label406;
                }
                k = k << 8 | m >> 6 | 0xC0;
                j += 1;
                label284:
                n = k;
                k = j;
                j = m & 0x3F | 0x80;
                m = k;
            }
        }
        for (; ; ) {
            if (m < 4) {
                k = j | n << 8;
                m += 1;
                j = i;
                i = m;
                label327:
                if ((this.f >= this.g) && (!E())) {
                    c(" in field name");
                }
                localObject2 = this.N;
                m = this.f;
                this.f = (m + 1);
                n = localObject2[m] & 0xFF;
                m = i;
                i = j;
                j = m;
                m = n;
                break;
                m = Q();
                break label197;
                label406:
                k = k << 8 | m >> 12 | 0xE0;
                j += 1;
                if (j < 4) {
                    break label559;
                }
                localObject2 = localObject1;
                if (i >= localObject1.length) {
                    localObject2 = a((int[]) localObject1, localObject1.length);
                    this.K = ((int[]) localObject2);
                }
                localObject2[i] = k;
                i += 1;
                localObject1 = localObject2;
                j = 0;
                k = 0;
            }
            label556:
            label559:
            for (; ; ) {
                k = k << 8 | m >> 6 & 0x3F | 0x80;
                j += 1;
                break label284;
                localObject2 = localObject1;
                if (i >= localObject1.length) {
                    localObject2 = a((int[]) localObject1, localObject1.length);
                    this.K = ((int[]) localObject2);
                }
                localObject2[i] = n;
                localObject1 = localObject2;
                k = 1;
                m = i + 1;
                i = k;
                k = j;
                j = m;
                break label327;
                return (sc) localObject2;
                break;
            }
            label562:
            break label257;
            label565:
            m = j;
            j = n;
            n = k;
        }
    }

    protected void X()
            throws IOException, hi {
        int j = this.f;
        int i = j;
        if (j >= this.g) {
            D();
            i = this.f;
        }
        char[] arrayOfChar = this.p.k();
        int[] arrayOfInt = P;
        int k = Math.min(this.g, arrayOfChar.length + i);
        byte[] arrayOfByte = this.N;
        j = 0;
        while (i < k) {
            int m = arrayOfByte[i] & 0xFF;
            if (arrayOfInt[m] != 0) {
                if (m != 34) {
                    break;
                }
                this.f = (i + 1);
                this.p.a(j);
                return;
            }
            arrayOfChar[j] = ((char) m);
            j += 1;
            i += 1;
        }
        this.f = i;
        a(arrayOfChar, j);
    }

    protected void Y()
            throws IOException, hi {
        this.L = false;
        int[] arrayOfInt = P;
        byte[] arrayOfByte = this.N;
        int k = this.f;
        int m = this.g;
        int j = m;
        int i = k;
        if (k >= m) {
            D();
            i = this.f;
            j = this.g;
        }
        for (; ; ) {
            if (i < j) {
                k = i + 1;
                i = arrayOfByte[i] & 0xFF;
                if (arrayOfInt[i] == 0) {
                    break label188;
                }
                this.f = k;
                if (i != 34) {
                }
            } else {
                this.f = i;
                break;
            }
            switch (arrayOfInt[i]) {
                default:
                    if (i < 32) {
                        c(i, "string value");
                    }
                    break;
                case 1:
                    Q();
                    break;
                case 2:
                    r(i);
                    break;
                case 3:
                    s(i);
                    break;
                case 4:
                    t(i);
                    break;
                j(i);
                break;
            }
            label188:
            i = k;
        }
    }

    protected hm Z()
            throws IOException, hi {
        Object localObject2 = this.p.k();
        int[] arrayOfInt = P;
        byte[] arrayOfByte = this.N;
        int i = 0;
        if (this.f >= this.g) {
            D();
        }
        Object localObject1 = localObject2;
        int j = i;
        if (i >= localObject2.length) {
            localObject1 = this.p.m();
            j = 0;
        }
        int k = this.g;
        i = this.f + (localObject1.length - j);
        if (i < k) {
            k = i;
        }
        for (; ; ) {
            localObject2 = localObject1;
            i = j;
            if (this.f >= k) {
                break;
            }
            i = this.f;
            this.f = (i + 1);
            i = arrayOfByte[i] & 0xFF;
            if ((i == 39) || (arrayOfInt[i] != 0)) {
                if (i == 39) {
                    this.p.a(j);
                    return hm.h;
                }
            } else {
                localObject1[j] = ((char) i);
                j += 1;
                continue;
            }
            switch (arrayOfInt[i]) {
                default:
                    if (i < 32) {
                        c(i, "string value");
                    }
                    j(i);
            }
            for (; ; ) {
                if (j >= localObject1.length) {
                    localObject1 = this.p.m();
                    j = 0;
                    label232:
                    k = j + 1;
                    localObject1[j] = ((char) i);
                    localObject2 = localObject1;
                    i = k;
                    break;
                    if (i != 34) {
                        i = Q();
                        continue;
                        i = n(i);
                        continue;
                        if (this.g - this.f >= 2) {
                            i = p(i);
                        } else {
                            i = o(i);
                            continue;
                            k = q(i);
                            i = j + 1;
                            localObject1[j] = ((char) (0xD800 | k >> 10));
                            if (i < localObject1.length) {
                                break label360;
                            }
                            localObject1 = this.p.m();
                        }
                    }
                }
            }
            label360:
            for (j = 0; ; j = i) {
                i = 0xDC00 | k & 0x3FF;
                break;
                break label232;
            }
        }
    }

    protected hm a(int paramInt, boolean paramBoolean)
            throws IOException, hi {
        double d = Double.NEGATIVE_INFINITY;
        int i = paramInt;
        Object localObject;
        if (paramInt == 73) {
            if ((this.f >= this.g) && (!E())) {
                T();
            }
            localObject = this.N;
            paramInt = this.f;
            this.f = (paramInt + 1);
            paramInt = localObject[paramInt];
            if (paramInt != 78) {
                break label162;
            }
            if (paramBoolean) {
                localObject = "-INF";
                a((String) localObject, 3);
                if (!a(hj.a.h)) {
                    break label117;
                }
                if (!paramBoolean) {
                    break label110;
                }
            }
            for (; ; ) {
                return a((String) localObject, d);
                localObject = "+INF";
                break;
                label110:
                d = Double.POSITIVE_INFINITY;
            }
            label117:
            d("Non-standard token '" + (String) localObject + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            i = paramInt;
        }
        for (; ; ) {
            a(i, "expected digit (0-9) to follow minus sign, for valid numeric value");
            return null;
            label162:
            i = paramInt;
            if (paramInt == 110) {
                if (paramBoolean) {
                    localObject = "-Infinity";
                    a((String) localObject, 3);
                    if (!a(hj.a.h)) {
                        break label224;
                    }
                    if (!paramBoolean) {
                        break label217;
                    }
                }
                for (; ; ) {
                    return a((String) localObject, d);
                    localObject = "+Infinity";
                    break;
                    label217:
                    d = Double.POSITIVE_INFINITY;
                }
                label224:
                d("Non-standard token '" + (String) localObject + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                i = paramInt;
            }
        }
    }

    public hn a() {
        return this.I;
    }

    protected final sc a(int paramInt, int[] paramArrayOfInt)
            throws IOException, hi {
        byte[] arrayOfByte = this.N;
        int i = this.f;
        this.f = (i + 1);
        i = arrayOfByte[i] & 0xFF;
        if (paramArrayOfInt[i] != 0) {
            if (i == 34) {
                return b(this.R, paramInt, 1);
            }
            return a(this.R, paramInt, i, 1);
        }
        paramInt = i | paramInt << 8;
        arrayOfByte = this.N;
        i = this.f;
        this.f = (i + 1);
        i = arrayOfByte[i] & 0xFF;
        if (paramArrayOfInt[i] != 0) {
            if (i == 34) {
                return b(this.R, paramInt, 2);
            }
            return a(this.R, paramInt, i, 2);
        }
        paramInt = paramInt << 8 | i;
        arrayOfByte = this.N;
        i = this.f;
        this.f = (i + 1);
        i = arrayOfByte[i] & 0xFF;
        if (paramArrayOfInt[i] != 0) {
            if (i == 34) {
                return b(this.R, paramInt, 3);
            }
            return a(this.R, paramInt, i, 3);
        }
        paramInt = paramInt << 8 | i;
        arrayOfByte = this.N;
        i = this.f;
        this.f = (i + 1);
        i = arrayOfByte[i] & 0xFF;
        if (paramArrayOfInt[i] != 0) {
            if (i == 34) {
                return b(this.R, paramInt, 4);
            }
            return a(this.R, paramInt, i, 4);
        }
        this.K[0] = this.R;
        this.K[1] = paramInt;
        return f(i);
    }

    protected sc a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
            throws IOException, hi {
        Object localObject2 = Q;
        int i = paramInt3;
        Object localObject1;
        if (localObject2[paramInt3] != 0) {
            if (paramInt3 == 34) {
                localObject1 = paramArrayOfInt;
                paramInt3 = paramInt1;
                if (paramInt4 > 0) {
                    localObject1 = paramArrayOfInt;
                    if (paramInt1 >= paramArrayOfInt.length) {
                        localObject1 = a(paramArrayOfInt, paramArrayOfInt.length);
                        this.K = ((int[]) localObject1);
                    }
                    localObject1[paramInt1] = paramInt2;
                    paramInt3 = paramInt1 + 1;
                }
                localObject2 = this.J.a((int[]) localObject1, paramInt3);
                paramArrayOfInt = (int[]) localObject2;
                if (localObject2 == null) {
                    paramArrayOfInt = a((int[]) localObject1, paramInt3, paramInt4);
                }
                return paramArrayOfInt;
            }
            if (paramInt3 != 92) {
                c(paramInt3, "name");
                label118:
                i = paramInt3;
                if (paramInt3 <= 127) {
                    break label484;
                }
                if (paramInt4 < 4) {
                    break label481;
                }
                localObject1 = paramArrayOfInt;
                if (paramInt1 >= paramArrayOfInt.length) {
                    localObject1 = a(paramArrayOfInt, paramArrayOfInt.length);
                    this.K = ((int[]) localObject1);
                }
                i = paramInt1 + 1;
                localObject1[paramInt1] = paramInt2;
                paramInt4 = 0;
                paramInt2 = 0;
                paramArrayOfInt = (int[]) localObject1;
                paramInt1 = i;
                label179:
                if (paramInt3 >= 2048) {
                    break label332;
                }
                i = paramInt3 >> 6 | 0xC0 | paramInt2 << 8;
                paramInt4 += 1;
                paramInt2 = paramInt1;
                paramInt1 = i;
                int j = paramInt3 & 0x3F | 0x80;
                i = paramInt4;
                paramInt3 = paramInt2;
                paramInt4 = paramInt1;
                paramInt2 = j;
                paramInt1 = paramInt3;
                paramInt3 = paramInt4;
            }
        }
        for (; ; ) {
            if (i < 4) {
                paramInt4 = i + 1;
                paramInt2 |= paramInt3 << 8;
                label265:
                if ((this.f >= this.g) && (!E())) {
                    c(" in field name");
                }
                localObject1 = this.N;
                paramInt3 = this.f;
                this.f = (paramInt3 + 1);
                paramInt3 = localObject1[paramInt3] & 0xFF;
                break;
                paramInt3 = Q();
                break label118;
                label332:
                i = paramInt3 >> 12 | 0xE0 | paramInt2 << 8;
                paramInt2 = paramInt4 + 1;
                if (paramInt2 < 4) {
                    break label474;
                }
                localObject1 = paramArrayOfInt;
                if (paramInt1 >= paramArrayOfInt.length) {
                    localObject1 = a(paramArrayOfInt, paramArrayOfInt.length);
                    this.K = ((int[]) localObject1);
                }
                localObject1[paramInt1] = i;
                paramInt1 += 1;
                paramArrayOfInt = (int[]) localObject1;
                paramInt2 = 0;
            }
            label474:
            for (paramInt4 = 0; ; paramInt4 = i) {
                i = paramInt4 << 8 | paramInt3 >> 6 & 0x3F | 0x80;
                paramInt4 = paramInt2 + 1;
                paramInt2 = paramInt1;
                paramInt1 = i;
                break;
                localObject1 = paramArrayOfInt;
                if (paramInt1 >= paramArrayOfInt.length) {
                    localObject1 = a(paramArrayOfInt, paramArrayOfInt.length);
                    this.K = ((int[]) localObject1);
                }
                localObject1[paramInt1] = paramInt3;
                paramInt4 = 1;
                paramInt1 += 1;
                paramArrayOfInt = (int[]) localObject1;
                break label265;
            }
            label481:
            break label179;
            label484:
            paramInt3 = paramInt2;
            paramInt2 = i;
            i = paramInt4;
        }
    }

    protected final String a(hm paramhm) {
        if (paramhm == null) {
            return null;
        }
        switch (1. a[paramhm.ordinal()])
        {
            default:
                return paramhm.a();
            case 1:
                return this.n.h();
        }
        return this.p.f();
    }

    protected void a(int paramInt1, int paramInt2)
            throws hi {
        this.f = paramInt2;
        l(paramInt1);
    }

    protected final void a(String paramString, int paramInt)
            throws IOException, hi {
        int j = paramString.length();
        int i;
        do {
            if ((this.f >= this.g) && (!E())) {
                c(" in a value");
            }
            if (this.N[this.f] != paramString.charAt(paramInt)) {
                a(paramString.substring(0, paramInt), "'null', 'true', 'false' or NaN");
            }
            this.f += 1;
            i = paramInt + 1;
            paramInt = i;
        } while (i < j);
        if ((this.f >= this.g) && (!E())) {
        }
        do {
            return;
            paramInt = this.N[this.f] & 0xFF;
        }
        while ((paramInt < 48) || (paramInt == 93) || (paramInt == 125) || (!Character.isJavaIdentifierPart((char) i(paramInt))));
        this.f += 1;
        a(paramString.substring(0, i), "'null', 'true', 'false' or NaN");
    }

    protected void a(String paramString1, String paramString2)
            throws IOException, hi {
        paramString1 = new StringBuilder(paramString1);
        for (; ; ) {
            if ((this.f >= this.g) && (!E())) {
            }
            char c;
            do {
                d("Unrecognized token '" + paramString1.toString() + "': was expecting " + paramString2);
                return;
                byte[] arrayOfByte = this.N;
                int i = this.f;
                this.f = (i + 1);
                c = (char) i(arrayOfByte[i]);
            } while (!Character.isJavaIdentifierPart(c));
            this.f += 1;
            paramString1.append(c);
        }
    }

    public byte[] a(ha paramha)
            throws IOException, hi {
        if ((this.b != hm.h) && ((this.b != hm.g) || (this.t == null))) {
            d("Current token (" + this.b + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        if (this.L) {
        }
        for (; ; ) {
            try {
                this.t = b(paramha);
                this.L = false;
                return this.t;
            } catch (IllegalArgumentException localIllegalArgumentException) {
                throw a("Failed to decode VALUE_STRING as base64 (" + paramha + "): " + localIllegalArgumentException.getMessage());
            }
            if (this.t == null) {
                sj localsj = I();
                a(k(), localsj, paramha);
                this.t = localsj.b();
            }
        }
    }

    protected final void aa()
            throws IOException {
        if (((this.f < this.g) || (E())) && (this.N[this.f] == 10)) {
            this.f += 1;
        }
        this.i += 1;
        this.j = this.f;
    }

    protected final void ab()
            throws IOException {
        this.i += 1;
        this.j = this.f;
    }

    public hm b()
            throws IOException, hi {
        this.y = 0;
        if (this.b == hm.f) {
            return ac();
        }
        if (this.L) {
            Y();
        }
        int j = af();
        if (j < 0) {
            close();
            this.b = null;
            return null;
        }
        this.k = (this.h + this.f - 1L);
        this.l = this.i;
        this.m = (this.f - this.j - 1);
        this.t = null;
        if (j == 93) {
            if (!this.n.a()) {
                a(j, '}');
            }
            this.n = this.n.i();
            localObject = hm.e;
            this.b = ((hm) localObject);
            return (hm) localObject;
        }
        if (j == 125) {
            if (!this.n.c()) {
                a(j, ']');
            }
            this.n = this.n.i();
            localObject = hm.c;
            this.b = ((hm) localObject);
            return (hm) localObject;
        }
        int i = j;
        if (this.n.j()) {
            if (j != 44) {
                b(j, "was expecting comma to separate " + this.n.d() + " entries");
            }
            i = ae();
        }
        if (!this.n.c()) {
            return m(i);
        }
        Object localObject = e(i);
        this.n.a(((sc) localObject).a());
        this.b = hm.f;
        i = ae();
        if (i != 58) {
            b(i, "was expecting a colon to separate field name and value");
        }
        i = ae();
        if (i == 34) {
            this.L = true;
            this.o = hm.h;
            return this.b;
        }
        switch (i) {
            default:
                localObject = h(i);
        }
        for (; ; ) {
            this.o = ((hm) localObject);
            return this.b;
            localObject = hm.d;
            continue;
            localObject = hm.b;
            continue;
            b(i, "expected a value");
            a("true", 1);
            localObject = hm.k;
            continue;
            a("false", 1);
            localObject = hm.l;
            continue;
            a("null", 1);
            localObject = hm.m;
            continue;
            localObject = d(i);
        }
    }

    protected byte[] b(ha paramha)
            throws IOException, hi {
        sj localsj = I();
        for (; ; ) {
            if (this.f >= this.g) {
                D();
            }
            byte[] arrayOfByte = this.N;
            int i = this.f;
            this.f = (i + 1);
            int k = arrayOfByte[i] & 0xFF;
            if (k > 32) {
                int j = paramha.b(k);
                i = j;
                if (j < 0) {
                    if (k == 34) {
                        return localsj.b();
                    }
                    i = a(paramha, k, 0);
                    if (i < 0) {
                    }
                } else {
                    if (this.f >= this.g) {
                        D();
                    }
                    arrayOfByte = this.N;
                    j = this.f;
                    this.f = (j + 1);
                    int m = arrayOfByte[j] & 0xFF;
                    k = paramha.b(m);
                    j = k;
                    if (k < 0) {
                        j = a(paramha, m, 1);
                    }
                    m = j | i << 6;
                    if (this.f >= this.g) {
                        D();
                    }
                    arrayOfByte = this.N;
                    i = this.f;
                    this.f = (i + 1);
                    int n = arrayOfByte[i] & 0xFF;
                    j = paramha.b(n);
                    k = j;
                    if (j < 0) {
                        i = j;
                        if (j != -2) {
                            if ((n == 34) && (!paramha.a())) {
                                localsj.a(m >> 4);
                                return localsj.b();
                            }
                            i = a(paramha, n, 2);
                        }
                        k = i;
                        if (i == -2) {
                            if (this.f >= this.g) {
                                D();
                            }
                            arrayOfByte = this.N;
                            i = this.f;
                            this.f = (i + 1);
                            i = arrayOfByte[i] & 0xFF;
                            if (!paramha.a(i)) {
                                throw a(paramha, i, 3, "expected padding character '" + paramha.b() + "'");
                            }
                            localsj.a(m >> 4);
                            continue;
                        }
                    }
                    m = m << 6 | k;
                    if (this.f >= this.g) {
                        D();
                    }
                    arrayOfByte = this.N;
                    i = this.f;
                    this.f = (i + 1);
                    n = arrayOfByte[i] & 0xFF;
                    j = paramha.b(n);
                    k = j;
                    if (j < 0) {
                        i = j;
                        if (j != -2) {
                            if ((n == 34) && (!paramha.a())) {
                                localsj.b(m >> 2);
                                return localsj.b();
                            }
                            i = a(paramha, n, 3);
                        }
                        k = i;
                        if (i == -2) {
                            localsj.b(m >> 2);
                            continue;
                        }
                    }
                    localsj.c(k | m << 6);
                }
            }
        }
    }

    public void close()
            throws IOException {
        super.close();
        this.J.b();
    }

    protected final hm d(int paramInt)
            throws IOException, hi {
        int k = 1;
        char[] arrayOfChar = this.p.k();
        if (paramInt == 45) {
        }
        byte[] arrayOfByte;
        for (boolean bool = true; ; bool = false) {
            if (!bool) {
                break label306;
            }
            arrayOfChar[0] = '-';
            if (this.f >= this.g) {
                D();
            }
            arrayOfByte = this.N;
            paramInt = this.f;
            this.f = (paramInt + 1);
            paramInt = arrayOfByte[paramInt] & 0xFF;
            if ((paramInt >= 48) && (paramInt <= 57)) {
                break;
            }
            return a(paramInt, true);
        }
        label306:
        for (int i = 1; ; i = 0) {
            int j = paramInt;
            if (paramInt == 48) {
                j = ad();
            }
            int m = i + 1;
            arrayOfChar[i] = ((char) j);
            int n = this.f + arrayOfChar.length;
            paramInt = n;
            i = m;
            j = k;
            if (n > this.g) {
                paramInt = this.g;
                j = k;
                i = m;
            }
            for (; ; ) {
                if (this.f >= paramInt) {
                    return a(arrayOfChar, i, bool, j);
                }
                arrayOfByte = this.N;
                k = this.f;
                this.f = (k + 1);
                k = arrayOfByte[k] & 0xFF;
                if ((k < 48) || (k > 57)) {
                    if ((k != 46) && (k != 101) && (k != 69)) {
                        break;
                    }
                    return a(arrayOfChar, i, k, bool, j);
                }
                j += 1;
                arrayOfChar[i] = ((char) k);
                i += 1;
            }
            this.f -= 1;
            this.p.a(i);
            return a(bool, j);
        }
    }

    protected final sc e(int paramInt)
            throws IOException, hi {
        if (paramInt != 34) {
            return g(paramInt);
        }
        if (this.f + 9 > this.g) {
            return V();
        }
        byte[] arrayOfByte = this.N;
        int[] arrayOfInt = Q;
        paramInt = this.f;
        this.f = (paramInt + 1);
        paramInt = arrayOfByte[paramInt] & 0xFF;
        if (arrayOfInt[paramInt] == 0) {
            int i = this.f;
            this.f = (i + 1);
            i = arrayOfByte[i] & 0xFF;
            if (arrayOfInt[i] == 0) {
                paramInt = paramInt << 8 | i;
                i = this.f;
                this.f = (i + 1);
                i = arrayOfByte[i] & 0xFF;
                if (arrayOfInt[i] == 0) {
                    paramInt = paramInt << 8 | i;
                    i = this.f;
                    this.f = (i + 1);
                    i = arrayOfByte[i] & 0xFF;
                    if (arrayOfInt[i] == 0) {
                        paramInt = paramInt << 8 | i;
                        i = this.f;
                        this.f = (i + 1);
                        i = arrayOfByte[i] & 0xFF;
                        if (arrayOfInt[i] == 0) {
                            this.R = paramInt;
                            return a(i, arrayOfInt);
                        }
                        if (i == 34) {
                            return b(paramInt, 4);
                        }
                        return a(paramInt, i, 4);
                    }
                    if (i == 34) {
                        return b(paramInt, 3);
                    }
                    return a(paramInt, i, 3);
                }
                if (i == 34) {
                    return b(paramInt, 2);
                }
                return a(paramInt, i, 2);
            }
            if (i == 34) {
                return b(paramInt, 1);
            }
            return a(paramInt, i, 1);
        }
        if (paramInt == 34) {
            return sa.e();
        }
        return a(0, paramInt, 0);
    }

    protected sc f(int paramInt)
            throws IOException, hi {
        int[] arrayOfInt = Q;
        int j = 2;
        int i = paramInt;
        paramInt = j;
        for (; ; ) {
            if (this.g - this.f < 4) {
                return a(this.K, paramInt, 0, i, 0);
            }
            byte[] arrayOfByte = this.N;
            j = this.f;
            this.f = (j + 1);
            j = arrayOfByte[j] & 0xFF;
            if (arrayOfInt[j] != 0) {
                if (j == 34) {
                    return a(this.K, paramInt, i, 1);
                }
                return a(this.K, paramInt, i, j, 1);
            }
            i = i << 8 | j;
            arrayOfByte = this.N;
            j = this.f;
            this.f = (j + 1);
            j = arrayOfByte[j] & 0xFF;
            if (arrayOfInt[j] != 0) {
                if (j == 34) {
                    return a(this.K, paramInt, i, 2);
                }
                return a(this.K, paramInt, i, j, 2);
            }
            i = i << 8 | j;
            arrayOfByte = this.N;
            j = this.f;
            this.f = (j + 1);
            j = arrayOfByte[j] & 0xFF;
            if (arrayOfInt[j] != 0) {
                if (j == 34) {
                    return a(this.K, paramInt, i, 3);
                }
                return a(this.K, paramInt, i, j, 3);
            }
            j = i << 8 | j;
            arrayOfByte = this.N;
            i = this.f;
            this.f = (i + 1);
            i = arrayOfByte[i] & 0xFF;
            if (arrayOfInt[i] != 0) {
                if (i == 34) {
                    return a(this.K, paramInt, j, 4);
                }
                return a(this.K, paramInt, j, i, 4);
            }
            if (paramInt >= this.K.length) {
                this.K = a(this.K, paramInt);
            }
            this.K[paramInt] = j;
            paramInt += 1;
        }
    }

    protected final sc g(int paramInt)
            throws IOException, hi {
        if ((paramInt == 39) && (a(hj.a.d))) {
            return W();
        }
        if (!a(hj.a.c)) {
            b(paramInt, "was expecting double-quote to start field name");
        }
        int[] arrayOfInt = sk.d();
        if (arrayOfInt[paramInt] != 0) {
            b(paramInt, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        Object localObject1 = this.K;
        int k = 0;
        int j = 0;
        int i = paramInt;
        paramInt = 0;
        for (; ; ) {
            if (k < 4) {
                j = i | j << 8;
            }
            int m;
            for (i = k + 1; ; i = k) {
                if ((this.f >= this.g) && (!E())) {
                    c(" in field name");
                }
                m = this.N[this.f] & 0xFF;
                if (arrayOfInt[m] == 0) {
                    break;
                }
                k = paramInt;
                Object localObject2 = localObject1;
                if (i > 0) {
                    localObject2 = localObject1;
                    if (paramInt >= localObject1.length) {
                        localObject2 = a((int[]) localObject1, localObject1.length);
                        this.K = ((int[]) localObject2);
                    }
                    localObject2[paramInt] = j;
                    k = paramInt + 1;
                }
                localObject1 = this.J.a((int[]) localObject2, k);
                if (localObject1 != null) {
                    break label285;
                }
                return a((int[]) localObject2, k, i);
                localObject2 = localObject1;
                if (paramInt >= localObject1.length) {
                    localObject2 = a((int[]) localObject1, localObject1.length);
                    this.K = ((int[]) localObject2);
                }
                localObject2[paramInt] = j;
                localObject1 = localObject2;
                k = 1;
                j = i;
                paramInt += 1;
            }
            this.f += 1;
            k = i;
            i = m;
        }
        label285:
        return (sc) localObject1;
    }

    protected hm h(int paramInt)
            throws IOException, hi {
        switch (paramInt) {
            default:
            case 39:
            case 78:
                for (; ; ) {
                    b(paramInt, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
                    return null;
                    if (a(hj.a.d)) {
                        return Z();
                        a("NaN", 1);
                        if (a(hj.a.h)) {
                            return a("NaN", NaN .0D);
                        }
                        d("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                    }
                }
        }
        if ((this.f >= this.g) && (!E())) {
            T();
        }
        byte[] arrayOfByte = this.N;
        paramInt = this.f;
        this.f = (paramInt + 1);
        return a(arrayOfByte[paramInt] & 0xFF, false);
    }

    protected int i(int paramInt)
            throws IOException, hi {
        int j = paramInt;
        int i;
        if (paramInt < 0) {
            if ((paramInt & 0xE0) != 192) {
                break label145;
            }
            paramInt &= 0x1F;
            i = 1;
        }
        for (; ; ) {
            j = aj();
            if ((j & 0xC0) != 128) {
                l(j & 0xFF);
            }
            paramInt = paramInt << 6 | j & 0x3F;
            j = paramInt;
            if (i > 1) {
                j = aj();
                if ((j & 0xC0) != 128) {
                    l(j & 0xFF);
                }
                paramInt = paramInt << 6 | j & 0x3F;
                j = paramInt;
                if (i > 2) {
                    i = aj();
                    if ((i & 0xC0) != 128) {
                        l(i & 0xFF);
                    }
                    j = paramInt << 6 | i & 0x3F;
                }
            }
            return j;
            label145:
            if ((paramInt & 0xF0) == 224) {
                paramInt &= 0xF;
                i = 2;
            } else if ((paramInt & 0xF8) == 240) {
                paramInt &= 0x7;
                i = 3;
            } else {
                k(paramInt & 0xFF);
                i = 1;
            }
        }
    }

    protected void j(int paramInt)
            throws hi {
        if (paramInt < 32) {
            b(paramInt);
        }
        k(paramInt);
    }

    public String k()
            throws IOException, hi {
        hm localhm = this.b;
        if (localhm == hm.h) {
            if (this.L) {
                this.L = false;
                X();
            }
            return this.p.f();
        }
        return a(localhm);
    }

    protected void k(int paramInt)
            throws hi {
        d("Invalid UTF-8 start byte 0x" + Integer.toHexString(paramInt));
    }

    protected void l(int paramInt)
            throws hi {
        d("Invalid UTF-8 middle byte 0x" + Integer.toHexString(paramInt));
    }

    public char[] l()
            throws IOException, hi {
        if (this.b != null) {
            switch (1. a[this.b.ordinal()])
            {
                default:
                    return this.b.b();
                case 1:
                    String str;
                    int i;
                    if (!this.r) {
                        str = this.n.h();
                        i = str.length();
                        if (this.q != null) {
                            break label116;
                        }
                        this.q = this.d.a(i);
                    }
                    for (; ; ) {
                        str.getChars(0, i, this.q, 0);
                        this.r = true;
                        return this.q;
                        if (this.q.length < i) {
                            this.q = new char[i];
                        }
                    }
                case 2:
                    label116:
                    if (this.L) {
                        this.L = false;
                        X();
                    }
                    break;
            }
            return this.p.e();
        }
        return null;
    }

    public int m()
            throws IOException, hi {
        int i = 0;
        if (this.b != null) {
        }
        switch (1. a[this.b.ordinal()])
        {
            default:
                i = this.b.b().length;
                return i;
            case 1:
                return this.n.h().length();
            case 2:
                if (this.L) {
                    this.L = false;
                    X();
                }
                break;
        }
        return this.p.c();
    }

    public int n()
            throws IOException, hi {
        if (this.b != null) {
        }
        switch (1. a[this.b.ordinal()])
        {
            case 1:
            default:
                return 0;
            case 2:
                if (this.L) {
                    this.L = false;
                    X();
                }
                break;
        }
        return this.p.d();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */