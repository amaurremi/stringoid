package com.umeng.a.a.a.d;

public abstract class c {
    public abstract int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
            throws d;

    public void a(int paramInt) {
    }

    public abstract boolean a();

    public abstract void b()
            throws d;

    public void b(byte[] paramArrayOfByte)
            throws d {
        b(paramArrayOfByte, 0, paramArrayOfByte.length);
    }

    public abstract void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
            throws d;

    public abstract void c();

    public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
            throws d {
        int i = 0;
        while (i < paramInt2) {
            int j = a(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
            if (j <= 0) {
                throw new d("Cannot read. Remote side has closed. Tried to read " + paramInt2 + " bytes, but only got " + i + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
            }
            i += j;
        }
        return i;
    }

    public void d()
            throws d {
    }

    public byte[] f() {
        return null;
    }

    public int g() {
        return 0;
    }

    public int h() {
        return -1;
    }

    public boolean i() {
        return a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/a/a/a/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */