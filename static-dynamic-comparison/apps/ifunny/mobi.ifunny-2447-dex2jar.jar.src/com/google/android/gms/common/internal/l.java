package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.a;

public final class l
        extends e<T>.g<Boolean> {
    public final int b;
    public final Bundle c;
    public final IBinder d;

    public l(e parame, int paramInt, IBinder paramIBinder, Bundle paramBundle) {
        super(parame, Boolean.valueOf(true));
        this.b = paramInt;
        this.d = paramIBinder;
        this.c = paramBundle;
    }

    protected void a() {
    }

    protected void a(Boolean paramBoolean) {
        if (paramBoolean == null) {
            e.a(this.e, 1);
            return;
        }
        switch (this.b) {
            default:
                if (this.c == null) {
                    break;
                }
        }
        for (paramBoolean = (PendingIntent) this.c.getParcelable("pendingIntent"); ; paramBoolean = null) {
            if (e.d(this.e) != null) {
                p.a(e.e(this.e)).b(this.e.e(), e.d(this.e));
                e.a(this.e, null);
            }
            e.a(this.e, 1);
            e.a(this.e, null);
            e.a(this.e).a(new a(this.b, paramBoolean));
            return;
            try {
                paramBoolean = this.d.getInterfaceDescriptor();
                if (this.e.f().equals(paramBoolean)) {
                    e.a(this.e, this.e.a(this.d));
                    if (e.c(this.e) != null) {
                        e.a(this.e, 3);
                        e.a(this.e).a();
                        return;
                    }
                }
            } catch (RemoteException paramBoolean) {
                p.a(e.e(this.e)).b(this.e.e(), e.d(this.e));
                e.a(this.e, null);
                e.a(this.e, 1);
                e.a(this.e, null);
                e.a(this.e).a(new a(8, null));
                return;
            }
            e.a(this.e, 1);
            throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */