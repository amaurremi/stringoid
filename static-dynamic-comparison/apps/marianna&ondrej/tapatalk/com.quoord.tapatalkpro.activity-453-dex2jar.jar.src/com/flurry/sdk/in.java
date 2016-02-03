package com.flurry.sdk;

import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;

public final class in
        extends ic {
    final boolean g;
    char h = '\000';
    int i = 0;
    int j = 0;

    public in(ie paramie, InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean) {
        super(paramie, paramInputStream, paramArrayOfByte, paramInt1, paramInt2);
        this.g = paramBoolean;
    }

    private void a(int paramInt1, int paramInt2)
            throws IOException {
        int k = this.j;
        int m = this.i;
        throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + paramInt1 + ", needed " + paramInt2 + ", at char #" + m + ", byte #" + (k + paramInt1) + ")");
    }

    private void a(int paramInt1, int paramInt2, String paramString)
            throws IOException {
        int k = this.j;
        int m = this.d;
        int n = this.i;
        throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(paramInt1) + paramString + " at char #" + (n + paramInt2) + ", byte #" + (k + m - 1) + ")");
    }

    private boolean a(int paramInt)
            throws IOException {
        this.j += this.e - paramInt;
        if (paramInt > 0) {
            if (this.d > 0) {
                int k = 0;
                while (k < paramInt) {
                    this.c[k] = this.c[(this.d + k)];
                    k += 1;
                }
                this.d = 0;
            }
            this.e = paramInt;
        }
        while (this.e < 4) {
            paramInt = this.b.read(this.c, this.e, this.c.length - this.e);
            if (paramInt < 1) {
                if (paramInt < 0) {
                    a();
                    a(this.e, 4);
                }
                b();
            }
            this.e = (paramInt + this.e);
            continue;
            this.d = 0;
            paramInt = this.b.read(this.c);
            if (paramInt < 1) {
                this.e = 0;
                if (paramInt < 0) {
                    a();
                    return false;
                }
                b();
            }
            this.e = paramInt;
        }
        return true;
    }

    public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws IOException {
        int k;
        if (this.c == null) {
            k = -1;
        }
        do {
            return k;
            k = paramInt2;
        } while (paramInt2 < 1);
        if ((paramInt1 < 0) || (paramInt1 + paramInt2 > paramArrayOfChar.length)) {
            a(paramArrayOfChar, paramInt1, paramInt2);
        }
        int i1 = paramInt2 + paramInt1;
        if (this.h != 0) {
            paramInt2 = paramInt1 + 1;
            paramArrayOfChar[paramInt1] = this.h;
            this.h = '\000';
        }
        for (; ; ) {
            int m;
            int n;
            int i2;
            if (paramInt2 < i1) {
                k = this.d;
                if (this.g) {
                    m = this.c[k];
                    n = this.c[(k + 1)];
                    i2 = this.c[(k + 2)];
                    k = this.c[(k + 3)] & 0xFF | m << 24 | (n & 0xFF) << 16 | (i2 & 0xFF) << 8;
                    label159:
                    this.d += 4;
                    if (k <= 65535) {
                        break label395;
                    }
                    if (k > 1114111) {
                        a(k, paramInt2 - paramInt1, "(above " + Integer.toHexString(1114111) + ") ");
                    }
                    m = k - 65536;
                    k = paramInt2 + 1;
                    paramArrayOfChar[paramInt2] = ((char) (55296 + (m >> 10)));
                    n = m & 0x3FF | 0xDC00;
                    m = n;
                    paramInt2 = k;
                    if (k < i1) {
                        break label399;
                    }
                    this.h = ((char) n);
                    paramInt2 = k;
                }
            }
            for (; ; ) {
                paramInt1 = paramInt2 - paramInt1;
                this.i += paramInt1;
                return paramInt1;
                paramInt2 = this.e - this.d;
                if ((paramInt2 >= 4) || (a(paramInt2))) {
                    break label433;
                }
                return -1;
                m = this.c[k];
                n = this.c[(k + 1)];
                i2 = this.c[(k + 2)];
                k = this.c[(k + 3)] << 24 | m & 0xFF | (n & 0xFF) << 8 | (i2 & 0xFF) << 16;
                break label159;
                label395:
                m = k;
                label399:
                k = paramInt2 + 1;
                paramArrayOfChar[paramInt2] = ((char) m);
                paramInt2 = k;
                if (this.d < this.e) {
                    break;
                }
                paramInt2 = k;
            }
            label433:
            paramInt2 = paramInt1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/in.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */