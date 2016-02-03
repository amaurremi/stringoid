package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

class dw
        implements dt {
    private IBinder a;

    dw(IBinder paramIBinder) {
        this.a = paramIBinder;
    }

    public dx a(String paramString) {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            localParcel1.writeString(paramString);
            this.a.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
            paramString = dy.a(localParcel2.readStrongBinder());
            return paramString;
        } finally {
            localParcel2.recycle();
            localParcel1.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }

    public boolean b(String paramString) {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            localParcel1.writeString(paramString);
            this.a.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
            int i = localParcel2.readInt();
            if (i != 0) {
                bool = true;
            }
            return bool;
        } finally {
            localParcel2.recycle();
            localParcel1.recycle();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/dw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */