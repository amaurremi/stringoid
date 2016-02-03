package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

class bl
        implements bi {
    private IBinder a;

    bl(IBinder paramIBinder) {
        this.a = paramIBinder;
    }

    public void a(String paramString1, String paramString2) {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAppEventListener");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            this.a.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
        } finally {
            localParcel2.recycle();
            localParcel1.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */