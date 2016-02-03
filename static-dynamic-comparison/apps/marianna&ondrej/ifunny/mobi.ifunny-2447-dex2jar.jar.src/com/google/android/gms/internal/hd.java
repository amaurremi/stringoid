package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class hd
        extends Binder
        implements hc {
    public hd() {
        attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
    }

    public static hc a(IBinder paramIBinder) {
        if (paramIBinder == null) {
            return null;
        }
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
        if ((localIInterface != null) && ((localIInterface instanceof hc))) {
            return (hc) localIInterface;
        }
        return new hf(paramIBinder);
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
        int i = 0;
        switch (paramInt1) {
            default:
                return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
            case 1598968902:
                paramParcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
                return true;
            case 1:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
                paramParcel1 = b();
                paramParcel2.writeNoException();
                paramParcel2.writeString(paramParcel1);
                return true;
            case 2:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
                paramParcel1 = c();
                paramParcel2.writeNoException();
                if (paramParcel1 != null) {
                    paramParcel2.writeInt(1);
                    paramParcel1.writeToParcel(paramParcel2, 1);
                    return true;
                }
                paramParcel2.writeInt(0);
                return true;
            case 3:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
                paramInt1 = d();
                paramParcel2.writeNoException();
                paramParcel2.writeInt(paramInt1);
                return true;
            case 4:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
                boolean bool = a();
                paramParcel2.writeNoException();
                paramInt1 = i;
                if (bool) {
                    paramInt1 = 1;
                }
                paramParcel2.writeInt(paramInt1);
                return true;
        }
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
        e();
        paramParcel2.writeNoException();
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/hd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */