package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;
import com.google.android.gms.wearable.a;
import com.google.android.gms.wearable.c;

public final class kc
        extends b
        implements a {
    private final int LE;

    public kc(DataHolder paramDataHolder, int paramInt1, int paramInt2) {
        super(paramDataHolder, paramInt1);
        this.LE = paramInt2;
    }

    public int getType() {
        return getInteger("event_type");
    }

    public c lZ() {
        return new kg(this.BB, this.BD, this.LE);
    }

    public a me() {
        return new kb(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/kc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */