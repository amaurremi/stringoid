package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.m;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.internal.aa;
import com.google.android.gms.internal.ny;
import com.google.android.gms.plus.a.b.a;

public class i
        extends com.google.android.gms.common.internal.e<e> {
    private a d;
    private final h e;

    public i(Context paramContext, Looper paramLooper, m paramm, n paramn, h paramh) {
        super(paramContext, paramLooper, paramm, paramn, paramh.c());
        this.e = paramh;
    }

    protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle) {
        if ((paramInt == 0) && (paramBundle != null) && (paramBundle.containsKey("loaded_person"))) {
            this.d = ny.a(paramBundle.getByteArray("loaded_person"));
        }
        super.a(paramInt, paramIBinder, paramBundle);
    }

    public void a(com.google.android.gms.common.api.i<Status> parami) {
        l();
        p();
        parami = new j(this, parami);
        try {
            ((e) m()).b(parami);
            return;
        } catch (RemoteException localRemoteException) {
            parami.a(8, null);
        }
    }

    protected void a(aa paramaa, com.google.android.gms.common.internal.i parami) {
        Bundle localBundle = this.e.k();
        localBundle.putStringArray("request_visible_actions", this.e.d());
        paramaa.a(parami, 6111000, this.e.g(), this.e.f(), k(), this.e.b(), localBundle);
    }

    protected e c(IBinder paramIBinder) {
        return f.a(paramIBinder);
    }

    protected String e() {
        return "com.google.android.gms.plus.service.START";
    }

    protected String f() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    public String n() {
        l();
        try {
            String str = ((e) m()).a();
            return str;
        } catch (RemoteException localRemoteException) {
            throw new IllegalStateException(localRemoteException);
        }
    }

    public a o() {
        l();
        return this.d;
    }

    public void p() {
        l();
        try {
            this.d = null;
            ((e) m()).b();
            return;
        } catch (RemoteException localRemoteException) {
            throw new IllegalStateException(localRemoteException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/plus/internal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */