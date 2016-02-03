package com.google.android.gms.internal;

import com.google.android.gms.common.internal.ad;

public final class oz {
    public final int a;
    public final int b;

    public oz(int paramInt1, int paramInt2) {
        this.a = paramInt1;
        this.b = paramInt2;
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (!(paramObject instanceof oz)) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (this == paramObject);
            paramObject = (oz) paramObject;
            if (((oz) paramObject).a != this.a) {
                break;
            }
            bool1 = bool2;
        } while (((oz) paramObject).b == this.b);
        return false;
    }

    public int hashCode() {
        return ad.a(new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b)});
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/oz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */