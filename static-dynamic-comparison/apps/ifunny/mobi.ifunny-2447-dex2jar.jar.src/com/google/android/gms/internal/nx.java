package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

import java.util.List;
import java.util.Map;

class nx
        implements nu {
    private IBinder a;

    nx(IBinder paramIBinder) {
        this.a = paramIBinder;
    }

    public void a() {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try {
            localParcel1.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
            this.a.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
        } finally {
            localParcel2.recycle();
            localParcel1.recycle();
        }
    }

    public void a(Map paramMap, long paramLong, String paramString, List<hb> paramList) {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try {
            localParcel1.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
            localParcel1.writeMap(paramMap);
            localParcel1.writeLong(paramLong);
            localParcel1.writeString(paramString);
            localParcel1.writeTypedList(paramList);
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

    public String b() {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try {
            localParcel1.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
            this.a.transact(3, localParcel1, localParcel2, 0);
            localParcel2.readException();
            String str = localParcel2.readString();
            return str;
        } finally {
            localParcel2.recycle();
            localParcel1.recycle();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/nx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */