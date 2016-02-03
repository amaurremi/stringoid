package com.google.android.gms.internal;

public abstract class so<M extends so<M>>
        extends ss {
    protected sq e;

    public void a(sm paramsm) {
        if (this.e == null) {
        }
        for (; ; ) {
            return;
            int i = 0;
            while (i < this.e.a()) {
                this.e.a(i).a(paramsm);
                i += 1;
            }
        }
    }

    protected final boolean a(M paramM) {
        if ((this.e == null) || (this.e.b())) {
            return (paramM.e == null) || (paramM.e.b());
        }
        return this.e.equals(paramM.e);
    }

    protected int b() {
        int j = 0;
        if (this.e != null) {
            int i = 0;
            for (; ; ) {
                k = i;
                if (j >= this.e.a()) {
                    break;
                }
                i += this.e.a(j).a();
                j += 1;
            }
        }
        int k = 0;
        return k;
    }

    protected final int c() {
        if ((this.e == null) || (this.e.b())) {
            return 0;
        }
        return this.e.hashCode();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/so.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */