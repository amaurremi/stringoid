package com.mopub.mobileads.util;

class c
        extends a {
    public static final int LINE_GROUPS = 19;
    private static final byte[] c;
    private static final byte[] d;
    int a;
    public final boolean do_cr;
    public final boolean do_newline;
    public final boolean do_padding;
    private final byte[] e;
    private int f;
    private final byte[] g;

    static {
        if (!Base64.class.desiredAssertionStatus()) {
        }
        for (boolean bool = true; ; bool = false) {
            b = bool;
            c = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
            d = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
            return;
        }
    }

    public c(int paramInt, byte[] paramArrayOfByte) {
        this.output = paramArrayOfByte;
        boolean bool1;
        if ((paramInt & 0x1) == 0) {
            bool1 = true;
            this.do_padding = bool1;
            if ((paramInt & 0x2) != 0) {
                break label101;
            }
            bool1 = true;
            label33:
            this.do_newline = bool1;
            if ((paramInt & 0x4) == 0) {
                break label106;
            }
            bool1 = bool2;
            label47:
            this.do_cr = bool1;
            if ((paramInt & 0x8) != 0) {
                break label111;
            }
            paramArrayOfByte = c;
            label63:
            this.g = paramArrayOfByte;
            this.e = new byte[2];
            this.a = 0;
            if (!this.do_newline) {
                break label118;
            }
        }
        label101:
        label106:
        label111:
        label118:
        for (paramInt = 19; ; paramInt = -1) {
            this.f = paramInt;
            return;
            bool1 = false;
            break;
            bool1 = false;
            break label33;
            bool1 = false;
            break label47;
            paramArrayOfByte = d;
            break label63;
        }
    }

    public int maxOutputSize(int paramInt) {
        return paramInt * 8 / 5 + 10;
    }

    public boolean process(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean) {
        byte[] arrayOfByte1 = this.g;
        byte[] arrayOfByte2 = this.output;
        int i = 0;
        int m = this.f;
        int i1 = paramInt2 + paramInt1;
        int k = -1;
        label62:
        int j;
        switch (this.a) {
            default:
                paramInt2 = paramInt1;
                paramInt1 = m;
                j = paramInt2;
                if (k != -1) {
                    arrayOfByte2[0] = arrayOfByte1[(k >> 18 & 0x3F)];
                    arrayOfByte2[1] = arrayOfByte1[(k >> 12 & 0x3F)];
                    arrayOfByte2[2] = arrayOfByte1[(k >> 6 & 0x3F)];
                    i = 4;
                    arrayOfByte2[3] = arrayOfByte1[(k & 0x3F)];
                    k = m - 1;
                    paramInt1 = k;
                    j = paramInt2;
                    if (k == 0) {
                        if (!this.do_cr) {
                            break label1226;
                        }
                        paramInt1 = 5;
                        arrayOfByte2[4] = 13;
                    }
                }
                break;
        }
        for (; ; ) {
            arrayOfByte2[paramInt1] = 10;
            j = 19;
            paramInt1 += 1;
            for (; ; ) {
                label180:
                if (paramInt2 + 3 <= i1) {
                    i = (paramArrayOfByte[paramInt2] & 0xFF) << 16 | (paramArrayOfByte[(paramInt2 + 1)] & 0xFF) << 8 | paramArrayOfByte[(paramInt2 + 2)] & 0xFF;
                    arrayOfByte2[paramInt1] = arrayOfByte1[(i >> 18 & 0x3F)];
                    arrayOfByte2[(paramInt1 + 1)] = arrayOfByte1[(i >> 12 & 0x3F)];
                    arrayOfByte2[(paramInt1 + 2)] = arrayOfByte1[(i >> 6 & 0x3F)];
                    arrayOfByte2[(paramInt1 + 3)] = arrayOfByte1[(i & 0x3F)];
                    paramInt2 += 3;
                    k = paramInt1 + 4;
                    m = j - 1;
                    paramInt1 = m;
                    i = k;
                    j = paramInt2;
                    if (m != 0) {
                        break label1210;
                    }
                    if (!this.do_cr) {
                        break label1204;
                    }
                    paramInt1 = k + 1;
                    arrayOfByte2[k] = 13;
                }
                for (; ; ) {
                    arrayOfByte2[paramInt1] = 10;
                    j = 19;
                    paramInt1 += 1;
                    break label180;
                    paramInt2 = paramInt1;
                    break label62;
                    if (paramInt1 + 2 > i1) {
                        break;
                    }
                    j = this.e[0];
                    paramInt2 = paramInt1 + 1;
                    k = (j & 0xFF) << 16 | (paramArrayOfByte[paramInt1] & 0xFF) << 8 | paramArrayOfByte[paramInt2] & 0xFF;
                    this.a = 0;
                    paramInt2 += 1;
                    break label62;
                    if (paramInt1 + 1 > i1) {
                        break;
                    }
                    j = this.e[0];
                    k = this.e[1];
                    paramInt2 = paramInt1 + 1;
                    k = (j & 0xFF) << 16 | (k & 0xFF) << 8 | paramArrayOfByte[paramInt1] & 0xFF;
                    this.a = 0;
                    break label62;
                    label742:
                    int n;
                    if (paramBoolean) {
                        if (paramInt2 - this.a == i1 - 1) {
                            if (this.a > 0) {
                                paramArrayOfByte = this.e;
                                i = 1;
                                k = paramArrayOfByte[0];
                            }
                            for (; ; ) {
                                k = (k & 0xFF) << 4;
                                this.a -= i;
                                m = paramInt1 + 1;
                                arrayOfByte2[paramInt1] = arrayOfByte1[(k >> 6 & 0x3F)];
                                i = m + 1;
                                arrayOfByte2[m] = arrayOfByte1[(k & 0x3F)];
                                paramInt1 = i;
                                if (this.do_padding) {
                                    k = i + 1;
                                    arrayOfByte2[i] = 61;
                                    paramInt1 = k + 1;
                                    arrayOfByte2[k] = 61;
                                }
                                i = paramInt1;
                                if (this.do_newline) {
                                    i = paramInt1;
                                    if (this.do_cr) {
                                        arrayOfByte2[paramInt1] = 13;
                                        i = paramInt1 + 1;
                                    }
                                    arrayOfByte2[i] = 10;
                                    i += 1;
                                }
                                k = paramInt2;
                                if ((b) || (this.a == 0)) {
                                    break;
                                }
                                throw new AssertionError();
                                k = paramArrayOfByte[paramInt2];
                                paramInt2 += 1;
                                i = 0;
                            }
                        }
                        if (paramInt2 - this.a == i1 - 2) {
                            if (this.a > 1) {
                                byte[] arrayOfByte3 = this.e;
                                m = 1;
                                k = arrayOfByte3[0];
                                i = paramInt2;
                                paramInt2 = m;
                                if (this.a <= 0) {
                                    break label946;
                                }
                                m = this.e[paramInt2];
                                n = paramInt2 + 1;
                                paramInt2 = i;
                                i = n;
                                label769:
                                k = (m & 0xFF) << 2 | (k & 0xFF) << 10;
                                this.a -= i;
                                i = paramInt1 + 1;
                                arrayOfByte2[paramInt1] = arrayOfByte1[(k >> 12 & 0x3F)];
                                m = i + 1;
                                arrayOfByte2[i] = arrayOfByte1[(k >> 6 & 0x3F)];
                                paramInt1 = m + 1;
                                arrayOfByte2[m] = arrayOfByte1[(k & 0x3F)];
                                if (!this.do_padding) {
                                    break label1201;
                                }
                                i = paramInt1 + 1;
                                arrayOfByte2[paramInt1] = 61;
                                paramInt1 = i;
                            }
                        }
                    }
                    label946:
                    label1123:
                    label1201:
                    for (; ; ) {
                        i = paramInt1;
                        if (this.do_newline) {
                            i = paramInt1;
                            if (this.do_cr) {
                                arrayOfByte2[paramInt1] = 13;
                                i = paramInt1 + 1;
                            }
                            arrayOfByte2[i] = 10;
                            i += 1;
                        }
                        k = paramInt2;
                        break;
                        k = paramArrayOfByte[paramInt2];
                        i = paramInt2 + 1;
                        paramInt2 = 0;
                        break label742;
                        m = paramArrayOfByte[i];
                        n = i + 1;
                        i = paramInt2;
                        paramInt2 = n;
                        break label769;
                        k = paramInt2;
                        i = paramInt1;
                        if (!this.do_newline) {
                            break;
                        }
                        k = paramInt2;
                        i = paramInt1;
                        if (paramInt1 <= 0) {
                            break;
                        }
                        k = paramInt2;
                        i = paramInt1;
                        if (j == 19) {
                            break;
                        }
                        if (this.do_cr) {
                            i = paramInt1 + 1;
                            arrayOfByte2[paramInt1] = 13;
                            paramInt1 = i;
                        }
                        for (; ; ) {
                            i = paramInt1 + 1;
                            arrayOfByte2[paramInt1] = 10;
                            k = paramInt2;
                            break;
                            m = i;
                            if (!b) {
                                m = i;
                                if (k != i1) {
                                    throw new AssertionError();
                                    if (paramInt2 != i1 - 1) {
                                        break label1123;
                                    }
                                    arrayOfByte1 = this.e;
                                    i = this.a;
                                    this.a = (i + 1);
                                    arrayOfByte1[i] = paramArrayOfByte[paramInt2];
                                    m = paramInt1;
                                }
                            }
                            for (; ; ) {
                                this.op = m;
                                this.f = j;
                                return true;
                                m = paramInt1;
                                if (paramInt2 == i1 - 2) {
                                    arrayOfByte1 = this.e;
                                    i = this.a;
                                    this.a = (i + 1);
                                    arrayOfByte1[i] = paramArrayOfByte[paramInt2];
                                    arrayOfByte1 = this.e;
                                    i = this.a;
                                    this.a = (i + 1);
                                    arrayOfByte1[i] = paramArrayOfByte[(paramInt2 + 1)];
                                    m = paramInt1;
                                }
                            }
                        }
                    }
                    label1204:
                    paramInt1 = k;
                }
                label1210:
                k = paramInt1;
                paramInt1 = i;
                paramInt2 = j;
                j = k;
            }
            label1226:
            paramInt1 = 4;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/util/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */