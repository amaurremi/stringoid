package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;

public final class sm {
    private final byte[] a;
    private final int b;
    private int c;

    private sm(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        this.a = paramArrayOfByte;
        this.c = paramInt1;
        this.b = (paramInt1 + paramInt2);
    }

    public static int a(int paramInt, ss paramss) {
        return d(paramInt) * 2 + c(paramss);
    }

    public static sm a(byte[] paramArrayOfByte) {
        return a(paramArrayOfByte, 0, paramArrayOfByte.length);
    }

    public static sm a(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        return new sm(paramArrayOfByte, paramInt1, paramInt2);
    }

    public static int b(int paramInt) {
        if (paramInt >= 0) {
            return f(paramInt);
        }
        return 10;
    }

    public static int b(int paramInt1, int paramInt2) {
        return d(paramInt1) + b(paramInt2);
    }

    public static int b(int paramInt, ss paramss) {
        return d(paramInt) + d(paramss);
    }

    public static int b(int paramInt, String paramString) {
        return d(paramInt) + b(paramString);
    }

    public static int b(String paramString) {
        try {
            paramString = paramString.getBytes("UTF-8");
            int i = f(paramString.length);
            int j = paramString.length;
            return j + i;
        } catch (UnsupportedEncodingException paramString) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int c(int paramInt, long paramLong) {
        return d(paramInt) + c(paramLong);
    }

    public static int c(long paramLong) {
        return e(f(paramLong));
    }

    public static int c(ss paramss) {
        return paramss.e();
    }

    public static int d(int paramInt) {
        return f(sv.a(paramInt, 0));
    }

    public static int d(ss paramss) {
        int i = paramss.e();
        return i + f(i);
    }

    public static int e(long paramLong) {
        if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {
            return 1;
        }
        if ((0xFFFFFFFFFFFFC000 & paramLong) == 0L) {
            return 2;
        }
        if ((0xFFFFFFFFFFE00000 & paramLong) == 0L) {
            return 3;
        }
        if ((0xFFFFFFFFF0000000 & paramLong) == 0L) {
            return 4;
        }
        if ((0xFFFFFFF800000000 & paramLong) == 0L) {
            return 5;
        }
        if ((0xFFFFFC0000000000 & paramLong) == 0L) {
            return 6;
        }
        if ((0xFFFE000000000000 & paramLong) == 0L) {
            return 7;
        }
        if ((0xFF00000000000000 & paramLong) == 0L) {
            return 8;
        }
        if ((0x8000000000000000 & paramLong) == 0L) {
            return 9;
        }
        return 10;
    }

    public static int f(int paramInt) {
        if ((paramInt & 0xFFFFFF80) == 0) {
            return 1;
        }
        if ((paramInt & 0xC000) == 0) {
            return 2;
        }
        if ((0xFFE00000 & paramInt) == 0) {
            return 3;
        }
        if ((0xF0000000 & paramInt) == 0) {
            return 4;
        }
        return 5;
    }

    public static long f(long paramLong) {
        return paramLong << 1 ^ paramLong >> 63;
    }

    public int a() {
        return this.b - this.c;
    }

    public void a(byte paramByte) {
        if (this.c == this.b) {
            throw new sn(this.c, this.b);
        }
        byte[] arrayOfByte = this.a;
        int i = this.c;
        this.c = (i + 1);
        arrayOfByte[i] = paramByte;
    }

    public void a(int paramInt) {
        if (paramInt >= 0) {
            e(paramInt);
            return;
        }
        d(paramInt);
    }

    public void a(int paramInt1, int paramInt2) {
        c(paramInt1, 0);
        a(paramInt2);
    }

    public void a(int paramInt, long paramLong) {
        c(paramInt, 0);
        a(paramLong);
    }

    public void a(int paramInt, String paramString) {
        c(paramInt, 2);
        a(paramString);
    }

    public void a(long paramLong) {
        d(paramLong);
    }

    public void a(ss paramss) {
        paramss.a(this);
    }

    public void a(String paramString) {
        paramString = paramString.getBytes("UTF-8");
        e(paramString.length);
        b(paramString);
    }

    public void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void b(int paramInt, long paramLong) {
        c(paramInt, 0);
        b(paramLong);
    }

    public void b(long paramLong) {
        d(f(paramLong));
    }

    public void b(ss paramss) {
        e(paramss.d());
        paramss.a(this);
    }

    public void b(byte[] paramArrayOfByte) {
        b(paramArrayOfByte, 0, paramArrayOfByte.length);
    }

    public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        if (this.b - this.c >= paramInt2) {
            System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.c, paramInt2);
            this.c += paramInt2;
            return;
        }
        throw new sn(this.c, this.b);
    }

    public void c(int paramInt) {
        a((byte) paramInt);
    }

    public void c(int paramInt1, int paramInt2) {
        e(sv.a(paramInt1, paramInt2));
    }

    public void d(long paramLong) {
        for (; ; ) {
            if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {
                c((int) paramLong);
                return;
            }
            c((int) paramLong & 0x7F | 0x80);
            paramLong >>>= 7;
        }
    }

    public void e(int paramInt) {
        for (; ; ) {
            if ((paramInt & 0xFFFFFF80) == 0) {
                c(paramInt);
                return;
            }
            c(paramInt & 0x7F | 0x80);
            paramInt >>>= 7;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/sm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */