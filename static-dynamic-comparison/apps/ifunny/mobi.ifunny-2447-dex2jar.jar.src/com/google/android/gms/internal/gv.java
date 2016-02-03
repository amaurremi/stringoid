package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

class gv
        implements gs {
    private IBinder a;

    gv(IBinder paramIBinder) {
        this.a = paramIBinder;
    }

    public String a() {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
            this.a.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
            String str = localParcel2.readString();
            return str;
        } finally {
            localParcel2.recycle();
            localParcel1.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }

    public void b(int paramInt) {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
            localParcel1.writeInt(paramInt);
            this.a.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
        } finally {
            localParcel2.recycle();
            localParcel1.recycle();
        }
    }

    public void c(int paramInt) {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
            localParcel1.writeInt(paramInt);
            this.a.transact(3, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
        } finally {
            localParcel2.recycle();
            localParcel1.recycle();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/gv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */