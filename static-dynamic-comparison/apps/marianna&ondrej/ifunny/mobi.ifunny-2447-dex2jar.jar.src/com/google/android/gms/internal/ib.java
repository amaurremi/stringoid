package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class ib
        extends Binder
        implements ia {
    public ib() {
        attachInterface(this, "com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherInterstitialAdListener");
    }

    public static ia a(IBinder paramIBinder) {
        if (paramIBinder == null) {
            return null;
        }
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherInterstitialAdListener");
        if ((localIInterface != null) && ((localIInterface instanceof ia))) {
            return (ia) localIInterface;
        }
        return new ic(paramIBinder);
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
        switch (paramInt1) {
            default:
                return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
            case 1598968902:
                paramParcel2.writeString("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherInterstitialAdListener");
                return true;
            case 1:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherInterstitialAdListener");
                boolean bool = a(paramParcel1.readString(), paramParcel1.readString());
                paramParcel2.writeNoException();
                if (bool) {
                }
                for (paramInt1 = 1; ; paramInt1 = 0) {
                    paramParcel2.writeInt(paramInt1);
                    return true;
                }
        }
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherInterstitialAdListener");
        a(hv.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */