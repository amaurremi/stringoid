package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class fz
        extends Binder
        implements fy {
    public fz() {
        attachInterface(this, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public static fy a(IBinder paramIBinder) {
        if (paramIBinder == null) {
            return null;
        }
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        if ((localIInterface != null) && ((localIInterface instanceof fy))) {
            return (fy) localIInterface;
        }
        return new ga(paramIBinder);
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
        Object localObject2 = null;
        Object localObject1 = null;
        switch (paramInt1) {
            default:
                return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
            case 1598968902:
                paramParcel2.writeString("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                return true;
            case 1:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                if (paramParcel1.readInt() != 0) {
                    localObject1 = (Bundle) Bundle.CREATOR.createFromParcel(paramParcel1);
                }
                a((Bundle) localObject1);
                paramParcel2.writeNoException();
                return true;
            case 2:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                d();
                paramParcel2.writeNoException();
                return true;
            case 3:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                e();
                paramParcel2.writeNoException();
                return true;
            case 4:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                f();
                paramParcel2.writeNoException();
                return true;
            case 5:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                g();
                paramParcel2.writeNoException();
                return true;
            case 6:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                localObject1 = localObject2;
                if (paramParcel1.readInt() != 0) {
                    localObject1 = (Bundle) Bundle.CREATOR.createFromParcel(paramParcel1);
                }
                b((Bundle) localObject1);
                paramParcel2.writeNoException();
                if (localObject1 != null) {
                    paramParcel2.writeInt(1);
                    ((Bundle) localObject1).writeToParcel(paramParcel2, 1);
                }
                for (; ; ) {
                    return true;
                    paramParcel2.writeInt(0);
                }
            case 7:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                h();
                paramParcel2.writeNoException();
                return true;
            case 8:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                i();
                paramParcel2.writeNoException();
                return true;
        }
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        j();
        paramParcel2.writeNoException();
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/fz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */