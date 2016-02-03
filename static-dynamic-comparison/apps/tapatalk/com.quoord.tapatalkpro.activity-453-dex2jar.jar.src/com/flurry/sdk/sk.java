package com.flurry.sdk;

import java.util.Arrays;

public final class sk {
    static final int[] a;
    static final int[] b;
    static final int[] c;
    static final int[] d;
    static final int[] e;
    static final int[] f;
    static final int[] g;
    private static final char[] h = "0123456789ABCDEF".toCharArray();
    private static final byte[] i;

    static {
        int k = h.length;
        i = new byte[k];
        int j = 0;
        while (j < k) {
            i[j] = ((byte) h[j]);
            j += 1;
        }
        int[] arrayOfInt = new int['Ā'];
        j = 0;
        while (j < 32) {
            arrayOfInt[j] = -1;
            j += 1;
        }
        arrayOfInt[34] = 1;
        arrayOfInt[92] = 1;
        a = arrayOfInt;
        arrayOfInt = new int[a.length];
        System.arraycopy(a, 0, arrayOfInt, 0, a.length);
        k = 128;
        if (k < 256) {
            if ((k & 0xE0) == 192) {
                j = 2;
            }
            for (; ; ) {
                arrayOfInt[k] = j;
                k += 1;
                break;
                if ((k & 0xF0) == 224) {
                    j = 3;
                } else if ((k & 0xF8) == 240) {
                    j = 4;
                } else {
                    j = -1;
                }
            }
        }
        b = arrayOfInt;
        arrayOfInt = new int['Ā'];
        Arrays.fill(arrayOfInt, -1);
        j = 33;
        while (j < 256) {
            if (Character.isJavaIdentifierPart((char) j)) {
                arrayOfInt[j] = 0;
            }
            j += 1;
        }
        arrayOfInt[64] = 0;
        arrayOfInt[35] = 0;
        arrayOfInt[42] = 0;
        arrayOfInt[45] = 0;
        arrayOfInt[43] = 0;
        c = arrayOfInt;
        arrayOfInt = new int['Ā'];
        System.arraycopy(c, 0, arrayOfInt, 0, c.length);
        Arrays.fill(arrayOfInt, 128, 128, 0);
        d = arrayOfInt;
        e = new int['Ā'];
        System.arraycopy(b, 128, e, 128, 128);
        Arrays.fill(e, 0, 32, -1);
        e[9] = 0;
        e[10] = 10;
        e[13] = 13;
        e[42] = 42;
        arrayOfInt = new int[''];
        j = 0;
        while (j < 32) {
            arrayOfInt[j] = -1;
            j += 1;
        }
        arrayOfInt[34] = 34;
        arrayOfInt[92] = 92;
        arrayOfInt[8] = 98;
        arrayOfInt[9] = 116;
        arrayOfInt[12] = 102;
        arrayOfInt[10] = 110;
        arrayOfInt[13] = 114;
        f = arrayOfInt;
        g = new int[''];
        Arrays.fill(g, -1);
        j = 0;
        while (j < 10) {
            g[(j + 48)] = j;
            j += 1;
        }
        j = 0;
        while (j < 6) {
            g[(j + 97)] = (j + 10);
            g[(j + 65)] = (j + 10);
            j += 1;
        }
    }

    public static int a(int paramInt) {
        if (paramInt > 127) {
            return -1;
        }
        return g[paramInt];
    }

    public static void a(StringBuilder paramStringBuilder, String paramString) {
        int[] arrayOfInt = f;
        int m = arrayOfInt.length;
        int k = 0;
        int n = paramString.length();
        if (k < n) {
            int j = paramString.charAt(k);
            if ((j >= m) || (arrayOfInt[j] == 0)) {
                paramStringBuilder.append(j);
            }
            for (; ; ) {
                k += 1;
                break;
                paramStringBuilder.append('\\');
                int i1 = arrayOfInt[j];
                if (i1 < 0) {
                    paramStringBuilder.append('u');
                    paramStringBuilder.append('0');
                    paramStringBuilder.append('0');
                    i1 = -(i1 + 1);
                    paramStringBuilder.append(h[(i1 >> 4)]);
                    paramStringBuilder.append(h[(i1 & 0xF)]);
                } else {
                    paramStringBuilder.append((char) i1);
                }
            }
        }
    }

    public static final int[] a() {
        return a;
    }

    public static final int[] b() {
        return b;
    }

    public static final int[] c() {
        return c;
    }

    public static final int[] d() {
        return d;
    }

    public static final int[] e() {
        return e;
    }

    public static final int[] f() {
        return f;
    }

    public static char[] g() {
        return (char[]) h.clone();
    }

    public static byte[] h() {
        return (byte[]) i.clone();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/sk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */