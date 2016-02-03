package com.everimaging.fotorsdk.http;

public class d {
    static abstract class a {
        public byte[] a;
        public int b;

        public abstract int a(int paramInt);

        public abstract boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
    }

    static class b
            extends d.a {
        private static final int[] c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private int e;
        private int f;
        private final int[] g;

        public b(int paramInt, byte[] paramArrayOfByte) {
            this.a = paramArrayOfByte;
            if ((paramInt & 0x8) == 0) {
            }
            for (paramArrayOfByte = c; ; paramArrayOfByte = d) {
                this.g = paramArrayOfByte;
                this.e = 0;
                this.f = 0;
                return;
            }
        }

        public int a(int paramInt) {
            return paramInt * 3 / 4 + 10;
        }

        public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean) {
            if (this.e == 6) {
                return false;
            }
            int i2 = paramInt2 + paramInt1;
            int j = this.e;
            paramInt2 = this.f;
            int i = 0;
            byte[] arrayOfByte = this.a;
            int[] arrayOfInt = this.g;
            int k;
            int m;
            int i1;
            if (paramInt1 < i2) {
                k = i;
                m = paramInt2;
                i1 = paramInt1;
                if (j == 0) {
                    int n = paramInt1;
                    for (paramInt1 = paramInt2; n + 4 <= i2; paramInt1 = paramInt2) {
                        paramInt2 = arrayOfInt[(paramArrayOfByte[n] & 0xFF)] << 18 | arrayOfInt[(paramArrayOfByte[(n + 1)] & 0xFF)] << 12 | arrayOfInt[(paramArrayOfByte[(n + 2)] & 0xFF)] << 6 | arrayOfInt[(paramArrayOfByte[(n + 3)] & 0xFF)];
                        paramInt1 = paramInt2;
                        if (paramInt2 < 0) {
                            break;
                        }
                        arrayOfByte[(i + 2)] = ((byte) paramInt2);
                        arrayOfByte[(i + 1)] = ((byte) (paramInt2 >> 8));
                        arrayOfByte[i] = ((byte) (paramInt2 >> 16));
                        i += 3;
                        n += 4;
                    }
                    k = i;
                    m = paramInt1;
                    i1 = n;
                    if (n >= i2) {
                        paramInt2 = paramInt1;
                    }
                }
            }
            for (; ; ) {
                if (!paramBoolean) {
                    this.e = j;
                    this.f = paramInt2;
                    this.b = i;
                    return true;
                    paramInt2 = arrayOfInt[(paramArrayOfByte[i1] & 0xFF)];
                    switch (j) {
                    }
                    label292:
                    label577:
                    do {
                        do {
                            paramInt1 = j;
                            paramInt2 = m;
                            i = k;
                            for (; ; ) {
                                j = paramInt1;
                                paramInt1 = i1 + 1;
                                break;
                                if (paramInt2 >= 0) {
                                    paramInt1 = j + 1;
                                    i = k;
                                } else {
                                    if (paramInt2 == -1) {
                                        break label292;
                                    }
                                    this.e = 6;
                                    return false;
                                    if (paramInt2 >= 0) {
                                        paramInt2 = m << 6 | paramInt2;
                                        paramInt1 = j + 1;
                                        i = k;
                                    } else {
                                        if (paramInt2 == -1) {
                                            break label292;
                                        }
                                        this.e = 6;
                                        return false;
                                        if (paramInt2 >= 0) {
                                            paramInt2 = m << 6 | paramInt2;
                                            paramInt1 = j + 1;
                                            i = k;
                                        } else if (paramInt2 == -2) {
                                            arrayOfByte[k] = ((byte) (m >> 4));
                                            paramInt1 = 4;
                                            i = k + 1;
                                            paramInt2 = m;
                                        } else {
                                            if (paramInt2 == -1) {
                                                break label292;
                                            }
                                            this.e = 6;
                                            return false;
                                            if (paramInt2 >= 0) {
                                                paramInt2 = m << 6 | paramInt2;
                                                arrayOfByte[(k + 2)] = ((byte) paramInt2);
                                                arrayOfByte[(k + 1)] = ((byte) (paramInt2 >> 8));
                                                arrayOfByte[k] = ((byte) (paramInt2 >> 16));
                                                i = k + 3;
                                                paramInt1 = 0;
                                            } else if (paramInt2 == -2) {
                                                arrayOfByte[(k + 1)] = ((byte) (m >> 2));
                                                arrayOfByte[k] = ((byte) (m >> 10));
                                                i = k + 2;
                                                paramInt1 = 5;
                                                paramInt2 = m;
                                            } else {
                                                if (paramInt2 == -1) {
                                                    break label292;
                                                }
                                                this.e = 6;
                                                return false;
                                                if (paramInt2 != -2) {
                                                    break label577;
                                                }
                                                paramInt1 = j + 1;
                                                i = k;
                                                paramInt2 = m;
                                            }
                                        }
                                    }
                                }
                            }
                        } while (paramInt2 == -1);
                        this.e = 6;
                        return false;
                    } while (paramInt2 == -1);
                    this.e = 6;
                    return false;
                }
                paramInt1 = i;
                switch (j) {
                    default:
                        paramInt1 = i;
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        for (; ; ) {
                            this.e = j;
                            this.b = paramInt1;
                            return true;
                            this.e = 6;
                            return false;
                            arrayOfByte[i] = ((byte) (paramInt2 >> 4));
                            paramInt1 = i + 1;
                            continue;
                            k = i + 1;
                            arrayOfByte[i] = ((byte) (paramInt2 >> 10));
                            paramInt1 = k + 1;
                            arrayOfByte[k] = ((byte) (paramInt2 >> 2));
                        }
                }
                this.e = 6;
                return false;
            }
        }
    }

    static class c
            extends d.a {
        private static final byte[] g = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        private static final byte[] h = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        int c;
        public final boolean d;
        public final boolean e;
        public final boolean f;
        private final byte[] i;
        private int j;
        private final byte[] k;

        public c(int paramInt, byte[] paramArrayOfByte) {
            this.a = paramArrayOfByte;
            boolean bool1;
            if ((paramInt & 0x1) == 0) {
                bool1 = true;
                this.d = bool1;
                if ((paramInt & 0x2) != 0) {
                    break label101;
                }
                bool1 = true;
                label33:
                this.e = bool1;
                if ((paramInt & 0x4) == 0) {
                    break label106;
                }
                bool1 = bool2;
                label47:
                this.f = bool1;
                if ((paramInt & 0x8) != 0) {
                    break label111;
                }
                paramArrayOfByte = g;
                label63:
                this.k = paramArrayOfByte;
                this.i = new byte[2];
                this.c = 0;
                if (!this.e) {
                    break label118;
                }
            }
            label101:
            label106:
            label111:
            label118:
            for (paramInt = 19; ; paramInt = -1) {
                this.j = paramInt;
                return;
                bool1 = false;
                break;
                bool1 = false;
                break label33;
                bool1 = false;
                break label47;
                paramArrayOfByte = h;
                break label63;
            }
        }

        public int a(int paramInt) {
            return paramInt * 8 / 5 + 10;
        }

        public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean) {
            byte[] arrayOfByte1 = this.k;
            byte[] arrayOfByte2 = this.a;
            int m = 0;
            int i2 = this.j;
            int i3 = paramInt2 + paramInt1;
            int i1 = -1;
            int n;
            switch (this.c) {
                default:
                    paramInt2 = i2;
                    n = paramInt1;
                    if (i1 != -1) {
                        arrayOfByte2[0] = arrayOfByte1[(i1 >> 18 & 0x3F)];
                        arrayOfByte2[1] = arrayOfByte1[(i1 >> 12 & 0x3F)];
                        arrayOfByte2[2] = arrayOfByte1[(i1 >> 6 & 0x3F)];
                        m = 4;
                        arrayOfByte2[3] = arrayOfByte1[(i1 & 0x3F)];
                        i1 = i2 - 1;
                        paramInt2 = i1;
                        n = paramInt1;
                        if (i1 == 0) {
                            if (!this.f) {
                                break label1108;
                            }
                            paramInt2 = 5;
                            arrayOfByte2[4] = 13;
                        }
                    }
                    break;
            }
            for (; ; ) {
                arrayOfByte2[paramInt2] = 10;
                n = 19;
                paramInt2 += 1;
                for (; ; ) {
                    label178:
                    if (paramInt1 + 3 <= i3) {
                        m = (paramArrayOfByte[paramInt1] & 0xFF) << 16 | (paramArrayOfByte[(paramInt1 + 1)] & 0xFF) << 8 | paramArrayOfByte[(paramInt1 + 2)] & 0xFF;
                        arrayOfByte2[paramInt2] = arrayOfByte1[(m >> 18 & 0x3F)];
                        arrayOfByte2[(paramInt2 + 1)] = arrayOfByte1[(m >> 12 & 0x3F)];
                        arrayOfByte2[(paramInt2 + 2)] = arrayOfByte1[(m >> 6 & 0x3F)];
                        arrayOfByte2[(paramInt2 + 3)] = arrayOfByte1[(m & 0x3F)];
                        paramInt1 += 3;
                        i1 = paramInt2 + 4;
                        i2 = n - 1;
                        paramInt2 = i2;
                        m = i1;
                        n = paramInt1;
                        if (i2 != 0) {
                            break label1092;
                        }
                        if (!this.f) {
                            break label1086;
                        }
                        paramInt2 = i1 + 1;
                        arrayOfByte2[i1] = 13;
                    }
                    for (; ; ) {
                        arrayOfByte2[paramInt2] = 10;
                        n = 19;
                        paramInt2 += 1;
                        break label178;
                        break;
                        if (paramInt1 + 2 > i3) {
                            break;
                        }
                        n = this.i[0];
                        paramInt2 = paramInt1 + 1;
                        i1 = (n & 0xFF) << 16 | (paramArrayOfByte[paramInt1] & 0xFF) << 8 | paramArrayOfByte[paramInt2] & 0xFF;
                        this.c = 0;
                        paramInt1 = paramInt2 + 1;
                        break;
                        if (paramInt1 + 1 > i3) {
                            break;
                        }
                        n = this.i[0];
                        i1 = this.i[1];
                        paramInt2 = paramInt1 + 1;
                        i1 = (n & 0xFF) << 16 | (i1 & 0xFF) << 8 | paramArrayOfByte[paramInt1] & 0xFF;
                        this.c = 0;
                        paramInt1 = paramInt2;
                        break;
                        if (paramBoolean) {
                            if (paramInt1 - this.c == i3 - 1) {
                                if (this.c > 0) {
                                    paramArrayOfByte = this.i;
                                    paramInt1 = 1;
                                    m = paramArrayOfByte[0];
                                }
                                for (; ; ) {
                                    m = (m & 0xFF) << 4;
                                    this.c -= paramInt1;
                                    paramInt1 = paramInt2 + 1;
                                    arrayOfByte2[paramInt2] = arrayOfByte1[(m >> 6 & 0x3F)];
                                    paramInt2 = paramInt1 + 1;
                                    arrayOfByte2[paramInt1] = arrayOfByte1[(m & 0x3F)];
                                    paramInt1 = paramInt2;
                                    if (this.d) {
                                        m = paramInt2 + 1;
                                        arrayOfByte2[paramInt2] = 61;
                                        paramInt1 = m + 1;
                                        arrayOfByte2[m] = 61;
                                    }
                                    paramInt2 = paramInt1;
                                    if (this.e) {
                                        paramInt2 = paramInt1;
                                        if (this.f) {
                                            arrayOfByte2[paramInt1] = 13;
                                            paramInt2 = paramInt1 + 1;
                                        }
                                        arrayOfByte2[paramInt2] = 10;
                                        paramInt2 += 1;
                                    }
                                    m = paramInt2;
                                    this.b = m;
                                    this.j = n;
                                    return true;
                                    m = paramArrayOfByte[paramInt1];
                                    paramInt1 = 0;
                                }
                            }
                            if (paramInt1 - this.c == i3 - 2) {
                                if (this.c > 1) {
                                    byte[] arrayOfByte3 = this.i;
                                    i2 = 1;
                                    m = arrayOfByte3[0];
                                    i1 = paramInt1;
                                    paramInt1 = i2;
                                    label713:
                                    if (this.c <= 0) {
                                        break label894;
                                    }
                                    i1 = this.i[paramInt1];
                                    paramInt1 += 1;
                                    label732:
                                    m = (i1 & 0xFF) << 2 | (m & 0xFF) << 10;
                                    this.c -= paramInt1;
                                    paramInt1 = paramInt2 + 1;
                                    arrayOfByte2[paramInt2] = arrayOfByte1[(m >> 12 & 0x3F)];
                                    paramInt2 = paramInt1 + 1;
                                    arrayOfByte2[paramInt1] = arrayOfByte1[(m >> 6 & 0x3F)];
                                    paramInt1 = paramInt2 + 1;
                                    arrayOfByte2[paramInt2] = arrayOfByte1[(m & 0x3F)];
                                    if (!this.d) {
                                        break label1083;
                                    }
                                    paramInt2 = paramInt1 + 1;
                                    arrayOfByte2[paramInt1] = 61;
                                    paramInt1 = paramInt2;
                                }
                            }
                        }
                        label894:
                        label1083:
                        for (; ; ) {
                            paramInt2 = paramInt1;
                            if (this.e) {
                                paramInt2 = paramInt1;
                                if (this.f) {
                                    arrayOfByte2[paramInt1] = 13;
                                    paramInt2 = paramInt1 + 1;
                                }
                                arrayOfByte2[paramInt2] = 10;
                                paramInt2 += 1;
                            }
                            m = paramInt2;
                            break;
                            m = paramArrayOfByte[paramInt1];
                            i1 = paramInt1 + 1;
                            paramInt1 = 0;
                            break label713;
                            i1 = paramArrayOfByte[i1];
                            break label732;
                            m = paramInt2;
                            if (!this.e) {
                                break;
                            }
                            m = paramInt2;
                            if (paramInt2 <= 0) {
                                break;
                            }
                            m = paramInt2;
                            if (n == 19) {
                                break;
                            }
                            if (this.f) {
                                paramInt1 = paramInt2 + 1;
                                arrayOfByte2[paramInt2] = 13;
                            }
                            for (; ; ) {
                                m = paramInt1 + 1;
                                arrayOfByte2[paramInt1] = 10;
                                break;
                                if (paramInt1 == i3 - 1) {
                                    arrayOfByte1 = this.i;
                                    m = this.c;
                                    this.c = (m + 1);
                                    arrayOfByte1[m] = paramArrayOfByte[paramInt1];
                                    m = paramInt2;
                                    break;
                                }
                                m = paramInt2;
                                if (paramInt1 != i3 - 2) {
                                    break;
                                }
                                arrayOfByte1 = this.i;
                                m = this.c;
                                this.c = (m + 1);
                                arrayOfByte1[m] = paramArrayOfByte[paramInt1];
                                arrayOfByte1 = this.i;
                                m = this.c;
                                this.c = (m + 1);
                                arrayOfByte1[m] = paramArrayOfByte[(paramInt1 + 1)];
                                m = paramInt2;
                                break;
                                paramInt1 = paramInt2;
                            }
                        }
                        label1086:
                        paramInt2 = i1;
                    }
                    label1092:
                    i1 = paramInt2;
                    paramInt2 = m;
                    paramInt1 = n;
                    n = i1;
                }
                label1108:
                paramInt2 = 4;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/http/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */