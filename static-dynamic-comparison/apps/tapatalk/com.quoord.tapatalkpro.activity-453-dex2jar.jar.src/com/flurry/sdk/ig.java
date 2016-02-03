package com.flurry.sdk;

import java.lang.ref.SoftReference;

public final class ig {
    protected static final ThreadLocal<SoftReference<ig>> a = new ThreadLocal();
    private static final char[] e = ;
    private static final byte[] f = sk.h();
    protected sp b;
    protected sj c;
    protected final char[] d = new char[6];

    public ig() {
        this.d[0] = '\\';
        this.d[2] = '0';
        this.d[3] = '0';
    }

    private int a(int paramInt1, int paramInt2) {
        if ((paramInt2 < 56320) || (paramInt2 > 57343)) {
            throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(paramInt1) + ", second 0x" + Integer.toHexString(paramInt2) + "; illegal combination");
        }
        return 65536 + (paramInt1 - 55296 << 10) + (paramInt2 - 56320);
    }

    private int a(int paramInt1, int paramInt2, sj paramsj, int paramInt3) {
        paramsj.e(paramInt3);
        paramsj.a(92);
        if (paramInt2 < 0) {
            paramsj.a(117);
            if (paramInt1 > 255) {
                paramInt2 = paramInt1 >> 8;
                paramsj.a(f[(paramInt2 >> 4)]);
                paramsj.a(f[(paramInt2 & 0xF)]);
                paramInt1 &= 0xFF;
                paramsj.a(f[(paramInt1 >> 4)]);
                paramsj.a(f[(paramInt1 & 0xF)]);
            }
        }
        for (; ; ) {
            return paramsj.f();
            paramsj.a(48);
            paramsj.a(48);
            break;
            paramsj.a((byte) paramInt2);
        }
    }

    private int a(int paramInt, char[] paramArrayOfChar) {
        if (paramInt < 0) {
            paramInt = -(paramInt + 1);
            paramArrayOfChar[1] = 'u';
            paramArrayOfChar[4] = e[(paramInt >> 4)];
            paramArrayOfChar[5] = e[(paramInt & 0xF)];
            return 6;
        }
        paramArrayOfChar[1] = ((char) paramInt);
        return 2;
    }

    public static ig a() {
        Object localObject1 = (SoftReference) a.get();
        if (localObject1 == null) {
        }
        for (localObject1 = null; ; localObject1 = (ig) ((SoftReference) localObject1).get()) {
            Object localObject2 = localObject1;
            if (localObject1 == null) {
                localObject2 = new ig();
                a.set(new SoftReference(localObject2));
            }
            return (ig) localObject2;
        }
    }

    private void a(int paramInt) {
        if (paramInt > 1114111) {
            throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(paramInt) + ") to output; max is 0x10FFFF as per RFC 4627");
        }
        if (paramInt >= 55296) {
            if (paramInt <= 56319) {
                throw new IllegalArgumentException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(paramInt) + ")");
            }
            throw new IllegalArgumentException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(paramInt) + ")");
        }
        throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(paramInt) + ") to output");
    }

    public char[] a(String paramString) {
        Object localObject1 = this.b;
        Object localObject2 = localObject1;
        if (localObject1 == null) {
            localObject2 = new sp(null);
            this.b = ((sp) localObject2);
        }
        localObject1 = ((sp) localObject2).k();
        int[] arrayOfInt = sk.f();
        int i1 = arrayOfInt.length;
        int i2 = paramString.length();
        int j = 0;
        int k = 0;
        int m;
        int i;
        int n;
        for (; ; ) {
            m = j;
            if (k >= i2) {
                break label231;
            }
            i = paramString.charAt(k);
            if ((i >= i1) || (arrayOfInt[i] == 0)) {
                break;
            }
            n = a(arrayOfInt[paramString.charAt(k)], this.d);
            if (j + n <= localObject1.length) {
                break label244;
            }
            m = localObject1.length - j;
            if (m > 0) {
                System.arraycopy(this.d, 0, localObject1, j, m);
            }
            localObject1 = ((sp) localObject2).m();
            n -= m;
            System.arraycopy(this.d, m, localObject1, j, n);
            j += n;
            label176:
            k += 1;
        }
        if (j >= localObject1.length) {
            localObject1 = ((sp) localObject2).m();
            j = 0;
        }
        for (; ; ) {
            m = j + 1;
            localObject1[j] = i;
            n = k + 1;
            j = m;
            k = n;
            if (n < i2) {
                break;
            }
            label231:
            ((sp) localObject2).a(m);
            return ((sp) localObject2).g();
            label244:
            System.arraycopy(this.d, 0, localObject1, j, n);
            j += n;
            break label176;
        }
    }

    public byte[] b(String paramString) {
        Object localObject1 = this.c;
        Object localObject3 = localObject1;
        if (localObject1 == null) {
            localObject3 = new sj(null);
            this.c = ((sj) localObject3);
        }
        int n = paramString.length();
        localObject1 = ((sj) localObject3).c();
        int i = 0;
        int k;
        Object localObject2;
        label66:
        int m;
        for (int j = 0; ; j = k) {
            k = i;
            if (j >= n) {
                break label202;
            }
            int[] arrayOfInt = sk.f();
            localObject2 = localObject1;
            m = paramString.charAt(j);
            if ((m <= 127) && (arrayOfInt[m] == 0)) {
                break;
            }
            localObject1 = localObject2;
            m = i;
            if (i >= localObject2.length) {
                localObject1 = ((sj) localObject3).d();
                m = 0;
            }
            k = j + 1;
            j = paramString.charAt(j);
            if (j > 127) {
                break label212;
            }
            i = a(j, arrayOfInt[j], (sj) localObject3, m);
            localObject1 = ((sj) localObject3).e();
        }
        if (i >= localObject2.length) {
            localObject2 = ((sj) localObject3).d();
            i = 0;
        }
        for (; ; ) {
            k = i + 1;
            localObject2[i] = ((byte) m);
            m = j + 1;
            i = k;
            j = m;
            if (m < n) {
                break label66;
            }
            label202:
            return this.c.d(k);
            label212:
            if (j <= 2047) {
                i = m + 1;
                localObject1[m] = ((byte) (j >> 6 | 0xC0));
                j = j & 0x3F | 0x80;
                localObject2 = localObject1;
                m = i;
                if (i >= localObject1.length) {
                    localObject2 = ((sj) localObject3).d();
                    m = 0;
                }
                localObject2[m] = ((byte) j);
                localObject1 = localObject2;
                j = k;
                i = m + 1;
                break;
            }
            if ((j < 55296) || (j > 57343)) {
                i = m + 1;
                localObject1[m] = ((byte) (j >> 12 | 0xE0));
                if (i < localObject1.length) {
                    break label550;
                }
                localObject1 = ((sj) localObject3).d();
                i = 0;
            }
            label550:
            for (; ; ) {
                m = i + 1;
                localObject1[i] = ((byte) (j >> 6 & 0x3F | 0x80));
                j = j & 0x3F | 0x80;
                i = m;
                break;
                if (j > 56319) {
                    a(j);
                }
                if (k >= n) {
                    a(j);
                }
                int i1 = a(j, paramString.charAt(k));
                if (i1 > 1114111) {
                    a(i1);
                }
                i = m + 1;
                localObject1[m] = ((byte) (i1 >> 18 | 0xF0));
                if (i >= localObject1.length) {
                    localObject1 = ((sj) localObject3).d();
                    i = 0;
                }
                for (; ; ) {
                    j = i + 1;
                    localObject1[i] = ((byte) (i1 >> 12 & 0x3F | 0x80));
                    if (j >= localObject1.length) {
                        localObject1 = ((sj) localObject3).d();
                    }
                    for (i = 0; ; i = j) {
                        m = i + 1;
                        localObject1[i] = ((byte) (i1 >> 6 & 0x3F | 0x80));
                        k += 1;
                        j = i1 & 0x3F | 0x80;
                        i = m;
                        break;
                    }
                }
            }
        }
    }

    public byte[] c(String paramString) {
        Object localObject1 = this.c;
        Object localObject2 = localObject1;
        if (localObject1 == null) {
            localObject2 = new sj(null);
            this.c = ((sj) localObject2);
        }
        int i2 = paramString.length();
        localObject1 = ((sj) localObject2).c();
        int k = localObject1.length;
        int i = 0;
        int j = 0;
        int n;
        int i1;
        int m;
        if (j < i2) {
            n = j + 1;
            i1 = paramString.charAt(j);
            m = k;
            j = n;
            k = i1;
            label82:
            if (k <= 127) {
                n = m;
                i1 = i;
                if (i >= m) {
                    localObject1 = ((sj) localObject2).d();
                    n = localObject1.length;
                    i1 = 0;
                }
                i = i1 + 1;
                localObject1[i1] = ((byte) k);
                if (j < i2) {
                }
            }
        }
        for (; ; ) {
            return this.c.d(i);
            k = paramString.charAt(j);
            j += 1;
            m = n;
            break label82;
            if (i >= m) {
                localObject1 = ((sj) localObject2).d();
                i = localObject1.length;
            }
            for (m = 0; ; m = n) {
                if (k < 2048) {
                    n = m + 1;
                    localObject1[m] = ((byte) (k >> 6 | 0xC0));
                    m = k;
                    k = n;
                }
                for (; ; ) {
                    n = i;
                    i1 = k;
                    if (k >= i) {
                        localObject1 = ((sj) localObject2).d();
                        n = localObject1.length;
                        i1 = 0;
                    }
                    localObject1[i1] = ((byte) (m & 0x3F | 0x80));
                    k = n;
                    i = i1 + 1;
                    break;
                    if ((k >= 55296) && (k <= 57343)) {
                        break label380;
                    }
                    i1 = m + 1;
                    localObject1[m] = ((byte) (k >> 12 | 0xE0));
                    m = i;
                    n = i1;
                    if (i1 >= i) {
                        localObject1 = ((sj) localObject2).d();
                        m = localObject1.length;
                        n = 0;
                    }
                    localObject1[n] = ((byte) (k >> 6 & 0x3F | 0x80));
                    i1 = n + 1;
                    n = k;
                    i = m;
                    k = i1;
                    m = n;
                }
                label380:
                if (k > 56319) {
                    a(k);
                }
                if (j >= i2) {
                    a(k);
                }
                n = a(k, paramString.charAt(j));
                if (n > 1114111) {
                    a(n);
                }
                i1 = m + 1;
                localObject1[m] = ((byte) (n >> 18 | 0xF0));
                k = i;
                m = i1;
                if (i1 >= i) {
                    localObject1 = ((sj) localObject2).d();
                    k = localObject1.length;
                    m = 0;
                }
                i = m + 1;
                localObject1[m] = ((byte) (n >> 12 & 0x3F | 0x80));
                if (i >= k) {
                    localObject1 = ((sj) localObject2).d();
                    i = localObject1.length;
                }
                for (k = 0; ; k = m) {
                    localObject1[k] = ((byte) (n >> 6 & 0x3F | 0x80));
                    k += 1;
                    m = n;
                    j += 1;
                    break;
                    m = i;
                    i = k;
                }
                n = i;
                i = m;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */