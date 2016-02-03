package com.everimaging.fotorsdk.http;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class e
        extends FilterOutputStream {
    private static byte[] e = new byte[0];
    private final d.a a;
    private final int b;
    private byte[] c = null;
    private int d = 0;

    public e(OutputStream paramOutputStream, int paramInt) {
        this(paramOutputStream, paramInt, true);
    }

    public e(OutputStream paramOutputStream, int paramInt, boolean paramBoolean) {
        super(paramOutputStream);
        this.b = paramInt;
        if (paramBoolean) {
            this.a = new d.c(paramInt, null);
            return;
        }
        this.a = new d.b(paramInt, null);
    }

    private void a()
            throws IOException {
        if (this.d > 0) {
            a(this.c, 0, this.d, false);
            this.d = 0;
        }
    }

    private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
            throws IOException {
        this.a.a = a(this.a.a, this.a.a(paramInt2));
        if (!this.a.a(paramArrayOfByte, paramInt1, paramInt2, paramBoolean)) {
            throw new Base64DataException("bad base-64");
        }
        this.out.write(this.a.a, 0, this.a.b);
    }

    private byte[] a(byte[] paramArrayOfByte, int paramInt) {
        byte[] arrayOfByte;
        if (paramArrayOfByte != null) {
            arrayOfByte = paramArrayOfByte;
            if (paramArrayOfByte.length >= paramInt) {
            }
        } else {
            arrayOfByte = new byte[paramInt];
        }
        return arrayOfByte;
    }

    public void close()
            throws IOException {
        Object localObject1 = null;
        try {
            a();
            a(e, 0, 0, true);
            try {
                if ((this.b & 0x10) != 0) {
                    break label45;
                }
                this.out.close();
                localObject2 = localObject1;
            } catch (IOException localIOException2) {
                for (; ; ) {
                    Object localObject2;
                    if (localIOException1 == null) {
                        IOException localIOException3 = localIOException1;
                    }
                }
            }
            if (localObject2 != null) {
                throw ((Throwable) localObject2);
            }
        } catch (IOException localIOException1) {
            for (; ; ) {
                continue;
                label45:
                this.out.flush();
            }
        }
    }

    public void write(int paramInt)
            throws IOException {
        if (this.c == null) {
            this.c = new byte['Ѐ'];
        }
        if (this.d >= this.c.length) {
            a(this.c, 0, this.d, false);
            this.d = 0;
        }
        byte[] arrayOfByte = this.c;
        int i = this.d;
        this.d = (i + 1);
        arrayOfByte[i] = ((byte) paramInt);
    }

    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
            throws IOException {
        if (paramInt2 <= 0) {
            return;
        }
        a();
        a(paramArrayOfByte, paramInt1, paramInt2, false);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/http/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */