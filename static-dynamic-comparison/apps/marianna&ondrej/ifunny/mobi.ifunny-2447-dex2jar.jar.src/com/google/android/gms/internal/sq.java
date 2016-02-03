package com.google.android.gms.internal;

class sq {
    private static final sr a = new sr();
    private boolean b = false;
    private int[] c;
    private sr[] d;
    private int e;

    public sq() {
        this(10);
    }

    public sq(int paramInt) {
        paramInt = b(paramInt);
        this.c = new int[paramInt];
        this.d = new sr[paramInt];
        this.e = 0;
    }

    private boolean a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt) {
        int i = 0;
        while (i < paramInt) {
            if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
                return false;
            }
            i += 1;
        }
        return true;
    }

    private boolean a(sr[] paramArrayOfsr1, sr[] paramArrayOfsr2, int paramInt) {
        int i = 0;
        while (i < paramInt) {
            if (!paramArrayOfsr1[i].equals(paramArrayOfsr2[i])) {
                return false;
            }
            i += 1;
        }
        return true;
    }

    private int b(int paramInt) {
        return c(paramInt * 4) / 4;
    }

    private int c(int paramInt) {
        int i = 4;
        for (; ; ) {
            int j = paramInt;
            if (i < 32) {
                if (paramInt <= (1 << i) - 12) {
                    j = (1 << i) - 12;
                }
            } else {
                return j;
            }
            i += 1;
        }
    }

    private void c() {
        int m = this.e;
        int[] arrayOfInt = this.c;
        sr[] arrayOfsr = this.d;
        int i = 0;
        int k;
        for (int j = 0; i < m; j = k) {
            sr localsr = arrayOfsr[i];
            k = j;
            if (localsr != a) {
                if (i != j) {
                    arrayOfInt[j] = arrayOfInt[i];
                    arrayOfsr[j] = localsr;
                    arrayOfsr[i] = null;
                }
                k = j + 1;
            }
            i += 1;
        }
        this.b = false;
        this.e = j;
    }

    public int a() {
        if (this.b) {
            c();
        }
        return this.e;
    }

    public sr a(int paramInt) {
        if (this.b) {
            c();
        }
        return this.d[paramInt];
    }

    public boolean b() {
        return a() == 0;
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            return true;
            if (!(paramObject instanceof sq)) {
                return false;
            }
            paramObject = (sq) paramObject;
            if (a() != ((sq) paramObject).a()) {
                return false;
            }
        } while ((a(this.c, ((sq) paramObject).c, this.e)) && (a(this.d, ((sq) paramObject).d, this.e)));
        return false;
    }

    public int hashCode() {
        if (this.b) {
            c();
        }
        int j = 17;
        int i = 0;
        while (i < this.e) {
            j = (j * 31 + this.c[i]) * 31 + this.d[i].hashCode();
            i += 1;
        }
        return j;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/sq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */