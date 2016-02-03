package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;

@ii
public final class jz
        extends jy {
    private final Context a;

    public jz(Context paramContext, fi paramfi, jx paramjx) {
        super(paramfi, paramjx);
        this.a = paramContext;
    }

    public void c() {
    }

    public kf d() {
        Object localObject = lj.m();
        localObject = new bs(((Bundle) localObject).getString("gads:sdk_core_location"), ((Bundle) localObject).getString("gads:sdk_core_experiment_id"), ((Bundle) localObject).getString("gads:block_autoclicks_experiment_id"));
        return kq.a(this.a, (bs) localObject, new de(), new lb());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/jz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */