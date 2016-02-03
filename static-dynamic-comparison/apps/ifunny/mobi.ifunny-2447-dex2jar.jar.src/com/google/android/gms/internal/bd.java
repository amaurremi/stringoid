package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.b.a;

public abstract class bd
        extends Binder
        implements bc {
    public bd() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static bc a(IBinder paramIBinder) {
        if (paramIBinder == null) {
            return null;
        }
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        if ((localIInterface != null) && ((localIInterface instanceof bc))) {
            return (bc) localIInterface;
        }
        return new be(paramIBinder);
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
        a locala = null;
        Object localObject2 = null;
        Object localObject1 = null;
        int i = 0;
        boolean bool;
        switch (paramInt1) {
            default:
                return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
            case 1598968902:
                paramParcel2.writeString("com.google.android.gms.ads.internal.client.IAdManager");
                return true;
            case 1:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                locala = c();
                paramParcel2.writeNoException();
                paramParcel1 = (Parcel) localObject1;
                if (locala != null) {
                    paramParcel1 = locala.asBinder();
                }
                paramParcel2.writeStrongBinder(paramParcel1);
                return true;
            case 2:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                d();
                paramParcel2.writeNoException();
                return true;
            case 3:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                bool = e();
                paramParcel2.writeNoException();
                if (bool) {
                }
                for (paramInt1 = 1; ; paramInt1 = 0) {
                    paramParcel2.writeInt(paramInt1);
                    return true;
                }
            case 4:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                localObject1 = locala;
                if (paramParcel1.readInt() != 0) {
                    localObject1 = av.CREATOR.a(paramParcel1);
                }
                bool = a((av) localObject1);
                paramParcel2.writeNoException();
                paramInt1 = i;
                if (bool) {
                    paramInt1 = 1;
                }
                paramParcel2.writeInt(paramInt1);
                return true;
            case 5:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                f();
                paramParcel2.writeNoException();
                return true;
            case 6:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                g();
                paramParcel2.writeNoException();
                return true;
            case 7:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                a(ba.a(paramParcel1.readStrongBinder()));
                paramParcel2.writeNoException();
                return true;
            case 8:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                a(bk.a(paramParcel1.readStrongBinder()));
                paramParcel2.writeNoException();
                return true;
            case 9:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                h();
                paramParcel2.writeNoException();
                return true;
            case 10:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                i();
                paramParcel2.writeNoException();
                return true;
            case 11:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                j();
                paramParcel2.writeNoException();
                return true;
            case 12:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                paramParcel1 = k();
                paramParcel2.writeNoException();
                if (paramParcel1 != null) {
                    paramParcel2.writeInt(1);
                    paramParcel1.writeToParcel(paramParcel2, 1);
                    return true;
                }
                paramParcel2.writeInt(0);
                return true;
            case 13:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                localObject1 = localObject2;
                if (paramParcel1.readInt() != 0) {
                    localObject1 = ay.CREATOR.a(paramParcel1);
                }
                a((ay) localObject1);
                paramParcel2.writeNoException();
                return true;
            case 14:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                a(gx.a(paramParcel1.readStrongBinder()));
                paramParcel2.writeNoException();
                return true;
            case 15:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                a(hj.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
                paramParcel2.writeNoException();
                return true;
            case 16:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                a(hy.a(paramParcel1.readStrongBinder()));
                paramParcel2.writeNoException();
                return true;
            case 17:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                a(ib.a(paramParcel1.readStrongBinder()));
                paramParcel2.writeNoException();
                return true;
        }
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
        paramParcel1 = l();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */