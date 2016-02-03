package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.aa;
import com.google.android.gms.common.internal.i;

@ii
public class cz
        extends com.google.android.gms.common.internal.e<da> {
    final int d;

    public cz(Context paramContext, d paramd, com.google.android.gms.common.e parame, int paramInt) {
        super(paramContext, paramd, parame, new String[0]);
        this.d = paramInt;
    }

    protected void a(aa paramaa, i parami) {
        Bundle localBundle = new Bundle();
        paramaa.g(parami, this.d, j().getPackageName(), localBundle);
    }

    protected da c(IBinder paramIBinder) {
        return db.a(paramIBinder);
    }

    protected String e() {
        return "com.google.android.gms.ads.gservice.START";
    }

    protected String f() {
        return "com.google.android.gms.ads.internal.gservice.IGservicesValueService";
    }

    public da n() {
        return (da) super.m();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */