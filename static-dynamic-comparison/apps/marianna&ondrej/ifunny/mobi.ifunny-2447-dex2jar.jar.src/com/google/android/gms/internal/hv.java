package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.b.b;

public abstract class hv
        extends Binder
        implements hu {
    public hv() {
        attachInterface(this, "com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
    }

    public static hu a(IBinder paramIBinder) {
        if (paramIBinder == null) {
            return null;
        }
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
        if ((localIInterface != null) && ((localIInterface instanceof hu))) {
            return (hu) localIInterface;
        }
        return new hw(paramIBinder);
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
        switch (paramInt1) {
            default:
                return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
            case 1598968902:
                paramParcel2.writeString("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                return true;
            case 1:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                paramParcel1 = a();
                paramParcel2.writeNoException();
                paramParcel2.writeString(paramParcel1);
                return true;
            case 2:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                paramParcel1 = b();
                paramParcel2.writeNoException();
                paramParcel2.writeString(paramParcel1);
                return true;
            case 3:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                a(b.a(paramParcel1.readStrongBinder()));
                paramParcel2.writeNoException();
                return true;
            case 4:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                c();
                paramParcel2.writeNoException();
                return true;
        }
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
        d();
        paramParcel2.writeNoException();
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/hv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */