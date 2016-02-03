package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;

public class al
        extends c {
    private final a.d<Status> wH;

    public al(a.d<Status> paramd) {
        this.wH = paramd;
    }

    public void m(Status paramStatus)
            throws RemoteException {
        this.wH.b(paramStatus);
    }

    public void onSuccess()
            throws RemoteException {
        this.wH.b(Status.Bv);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/internal/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */