package com.umeng.a.a.a.d;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class a
        extends c {
    protected InputStream a = null;
    protected OutputStream b = null;

    protected a() {
    }

    public a(InputStream paramInputStream) {
        this.a = paramInputStream;
    }

    public a(InputStream paramInputStream, OutputStream paramOutputStream) {
        this.a = paramInputStream;
        this.b = paramOutputStream;
    }

    public a(OutputStream paramOutputStream) {
        this.b = paramOutputStream;
    }

    public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
            throws d {
        if (this.a == null) {
            throw new d(1, "Cannot read from null inputStream");
        }
        try {
            paramInt1 = this.a.read(paramArrayOfByte, paramInt1, paramInt2);
            if (paramInt1 < 0) {
                throw new d(4);
            }
        } catch (IOException paramArrayOfByte) {
            throw new d(0, paramArrayOfByte);
        }
        return paramInt1;
    }

    public boolean a() {
        return true;
    }

    public void b()
            throws d {
    }

    public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
            throws d {
        if (this.b == null) {
            throw new d(1, "Cannot write to null outputStream");
        }
        try {
            this.b.write(paramArrayOfByte, paramInt1, paramInt2);
            return;
        } catch (IOException paramArrayOfByte) {
            throw new d(0, paramArrayOfByte);
        }
    }

    public void c() {
        if (this.a != null) {
        }
        try {
            this.a.close();
            this.a = null;
            if (this.b == null) {
            }
        } catch (IOException localIOException1) {
            try {
                this.b.close();
                this.b = null;
                return;
                localIOException1 = localIOException1;
                localIOException1.printStackTrace();
            } catch (IOException localIOException2) {
                for (; ; ) {
                    localIOException2.printStackTrace();
                }
            }
        }
    }

    public void d()
            throws d {
        if (this.b == null) {
            throw new d(1, "Cannot flush null outputStream");
        }
        try {
            this.b.flush();
            return;
        } catch (IOException localIOException) {
            throw new d(0, localIOException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/a/a/a/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */