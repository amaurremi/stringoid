package com.google.android.gms.internal;

import java.util.Arrays;

final class su {
    final int a;
    final byte[] b;

    int a() {
        return 0 + sm.f(this.a) + this.b.length;
    }

    void a(sm paramsm) {
        paramsm.e(this.a);
        paramsm.b(this.b);
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            return true;
            if (!(paramObject instanceof su)) {
                return false;
            }
            paramObject = (su) paramObject;
        } while ((this.a == ((su) paramObject).a) && (Arrays.equals(this.b, ((su) paramObject).b)));
        return false;
    }

    public int hashCode() {
        return (this.a + 527) * 31 + Arrays.hashCode(this.b);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/su.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */