package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

class kh
        implements kf {
    private IBinder a;

    kh(IBinder paramIBinder) {
        this.a = paramIBinder;
    }

    public fk a(fi paramfi) {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (; ; ) {
            try {
                localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                if (paramfi != null) {
                    localParcel1.writeInt(1);
                    paramfi.writeToParcel(localParcel1, 0);
                    this.a.transact(1, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    if (localParcel2.readInt() != 0) {
                        paramfi = fk.CREATOR.a(localParcel2);
                        return paramfi;
                    }
                } else {
                    localParcel1.writeInt(0);
                    continue;
                }
                paramfi = null;
            } finally {
                localParcel2.recycle();
                localParcel1.recycle();
            }
        }
    }

    public IBinder asBinder() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/kh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */