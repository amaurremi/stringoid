package com.flurry.sdk;

import java.util.Arrays;

public final class sa {
    final sa a;
    final boolean b;
    private int c;
    private int d;
    private int[] e;
    private sc[] f;
    private a[] g;
    private int h;
    private int i;
    private transient boolean j;
    private boolean k;
    private boolean l;
    private boolean m;

    private sa(int paramInt, boolean paramBoolean) {
        this.a = null;
        this.b = paramBoolean;
        int n;
        if (paramInt < 16) {
            n = 16;
        }
        for (; ; ) {
            c(n);
            return;
            n = paramInt;
            if ((paramInt - 1 & paramInt) != 0) {
                n = i1;
                while (n < paramInt) {
                    n += n;
                }
            }
        }
    }

    private sa(sa paramsa, boolean paramBoolean) {
        this.a = paramsa;
        this.b = paramBoolean;
        this.c = paramsa.c;
        this.d = paramsa.d;
        this.e = paramsa.e;
        this.f = paramsa.f;
        this.g = paramsa.g;
        this.h = paramsa.h;
        this.i = paramsa.i;
        this.j = false;
        this.k = true;
        this.l = true;
        this.m = true;
    }

    public static sa a() {
        return new sa(64, true);
    }

    private static sc a(int paramInt1, String paramString, int[] paramArrayOfInt, int paramInt2) {
        if (paramInt2 < 4) {
        }
        int[] arrayOfInt;
        int n;
        switch (paramInt2) {
            default:
                arrayOfInt = new int[paramInt2];
                n = 0;
        }
        while (n < paramInt2) {
            arrayOfInt[n] = paramArrayOfInt[n];
            n += 1;
            continue;
            return new sd(paramString, paramInt1, paramArrayOfInt[0]);
            return new se(paramString, paramInt1, paramArrayOfInt[0], paramArrayOfInt[1]);
            return new sf(paramString, paramInt1, paramArrayOfInt[0], paramArrayOfInt[1], paramArrayOfInt[2]);
        }
        return new sg(paramString, paramInt1, arrayOfInt, paramInt2);
    }

    private void a(int paramInt, sc paramsc) {
        if (this.k) {
            j();
        }
        if (this.j) {
            g();
        }
        this.c += 1;
        int i1 = paramInt & this.d;
        int n;
        if (this.f[i1] == null) {
            this.e[i1] = (paramInt << 8);
            if (this.l) {
                l();
            }
            this.f[i1] = paramsc;
            paramInt = this.e.length;
            if (this.c > paramInt >> 1) {
                n = paramInt >> 2;
                if (this.c <= paramInt - n) {
                    break label254;
                }
                this.j = true;
            }
        }
        label199:
        label254:
        while (this.h < n) {
            return;
            if (this.m) {
                k();
            }
            this.h += 1;
            int i2 = this.e[i1];
            paramInt = i2 & 0xFF;
            if (paramInt == 0) {
                if (this.i <= 254) {
                    n = this.i;
                    this.i += 1;
                    paramInt = n;
                    if (n >= this.g.length) {
                        m();
                        paramInt = n;
                    }
                    this.e[i1] = (i2 & 0xFF00 | paramInt + 1);
                }
            }
            for (; ; ) {
                this.g[paramInt] = new a(paramsc, this.g[paramInt]);
                break;
                paramInt = i();
                break label199;
                paramInt -= 1;
            }
        }
        this.j = true;
    }

    private void a(sa paramsa) {
        for (; ; ) {
            try {
                int n = paramsa.c;
                int i1 = this.c;
                if (n <= i1) {
                    return;
                }
                if (paramsa.c() > 6000) {
                    c(64);
                    continue;
                }
                this.c = paramsa.c;
            } finally {
            }
            this.e = paramsa.e;
            this.f = paramsa.f;
            this.k = true;
            this.l = true;
            this.d = paramsa.d;
            this.g = paramsa.g;
            this.h = paramsa.h;
            this.i = paramsa.i;
        }
    }

    public static final int b(int paramInt) {
        paramInt = paramInt >>> 16 ^ paramInt;
        return paramInt ^ paramInt >>> 8;
    }

    public static final int b(int paramInt1, int paramInt2) {
        paramInt1 = paramInt1 * 31 + paramInt2;
        paramInt1 ^= paramInt1 >>> 16;
        return paramInt1 ^ paramInt1 >>> 8;
    }

    public static final int b(int[] paramArrayOfInt, int paramInt) {
        int i1 = paramArrayOfInt[0];
        int n = 1;
        while (n < paramInt) {
            i1 = i1 * 31 + paramArrayOfInt[n];
            n += 1;
        }
        paramInt = i1 >>> 16 ^ i1;
        return paramInt ^ paramInt >>> 8;
    }

    private void c(int paramInt) {
        this.c = 0;
        this.e = new int[paramInt];
        this.f = new sc[paramInt];
        this.k = false;
        this.l = false;
        this.d = (paramInt - 1);
        this.m = true;
        this.g = null;
        this.i = 0;
        this.j = false;
    }

    public static sc e() {
        return sd.b();
    }

    private void f() {
        this.k = true;
        this.l = true;
        this.m = true;
    }

    private void g() {
        this.j = false;
        this.l = false;
        int i3 = this.e.length;
        int n = i3 + i3;
        if (n > 65536) {
            h();
        }
        label334:
        do {
            Object localObject;
            int i1;
            int i4;
            do {
                return;
                this.e = new int[n];
                this.d = (n - 1);
                localObject = this.f;
                this.f = new sc[n];
                i1 = 0;
                for (n = 0; i1 < i3; n = i2) {
                    arrayOfa = localObject[i1];
                    i2 = n;
                    if (arrayOfa != null) {
                        i2 = n + 1;
                        n = arrayOfa.hashCode();
                        i4 = this.d & n;
                        this.f[i4] = arrayOfa;
                        this.e[i4] = (n << 8);
                    }
                    i1 += 1;
                }
                i4 = this.i;
            } while (i4 == 0);
            this.h = 0;
            this.i = 0;
            this.m = false;
            a[] arrayOfa = this.g;
            this.g = new a[arrayOfa.length];
            int i2 = 0;
            while (i2 < i4) {
                localObject = arrayOfa[i2];
                while (localObject != null) {
                    sc localsc = ((a) localObject).a;
                    i1 = localsc.hashCode();
                    int i5 = this.d & i1;
                    int i6 = this.e[i5];
                    if (this.f[i5] == null) {
                        this.e[i5] = (i1 << 8);
                        this.f[i5] = localsc;
                        localObject = ((a) localObject).b;
                        n += 1;
                    } else {
                        this.h += 1;
                        i1 = i6 & 0xFF;
                        if (i1 == 0) {
                            if (this.i <= 254) {
                                i3 = this.i;
                                this.i += 1;
                                i1 = i3;
                                if (i3 >= this.g.length) {
                                    m();
                                    i1 = i3;
                                }
                                this.e[i5] = (i6 & 0xFF00 | i1 + 1);
                            }
                        }
                        for (; ; ) {
                            this.g[i1] = new a(localsc, this.g[i1]);
                            break;
                            i1 = i();
                            break label334;
                            i1 -= 1;
                        }
                    }
                }
                i2 += 1;
            }
        } while (n == this.c);
        throw new RuntimeException("Internal error: count after rehash " + n + "; should be " + this.c);
    }

    private void h() {
        this.c = 0;
        Arrays.fill(this.e, 0);
        Arrays.fill(this.f, null);
        Arrays.fill(this.g, null);
        this.h = 0;
        this.i = 0;
    }

    private int i() {
        a[] arrayOfa = this.g;
        int i1 = Integer.MAX_VALUE;
        int i2 = -1;
        int n = 0;
        int i4 = this.i;
        if (n < i4) {
            int i3 = arrayOfa[n].a();
            if (i3 >= i1) {
                break label62;
            }
            if (i3 == 1) {
                return n;
            }
            i2 = n;
            i1 = i3;
        }
        label62:
        for (; ; ) {
            n += 1;
            break;
            return i2;
        }
    }

    private void j() {
        int[] arrayOfInt = this.e;
        int n = this.e.length;
        this.e = new int[n];
        System.arraycopy(arrayOfInt, 0, this.e, 0, n);
        this.k = false;
    }

    private void k() {
        a[] arrayOfa = this.g;
        if (arrayOfa == null) {
            this.g = new a[32];
        }
        for (; ; ) {
            this.m = false;
            return;
            int n = arrayOfa.length;
            this.g = new a[n];
            System.arraycopy(arrayOfa, 0, this.g, 0, n);
        }
    }

    private void l() {
        sc[] arrayOfsc = this.f;
        int n = arrayOfsc.length;
        this.f = new sc[n];
        System.arraycopy(arrayOfsc, 0, this.f, 0, n);
        this.l = false;
    }

    private void m() {
        a[] arrayOfa = this.g;
        int n = arrayOfa.length;
        this.g = new a[n + n];
        System.arraycopy(arrayOfa, 0, this.g, 0, n);
    }

    public sa a(boolean paramBoolean1, boolean paramBoolean2) {
        try {
            sa localsa = new sa(this, paramBoolean2);
            return localsa;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public sc a(int paramInt) {
        int n = b(paramInt);
        int i1 = this.d & n;
        int i2 = this.e[i1];
        Object localObject;
        if ((i2 >> 8 ^ n) << 8 == 0) {
            localObject = this.f[i1];
            if (localObject != null) {
            }
        }
        do {
            do {
                do {
                    return null;
                    if (!((sc) localObject).a(paramInt)) {
                        break;
                    }
                    return (sc) localObject;
                } while (i2 == 0);
                i1 = i2 & 0xFF;
            } while (i1 <= 0);
            localObject = this.g[(i1 - 1)];
        } while (localObject == null);
        return ((a) localObject).a(n, paramInt, 0);
    }

    public sc a(int paramInt1, int paramInt2) {
        int n = b(paramInt1, paramInt2);
        int i1 = this.d & n;
        int i2 = this.e[i1];
        Object localObject;
        if ((i2 >> 8 ^ n) << 8 == 0) {
            localObject = this.f[i1];
            if (localObject != null) {
            }
        }
        do {
            do {
                do {
                    return null;
                    if (!((sc) localObject).a(paramInt1, paramInt2)) {
                        break;
                    }
                    return (sc) localObject;
                } while (i2 == 0);
                i1 = i2 & 0xFF;
            } while (i1 <= 0);
            localObject = this.g[(i1 - 1)];
        } while (localObject == null);
        return ((a) localObject).a(n, paramInt1, paramInt2);
    }

    public sc a(String paramString, int[] paramArrayOfInt, int paramInt) {
        String str = paramString;
        if (this.b) {
            str = sm.a.a(paramString);
        }
        int n = b(paramArrayOfInt, paramInt);
        paramString = a(n, str, paramArrayOfInt, paramInt);
        a(n, paramString);
        return paramString;
    }

    public sc a(int[] paramArrayOfInt, int paramInt) {
        int n = b(paramArrayOfInt, paramInt);
        int i1 = this.d & n;
        int i2 = this.e[i1];
        Object localObject;
        if ((i2 >> 8 ^ n) << 8 == 0) {
            localObject = this.f[i1];
            if ((localObject == null) || (((sc) localObject).a(paramArrayOfInt, paramInt))) {
                return (sc) localObject;
            }
        } else if (i2 == 0) {
            return null;
        }
        i1 = i2 & 0xFF;
        if (i1 > 0) {
            localObject = this.g[(i1 - 1)];
            if (localObject != null) {
                return ((a) localObject).a(n, paramArrayOfInt, paramInt);
            }
        }
        return null;
    }

    public void b() {
        if ((d()) && (this.a != null)) {
            this.a.a(this);
            f();
        }
    }

    public int c() {
        return this.c;
    }

    public boolean d() {
        return !this.k;
    }

    static final class a {
        protected final sc a;
        protected final a b;

        a(sc paramsc, a parama) {
            this.a = paramsc;
            this.b = parama;
        }

        public int a() {
            int i = 1;
            for (a locala = this.b; locala != null; locala = locala.b) {
                i += 1;
            }
            return i;
        }

        public sc a(int paramInt1, int paramInt2, int paramInt3) {
            Object localObject;
            if ((this.a.hashCode() == paramInt1) && (this.a.a(paramInt2, paramInt3))) {
                localObject = this.a;
                return (sc) localObject;
            }
            for (a locala = this.b; ; locala = locala.b) {
                if (locala == null) {
                    break label83;
                }
                sc localsc = locala.a;
                if (localsc.hashCode() == paramInt1) {
                    localObject = localsc;
                    if (localsc.a(paramInt2, paramInt3)) {
                        break;
                    }
                }
            }
            label83:
            return null;
        }

        public sc a(int paramInt1, int[] paramArrayOfInt, int paramInt2) {
            Object localObject;
            if ((this.a.hashCode() == paramInt1) && (this.a.a(paramArrayOfInt, paramInt2))) {
                localObject = this.a;
                return (sc) localObject;
            }
            for (a locala = this.b; ; locala = locala.b) {
                if (locala == null) {
                    break label83;
                }
                sc localsc = locala.a;
                if (localsc.hashCode() == paramInt1) {
                    localObject = localsc;
                    if (localsc.a(paramArrayOfInt, paramInt2)) {
                        break;
                    }
                }
            }
            label83:
            return null;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/sa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */