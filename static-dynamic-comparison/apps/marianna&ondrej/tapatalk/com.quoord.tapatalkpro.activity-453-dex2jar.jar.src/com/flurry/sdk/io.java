package com.flurry.sdk;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public final class io
        extends Writer {
    protected final ie a;
    OutputStream b;
    byte[] c;
    final int d;
    int e;
    int f = 0;

    public io(ie paramie, OutputStream paramOutputStream) {
        this.a = paramie;
        this.b = paramOutputStream;
        this.c = paramie.f();
        this.d = (this.c.length - 4);
        this.e = 0;
    }

    private int a(int paramInt)
            throws IOException {
        int i = this.f;
        this.f = 0;
        if ((paramInt < 56320) || (paramInt > 57343)) {
            throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(paramInt) + "; illegal combination");
        }
        return (i - 55296 << 10) + 65536 + (paramInt - 56320);
    }

    private void b(int paramInt)
            throws IOException {
        if (paramInt > 1114111) {
            throw new IOException("Illegal character point (0x" + Integer.toHexString(paramInt) + ") to output; max is 0x10FFFF as per RFC 4627");
        }
        if (paramInt >= 55296) {
            if (paramInt <= 56319) {
                throw new IOException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(paramInt) + ")");
            }
            throw new IOException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(paramInt) + ")");
        }
        throw new IOException("Illegal character point (0x" + Integer.toHexString(paramInt) + ") to output");
    }

    public Writer append(char paramChar)
            throws IOException {
        write(paramChar);
        return this;
    }

    public void close()
            throws IOException {
        if (this.b != null) {
            if (this.e > 0) {
                this.b.write(this.c, 0, this.e);
                this.e = 0;
            }
            OutputStream localOutputStream = this.b;
            this.b = null;
            byte[] arrayOfByte = this.c;
            if (arrayOfByte != null) {
                this.c = null;
                this.a.b(arrayOfByte);
            }
            localOutputStream.close();
            int i = this.f;
            this.f = 0;
            if (i > 0) {
                b(i);
            }
        }
    }

    public void flush()
            throws IOException {
        if (this.b != null) {
            if (this.e > 0) {
                this.b.write(this.c, 0, this.e);
                this.e = 0;
            }
            this.b.flush();
        }
    }

    public void write(int paramInt)
            throws IOException {
        int i;
        if (this.f > 0) {
            i = a(paramInt);
        }
        byte[] arrayOfByte;
        do {
            do {
                if (this.e >= this.d) {
                    this.b.write(this.c, 0, this.e);
                    this.e = 0;
                }
                if (i >= 128) {
                    break;
                }
                arrayOfByte = this.c;
                paramInt = this.e;
                this.e = (paramInt + 1);
                arrayOfByte[paramInt] = ((byte) i);
                return;
                i = paramInt;
            } while (paramInt < 55296);
            i = paramInt;
        } while (paramInt > 57343);
        if (paramInt > 56319) {
            b(paramInt);
        }
        this.f = paramInt;
        return;
        paramInt = this.e;
        int j;
        if (i < 2048) {
            arrayOfByte = this.c;
            j = paramInt + 1;
            arrayOfByte[paramInt] = ((byte) (i >> 6 | 0xC0));
            arrayOfByte = this.c;
            paramInt = j + 1;
            arrayOfByte[j] = ((byte) (i & 0x3F | 0x80));
        }
        for (; ; ) {
            this.e = paramInt;
            return;
            if (i <= 65535) {
                arrayOfByte = this.c;
                j = paramInt + 1;
                arrayOfByte[paramInt] = ((byte) (i >> 12 | 0xE0));
                arrayOfByte = this.c;
                int k = j + 1;
                arrayOfByte[j] = ((byte) (i >> 6 & 0x3F | 0x80));
                arrayOfByte = this.c;
                paramInt = k + 1;
                arrayOfByte[k] = ((byte) (i & 0x3F | 0x80));
            } else {
                if (i > 1114111) {
                    b(i);
                }
                arrayOfByte = this.c;
                j = paramInt + 1;
                arrayOfByte[paramInt] = ((byte) (i >> 18 | 0xF0));
                arrayOfByte = this.c;
                paramInt = j + 1;
                arrayOfByte[j] = ((byte) (i >> 12 & 0x3F | 0x80));
                arrayOfByte = this.c;
                j = paramInt + 1;
                arrayOfByte[paramInt] = ((byte) (i >> 6 & 0x3F | 0x80));
                arrayOfByte = this.c;
                paramInt = j + 1;
                arrayOfByte[j] = ((byte) (i & 0x3F | 0x80));
            }
        }
    }

    public void write(String paramString)
            throws IOException {
        write(paramString, 0, paramString.length());
    }

    public void write(String paramString, int paramInt1, int paramInt2)
            throws IOException {
        if (paramInt2 < 2) {
            if (paramInt2 == 1) {
                write(paramString.charAt(paramInt1));
            }
            return;
        }
        int i = paramInt1;
        int j = paramInt2;
        if (this.f > 0) {
            i = paramString.charAt(paramInt1);
            j = paramInt2 - 1;
            write(a(i));
            i = paramInt1 + 1;
        }
        paramInt1 = this.e;
        byte[] arrayOfByte = this.c;
        int n = this.d;
        int i1 = j + i;
        paramInt2 = i;
        i = paramInt1;
        int k;
        label173:
        label176:
        int m;
        if (paramInt2 < i1) {
            i = paramInt1;
            if (paramInt1 >= n) {
                this.b.write(arrayOfByte, 0, paramInt1);
                i = 0;
            }
            j = paramInt2 + 1;
            k = paramString.charAt(paramInt2);
            if (k >= 128) {
                break label525;
            }
            paramInt1 = i + 1;
            arrayOfByte[i] = ((byte) k);
            i = i1 - j;
            paramInt2 = n - paramInt1;
            if (i <= paramInt2) {
                break label522;
            }
            i = paramInt2;
            paramInt2 = j;
            if (paramInt2 < i + j) {
                k = paramInt2 + 1;
                m = paramString.charAt(paramInt2);
                if (m >= 128) {
                    paramInt2 = k;
                }
            }
        }
        for (i = m; ; i = j) {
            if (i < 2048) {
                j = paramInt1 + 1;
                arrayOfByte[paramInt1] = ((byte) (i >> 6 | 0xC0));
                paramInt1 = j + 1;
                arrayOfByte[j] = ((byte) (i & 0x3F | 0x80));
                break;
                arrayOfByte[paramInt1] = ((byte) m);
                paramInt1 += 1;
                paramInt2 = k;
                break label176;
                break;
            }
            if ((i < 55296) || (i > 57343)) {
                j = paramInt1 + 1;
                arrayOfByte[paramInt1] = ((byte) (i >> 12 | 0xE0));
                k = j + 1;
                arrayOfByte[j] = ((byte) (i >> 6 & 0x3F | 0x80));
                paramInt1 = k + 1;
                arrayOfByte[k] = ((byte) (i & 0x3F | 0x80));
                break;
            }
            if (i > 56319) {
                this.e = paramInt1;
                b(i);
            }
            this.f = i;
            if (paramInt2 >= i1) {
                i = paramInt1;
                this.e = i;
                return;
            }
            i = a(paramString.charAt(paramInt2));
            if (i > 1114111) {
                this.e = paramInt1;
                b(i);
            }
            j = paramInt1 + 1;
            arrayOfByte[paramInt1] = ((byte) (i >> 18 | 0xF0));
            paramInt1 = j + 1;
            arrayOfByte[j] = ((byte) (i >> 12 & 0x3F | 0x80));
            j = paramInt1 + 1;
            arrayOfByte[paramInt1] = ((byte) (i >> 6 & 0x3F | 0x80));
            paramInt1 = j + 1;
            arrayOfByte[j] = ((byte) (i & 0x3F | 0x80));
            paramInt2 += 1;
            break;
            label522:
            break label173;
            label525:
            paramInt2 = j;
            j = k;
            paramInt1 = i;
        }
    }

    public void write(char[] paramArrayOfChar)
            throws IOException {
        write(paramArrayOfChar, 0, paramArrayOfChar.length);
    }

    public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws IOException {
        if (paramInt2 < 2) {
            if (paramInt2 == 1) {
                write(paramArrayOfChar[paramInt1]);
            }
            return;
        }
        int i = paramInt1;
        int j = paramInt2;
        if (this.f > 0) {
            i = paramArrayOfChar[paramInt1];
            j = paramInt2 - 1;
            write(a(i));
            i = paramInt1 + 1;
        }
        paramInt1 = this.e;
        byte[] arrayOfByte = this.c;
        int n = this.d;
        int i1 = j + i;
        paramInt2 = i;
        i = paramInt1;
        int k;
        label167:
        label170:
        int m;
        if (paramInt2 < i1) {
            i = paramInt1;
            if (paramInt1 >= n) {
                this.b.write(arrayOfByte, 0, paramInt1);
                i = 0;
            }
            j = paramInt2 + 1;
            k = paramArrayOfChar[paramInt2];
            if (k >= 128) {
                break label515;
            }
            paramInt1 = i + 1;
            arrayOfByte[i] = ((byte) k);
            i = i1 - j;
            paramInt2 = n - paramInt1;
            if (i <= paramInt2) {
                break label512;
            }
            i = paramInt2;
            paramInt2 = j;
            if (paramInt2 < i + j) {
                k = paramInt2 + 1;
                m = paramArrayOfChar[paramInt2];
                if (m >= 128) {
                    paramInt2 = k;
                }
            }
        }
        for (i = m; ; i = j) {
            if (i < 2048) {
                j = paramInt1 + 1;
                arrayOfByte[paramInt1] = ((byte) (i >> 6 | 0xC0));
                paramInt1 = j + 1;
                arrayOfByte[j] = ((byte) (i & 0x3F | 0x80));
                break;
                arrayOfByte[paramInt1] = ((byte) m);
                paramInt1 += 1;
                paramInt2 = k;
                break label170;
                break;
            }
            if ((i < 55296) || (i > 57343)) {
                j = paramInt1 + 1;
                arrayOfByte[paramInt1] = ((byte) (i >> 12 | 0xE0));
                k = j + 1;
                arrayOfByte[j] = ((byte) (i >> 6 & 0x3F | 0x80));
                paramInt1 = k + 1;
                arrayOfByte[k] = ((byte) (i & 0x3F | 0x80));
                break;
            }
            if (i > 56319) {
                this.e = paramInt1;
                b(i);
            }
            this.f = i;
            if (paramInt2 >= i1) {
                i = paramInt1;
                this.e = i;
                return;
            }
            i = a(paramArrayOfChar[paramInt2]);
            if (i > 1114111) {
                this.e = paramInt1;
                b(i);
            }
            j = paramInt1 + 1;
            arrayOfByte[paramInt1] = ((byte) (i >> 18 | 0xF0));
            paramInt1 = j + 1;
            arrayOfByte[j] = ((byte) (i >> 12 & 0x3F | 0x80));
            j = paramInt1 + 1;
            arrayOfByte[paramInt1] = ((byte) (i >> 6 & 0x3F | 0x80));
            paramInt1 = j + 1;
            arrayOfByte[j] = ((byte) (i & 0x3F | 0x80));
            paramInt2 += 1;
            break;
            label512:
            break label167;
            label515:
            paramInt2 = j;
            j = k;
            paramInt1 = i;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/io.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */