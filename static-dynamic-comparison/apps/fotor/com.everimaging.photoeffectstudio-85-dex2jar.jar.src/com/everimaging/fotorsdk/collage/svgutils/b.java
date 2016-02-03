package com.everimaging.fotorsdk.collage.svgutils;

public class b {
    private static final double[] e = new double[''];
    public int a;
    private char b;
    private CharSequence c;
    private int d;

    static {
        int i = 0;
        while (i < e.length) {
            e[i] = Math.pow(10.0D, i);
            i += 1;
        }
    }

    public b(CharSequence paramCharSequence, int paramInt) {
        this.c = paramCharSequence;
        this.a = paramInt;
        this.d = paramCharSequence.length();
        this.b = paramCharSequence.charAt(paramInt);
    }

    public static float a(int paramInt1, int paramInt2) {
        if ((paramInt2 < -125) || (paramInt1 == 0)) {
            return 0.0F;
        }
        if (paramInt2 >= 128) {
            if (paramInt1 > 0) {
                return Float.POSITIVE_INFINITY;
            }
            return Float.NEGATIVE_INFINITY;
        }
        if (paramInt2 == 0) {
            return paramInt1;
        }
        int i = paramInt1;
        if (paramInt1 >= 67108864) {
            i = paramInt1 + 1;
        }
        if (paramInt2 > 0) {
        }
        for (double d1 = i * e[paramInt2]; ; d1 = i / e[(-paramInt2)]) {
            return (float) d1;
        }
    }

    private void a(char paramChar) {
        throw new RuntimeException("Unexpected char '" + paramChar + "'.");
    }

    private char f() {
        if (this.a < this.d) {
            this.a += 1;
        }
        if (this.a == this.d) {
            return '\000';
        }
        return this.c.charAt(this.a);
    }

    public void a() {
        while ((this.a < this.d) && (Character.isWhitespace(this.c.charAt(this.a)))) {
            c();
        }
    }

    public void b() {
        for (; ; ) {
            if (this.a < this.d) {
            }
            switch (this.c.charAt(this.a)) {
                default:
                    return;
            }
            c();
        }
    }

    public void c() {
        this.b = f();
    }

    public float d() {
        int i7 = 1;
        int i5 = 1;
        int i6 = 1;
        int i3 = 0;
        int i4 = 0;
        int i2;
        switch (this.b) {
            case ',':
            default:
                i2 = 1;
                switch (this.b) {
                    case '/':
                    default:
                        return NaN .0F;
                }
                break;
        }
        for (int i = 0; ; i = 1) {
            this.b = f();
            i2 = i;
            break;
            i = 0;
            int i1 = 0;
            int k = 0;
            for (int j = 0; ; j = 0) {
                m = i;
                n = j;
                if (this.b != '.') {
                    break;
                }
                this.b = f();
                switch (this.b) {
                    default:
                        m = i;
                        n = j;
                        if (i1 != 0) {
                            break label732;
                        }
                        a(this.b);
                        return 0.0F;
                    this.b = f();
                    switch (this.b) {
                        case '0':
                        default:
                            return 0.0F;
                        case '.':
                        case 'E':
                        case 'e':
                            i = 0;
                            i1 = 1;
                            k = 0;
                    }
                    break;
                }
            }
            int n = 0;
            i1 = 0;
            int m = 0;
            if (i1 < 9) {
                j = i1 + 1;
                k = m * 10 + (this.b - '0');
                i = n;
            }
            for (; ; ) {
                this.b = f();
                n = i;
                i1 = j;
                m = k;
                switch (this.b) {
                }
                m = k;
                i1 = 1;
                k = j;
                j = m;
                break;
                i = n + 1;
                j = i1;
                k = m;
            }
            if (k == 0) {
                m = i;
                this.b = f();
                i = m - 1;
                m = i;
                switch (this.b) {
                    case '0':
                    default:
                        m = i;
                        n = j;
                        if (i1 == 0) {
                            return 0.0F;
                        }
                        break;
                }
            }
            for (; ; ) {
                m = i;
                i1 = k;
                n = j;
                if (k < 9) {
                    i1 = k + 1;
                    n = j * 10 + (this.b - '0');
                    m = i - 1;
                }
                this.b = f();
                i = m;
                k = i1;
                j = n;
                switch (this.b) {
                }
                label732:
                switch (this.b) {
                    default:
                        k = i6;
                        j = i4;
                }
                for (; ; ) {
                    i = j;
                    if (k == 0) {
                        i = -j;
                    }
                    j = n;
                    if (i2 == 0) {
                        j = -n;
                    }
                    return a(j, i + m);
                    this.b = f();
                    j = i7;
                    i = i5;
                    switch (this.b) {
                        case ',':
                        case '.':
                        case '/':
                        default:
                            a(this.b);
                            return 0.0F;
                        case '-':
                            j = 0;
                        case '+':
                            this.b = f();
                            i = j;
                            switch (this.b) {
                                default:
                                    a(this.b);
                                    return 0.0F;
                            }
                            break;
                    }
                    switch (this.b) {
                        default:
                            j = i4;
                            k = i;
                            break;
                        case '0':
                            this.b = f();
                            switch (this.b) {
                                case '0':
                                default:
                                    j = i4;
                                    k = i;
                            }
                            break;
                    }
                }
                j = 0;
                for (i1 = i3; ; i1 = i3) {
                    i3 = i1;
                    k = j;
                    if (i1 < 3) {
                        i3 = i1 + 1;
                        k = j * 10 + (this.b - '0');
                    }
                    this.b = f();
                    i1 = i3;
                    j = k;
                    switch (this.b) {
                    }
                    j = k;
                    k = i;
                    break;
                    j = 0;
                }
            }
        }
    }

    public float e() {
        a();
        float f = d();
        b();
        return f;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/svgutils/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */