package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.b.a;

public abstract class bz
        extends Binder
        implements by {
    public bz() {
        attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
        a locala2 = null;
        a locala1 = null;
        switch (paramInt1) {
            default:
                return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
            case 1598968902:
                paramParcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                return true;
            case 1:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                a(paramParcel1.readInt());
                paramParcel2.writeNoException();
                return true;
            case 2:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                i();
                paramParcel2.writeNoException();
                return true;
            case 3:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                paramParcel1 = a();
                paramParcel2.writeNoException();
                paramParcel2.writeString(paramParcel1);
                return true;
            case 4:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                locala2 = b();
                paramParcel2.writeNoException();
                paramParcel1 = locala1;
                if (locala2 != null) {
                    paramParcel1 = locala2.asBinder();
                }
                paramParcel2.writeStrongBinder(paramParcel1);
                return true;
            case 5:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                paramParcel1 = c();
                paramParcel2.writeNoException();
                paramParcel2.writeString(paramParcel1);
                return true;
            case 6:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                locala1 = d();
                paramParcel2.writeNoException();
                paramParcel1 = locala2;
                if (locala1 != null) {
                    paramParcel1 = locala1.asBinder();
                }
                paramParcel2.writeStrongBinder(paramParcel1);
                return true;
            case 7:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                paramParcel1 = e();
                paramParcel2.writeNoException();
                paramParcel2.writeString(paramParcel1);
                return true;
            case 8:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                double d = f();
                paramParcel2.writeNoException();
                paramParcel2.writeDouble(d);
                return true;
            case 9:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                paramParcel1 = g();
                paramParcel2.writeNoException();
                paramParcel2.writeString(paramParcel1);
                return true;
        }
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
        paramParcel1 = h();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */