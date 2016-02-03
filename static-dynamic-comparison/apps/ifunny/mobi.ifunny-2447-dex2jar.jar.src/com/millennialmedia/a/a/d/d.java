package com.millennialmedia.a.a.d;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class d
        implements Closeable, Flushable {
    private static final String[] a = new String[''];
    private static final String[] b;
    private final Writer c;
    private int[] d = new int[32];
    private int e = 0;
    private String f;
    private String g;
    private boolean h;
    private boolean i;
    private String j;
    private boolean k;

    static {
        int m = 0;
        while (m <= 31) {
            a[m] = String.format("\\u%04x", new Object[]{Integer.valueOf(m)});
            m += 1;
        }
        a[34] = "\\\"";
        a[92] = "\\\\";
        a[9] = "\\t";
        a[8] = "\\b";
        a[10] = "\\n";
        a[13] = "\\r";
        a[12] = "\\f";
        b = (String[]) a.clone();
        b[60] = "\\u003c";
        b[62] = "\\u003e";
        b[38] = "\\u0026";
        b[61] = "\\u003d";
        b[39] = "\\u0027";
    }

    public d(Writer paramWriter) {
        a(6);
        this.g = ":";
        this.k = true;
        if (paramWriter == null) {
            throw new NullPointerException("out == null");
        }
        this.c = paramWriter;
    }

    private int a() {
        if (this.e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.d[(this.e - 1)];
    }

    private d a(int paramInt1, int paramInt2, String paramString) {
        int m = a();
        if ((m != paramInt2) && (m != paramInt1)) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.j != null) {
            throw new IllegalStateException("Dangling name: " + this.j);
        }
        this.e -= 1;
        if (m == paramInt2) {
            k();
        }
        this.c.write(paramString);
        return this;
    }

    private d a(int paramInt, String paramString) {
        e(true);
        a(paramInt);
        this.c.write(paramString);
        return this;
    }

    private void a(int paramInt) {
        if (this.e == this.d.length) {
            arrayOfInt = new int[this.e * 2];
            System.arraycopy(this.d, 0, arrayOfInt, 0, this.e);
            this.d = arrayOfInt;
        }
        int[] arrayOfInt = this.d;
        int m = this.e;
        this.e = (m + 1);
        arrayOfInt[m] = paramInt;
    }

    private void b(int paramInt) {
        this.d[(this.e - 1)] = paramInt;
    }

    private void d(String paramString) {
        int n = 0;
        if (this.i) {
        }
        int i2;
        int m;
        int i3;
        int i1;
        for (String[] arrayOfString = b; ; arrayOfString = a) {
            this.c.write("\"");
            i2 = paramString.length();
            m = 0;
            for (; ; ) {
                if (m >= i2) {
                    break label153;
                }
                i3 = paramString.charAt(m);
                if (i3 >= 128) {
                    break;
                }
                String str2 = arrayOfString[i3];
                str1 = str2;
                if (str2 != null) {
                    break label101;
                }
                i1 = n;
                m += 1;
                n = i1;
            }
        }
        if (i3 == 8232) {
        }
        for (String str1 = "\\u2028"; ; str1 = "\\u2029") {
            label101:
            if (n < m) {
                this.c.write(paramString, n, m - n);
            }
            this.c.write(str1);
            i1 = m + 1;
            break;
            i1 = n;
            if (i3 != 8233) {
                break;
            }
        }
        label153:
        if (n < i2) {
            this.c.write(paramString, n, i2 - n);
        }
        this.c.write("\"");
    }

    private void e(boolean paramBoolean) {
        switch (a()) {
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 7:
                if (!this.h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            case 6:
                if ((!this.h) && (!paramBoolean)) {
                    throw new IllegalStateException("JSON must start with an array or an object.");
                }
                b(7);
                return;
            case 1:
                b(2);
                k();
                return;
            case 2:
                this.c.append(',');
                k();
                return;
        }
        this.c.append(this.g);
        b(5);
    }

    private void j() {
        if (this.j != null) {
            l();
            d(this.j);
            this.j = null;
        }
    }

    private void k() {
        if (this.f == null) {
        }
        for (; ; ) {
            return;
            this.c.write("\n");
            int m = 1;
            int n = this.e;
            while (m < n) {
                this.c.write(this.f);
                m += 1;
            }
        }
    }

    private void l() {
        int m = a();
        if (m == 5) {
            this.c.write(44);
        }
        while (m == 3) {
            k();
            b(4);
            return;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    public d a(long paramLong) {
        j();
        e(false);
        this.c.write(Long.toString(paramLong));
        return this;
    }

    public d a(Number paramNumber) {
        if (paramNumber == null) {
            return f();
        }
        j();
        String str = paramNumber.toString();
        if ((!this.h) && ((str.equals("-Infinity")) || (str.equals("Infinity")) || (str.equals("NaN")))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + paramNumber);
        }
        e(false);
        this.c.append(str);
        return this;
    }

    public d a(String paramString) {
        if (paramString == null) {
            throw new NullPointerException("name == null");
        }
        if (this.j != null) {
            throw new IllegalStateException();
        }
        if (this.e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.j = paramString;
        return this;
    }

    public d a(boolean paramBoolean) {
        j();
        e(false);
        Writer localWriter = this.c;
        if (paramBoolean) {
        }
        for (String str = "true"; ; str = "false") {
            localWriter.write(str);
            return this;
        }
    }

    public d b() {
        j();
        return a(1, "[");
    }

    public d b(String paramString) {
        if (paramString == null) {
            return f();
        }
        j();
        e(false);
        d(paramString);
        return this;
    }

    public final void b(boolean paramBoolean) {
        this.h = paramBoolean;
    }

    public d c() {
        return a(1, 2, "]");
    }

    public final void c(String paramString) {
        if (paramString.length() == 0) {
            this.f = null;
            this.g = ":";
            return;
        }
        this.f = paramString;
        this.g = ": ";
    }

    public final void c(boolean paramBoolean) {
        this.i = paramBoolean;
    }

    public void close() {
        this.c.close();
        int m = this.e;
        if ((m > 1) || ((m == 1) && (this.d[(m - 1)] != 7))) {
            throw new IOException("Incomplete document");
        }
        this.e = 0;
    }

    public d d() {
        j();
        return a(3, "{");
    }

    public final void d(boolean paramBoolean) {
        this.k = paramBoolean;
    }

    public d e() {
        return a(3, 5, "}");
    }

    public d f() {
        if (this.j != null) {
            if (this.k) {
                j();
            }
        } else {
            e(false);
            this.c.write("null");
            return this;
        }
        this.j = null;
        return this;
    }

    public void flush() {
        if (this.e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.c.flush();
    }

    public boolean g() {
        return this.h;
    }

    public final boolean h() {
        return this.i;
    }

    public final boolean i() {
        return this.k;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */