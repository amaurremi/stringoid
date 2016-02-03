package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class ha
        extends Binder
        implements gz {
    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
        switch (paramInt1) {
            default:
                return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
            case 1598968902:
                paramParcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
                return true;
            case 1:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
                a();
                paramParcel2.writeNoException();
                return true;
            case 2:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
                b();
                paramParcel2.writeNoException();
                return true;
        }
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
        paramInt1 = paramParcel1.readInt();
        paramInt2 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {
        }
        for (paramParcel1 = (Intent) Intent.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null) {
            a(paramInt1, paramInt2, paramParcel1);
            paramParcel2.writeNoException();
            return true;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */