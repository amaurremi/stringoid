package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;

class w
        implements u {
    private IBinder a;

    w(IBinder paramIBinder) {
        this.a = paramIBinder;
    }

    public void a() {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try {
            localParcel1.writeInterfaceToken("com.google.android.gms.common.internal.ICancelToken");
            this.a.transact(2, localParcel1, localParcel2, 0);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */