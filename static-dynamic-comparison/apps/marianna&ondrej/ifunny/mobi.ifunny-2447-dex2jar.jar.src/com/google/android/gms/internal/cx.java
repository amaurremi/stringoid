package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.a;
import com.google.android.gms.common.d;
import com.google.android.gms.common.e;

public final class cx
        implements d, e {
    private final cy a;
    private final cz b;
    private final Object c = new Object();

    public cx(Context paramContext, cy paramcy) {
        this(paramContext, paramcy, false);
    }

    cx(Context paramContext, cy paramcy, boolean paramBoolean) {
        this.a = paramcy;
        this.b = new cz(paramContext, this, this, 6111000);
        if (!paramBoolean) {
            this.b.a();
        }
    }

    public void D_() {
        mx.a("Disconnected from remote ad request service.");
    }

    public void a(Bundle paramBundle) {
        paramBundle = bt.a();
        Object localObject2 = this.c;
        for (; ; ) {
            try {
                Object localObject1 = this.b.n();
                if (localObject1 != null) {
                    localObject1 = ((da) localObject1).a();
                    continue;
                }
            } catch (IllegalStateException localIllegalStateException) {
                localIllegalStateException = localIllegalStateException;
                mx.d("Error when get Gservice values", localIllegalStateException);
                if ((this.b.c()) || (this.b.i())) {
                    this.b.b();
                    continue;
                }
            } catch (RemoteException localRemoteException) {
                mx.d("Error when get Gservice values", localRemoteException);
                if ((this.b.c()) || (this.b.i())) {
                    this.b.b();
                    continue;
                }
            } finally {
                if ((this.b.c()) || (this.b.i())) {
                    this.b.b();
                }
            }
            Bundle localBundle = paramBundle;
        }
    }

    public void a(a parama) {
        this.a.a(bt.a());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */