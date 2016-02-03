package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public final class og {
    private final String a;
    private String b;
    private boolean c;
    private int d;
    private boolean e;
    private String f;
    private final List<hk> g;
    private BitSet h;
    private String i;

    public og(String paramString) {
        this.a = paramString;
        this.d = 1;
        this.g = new ArrayList();
    }

    public hq a() {
        int j = 0;
        Object localObject = null;
        if (this.h != null) {
            int[] arrayOfInt = new int[this.h.cardinality()];
            int k = this.h.nextSetBit(0);
            for (; ; ) {
                localObject = arrayOfInt;
                if (k < 0) {
                    break;
                }
                arrayOfInt[j] = k;
                k = this.h.nextSetBit(k + 1);
                j += 1;
            }
        }
        return new hq(this.a, this.b, this.c, this.d, this.e, this.f, (hk[]) this.g.toArray(new hk[this.g.size()]), (int[]) localObject, this.i);
    }

    public og a(String paramString) {
        this.b = paramString;
        return this;
    }

    public og a(boolean paramBoolean) {
        this.c = paramBoolean;
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/og.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */