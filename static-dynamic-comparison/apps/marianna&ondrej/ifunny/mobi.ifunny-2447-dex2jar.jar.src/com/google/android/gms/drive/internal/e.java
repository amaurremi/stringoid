package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.sm;
import com.google.android.gms.internal.so;

public final class e
        extends so<e> {
    public int a;
    public String b;
    public long c;
    public long d;

    public e() {
        a();
    }

    public e a() {
        this.a = 1;
        this.b = "";
        this.c = -1L;
        this.d = -1L;
        this.e = null;
        this.f = -1;
        return this;
    }

    public void a(sm paramsm) {
        paramsm.a(1, this.a);
        paramsm.a(2, this.b);
        paramsm.b(3, this.c);
        paramsm.b(4, this.d);
        super.a(paramsm);
    }

    protected int b() {
        return super.b() + sm.b(1, this.a) + sm.b(2, this.b) + sm.c(3, this.c) + sm.c(4, this.d);
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1;
        if (paramObject == this) {
            bool1 = true;
        }
        do {
            do {
                do {
                    return bool1;
                    bool1 = bool2;
                } while (!(paramObject instanceof e));
                paramObject = (e) paramObject;
                bool1 = bool2;
            } while (this.a != ((e) paramObject).a);
            if (this.b != null) {
                break;
            }
            bool1 = bool2;
        } while (((e) paramObject).b != null);
        while (this.b.equals(((e) paramObject).b)) {
            bool1 = bool2;
            if (this.c != ((e) paramObject).c) {
                break;
            }
            bool1 = bool2;
            if (this.d != ((e) paramObject).d) {
                break;
            }
            return a((so) paramObject);
        }
        return false;
    }

    public int hashCode() {
        int j = this.a;
        if (this.b == null) {
        }
        for (int i = 0; ; i = this.b.hashCode()) {
            return (((i + (j + 527) * 31) * 31 + (int) (this.c ^ this.c >>> 32)) * 31 + (int) (this.d ^ this.d >>> 32)) * 31 + c();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */