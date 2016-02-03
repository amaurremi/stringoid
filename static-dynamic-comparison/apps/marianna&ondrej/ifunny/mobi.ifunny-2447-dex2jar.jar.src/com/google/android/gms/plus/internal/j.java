package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;

final class j
        extends a {
    private final com.google.android.gms.common.api.i<Status> b;

    public j(com.google.android.gms.common.api.i<Status> parami) {
        com.google.android.gms.common.api.i locali;
        this.b = locali;
    }

    public void a(int paramInt, Bundle paramBundle) {
        if (paramBundle != null) {
        }
        for (paramBundle = (PendingIntent) paramBundle.getParcelable("pendingIntent"); ; paramBundle = null) {
            paramBundle = new Status(paramInt, null, paramBundle);
            this.a.a(new k(this.a, this.b, paramBundle));
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/plus/internal/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */