package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;

public final class i
        extends y {
    private e a;

    public i(e parame) {
        this.a = parame;
    }

    public void a(int paramInt, IBinder paramIBinder, Bundle paramBundle) {
        ag.a("onPostInitComplete can be called only once per call to getServiceFromBroker", this.a);
        this.a.a(paramInt, paramIBinder, paramBundle);
        this.a = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */