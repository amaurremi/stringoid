package com.google.android.gms.common.data;

import android.net.Uri;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.ag;

public abstract class f {
    protected final DataHolder a;
    protected int b;
    private int c;

    public f(DataHolder paramDataHolder, int paramInt) {
        this.a = ((DataHolder) ag.a(paramDataHolder));
        a(paramInt);
    }

    protected void a(int paramInt) {
        if ((paramInt >= 0) && (paramInt < this.a.g())) {
        }
        for (boolean bool = true; ; bool = false) {
            ag.a(bool);
            this.b = paramInt;
            this.c = this.a.a(this.b);
            return;
        }
    }

    public boolean a(String paramString) {
        return this.a.a(paramString);
    }

    protected int b() {
        return this.b;
    }

    protected long b(String paramString) {
        return this.a.a(paramString, this.b, this.c);
    }

    protected int c(String paramString) {
        return this.a.b(paramString, this.b, this.c);
    }

    protected boolean d(String paramString) {
        return this.a.d(paramString, this.b, this.c);
    }

    protected String e(String paramString) {
        return this.a.c(paramString, this.b, this.c);
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if ((paramObject instanceof f)) {
            paramObject = (f) paramObject;
            bool1 = bool2;
            if (ad.a(Integer.valueOf(((f) paramObject).b), Integer.valueOf(this.b))) {
                bool1 = bool2;
                if (ad.a(Integer.valueOf(((f) paramObject).c), Integer.valueOf(this.c))) {
                    bool1 = bool2;
                    if (((f) paramObject).a == this.a) {
                        bool1 = true;
                    }
                }
            }
        }
        return bool1;
    }

    protected float f(String paramString) {
        return this.a.e(paramString, this.b, this.c);
    }

    protected byte[] g(String paramString) {
        return this.a.f(paramString, this.b, this.c);
    }

    protected Uri h(String paramString) {
        return this.a.g(paramString, this.b, this.c);
    }

    public int hashCode() {
        return ad.a(new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.c), this.a});
    }

    protected boolean i(String paramString) {
        return this.a.h(paramString, this.b, this.c);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/data/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */