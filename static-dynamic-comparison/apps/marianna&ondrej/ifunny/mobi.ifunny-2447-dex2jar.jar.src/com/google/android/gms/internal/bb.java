package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

class bb
        implements az {
    private IBinder a;

    bb(IBinder paramIBinder) {
        this.a = paramIBinder;
    }

    public void a() {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdListener");
            this.a.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
        } finally {
            localParcel2.recycle();
            localParcel1.recycle();
        }
    }

    public void a(int paramInt) {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdListener");
            localParcel1.writeInt(paramInt);
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

    public void b() {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdListener");
            this.a.transact(3, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
        } finally {
            localParcel2.recycle();
            localParcel1.recycle();
        }
    }

    public void c() {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdListener");
            this.a.transact(4, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
        } finally {
            localParcel2.recycle();
            localParcel1.recycle();
        }
    }

    public void d() {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdListener");
            this.a.transact(5, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
        } finally {
            localParcel2.recycle();
            localParcel1.recycle();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */