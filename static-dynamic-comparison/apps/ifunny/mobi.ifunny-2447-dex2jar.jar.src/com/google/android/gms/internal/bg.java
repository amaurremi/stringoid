package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.b.a;
import com.google.android.gms.b.b;

public abstract class bg
        extends Binder
        implements bf {
    public static bf a(IBinder paramIBinder) {
        if (paramIBinder == null) {
            return null;
        }
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if ((localIInterface != null) && ((localIInterface instanceof bf))) {
            return (bf) localIInterface;
        }
        return new bh(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
        switch (paramInt1) {
            default:
                return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
            case 1598968902:
                paramParcel2.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                return true;
        }
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        a locala = b.a(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0) {
        }
        for (ay localay = ay.CREATOR.a(paramParcel1); ; localay = null) {
            paramParcel1 = a(locala, localay, paramParcel1.readString(), du.a(paramParcel1.readStrongBinder()), paramParcel1.readInt());
            paramParcel2.writeNoException();
            paramParcel2.writeStrongBinder(paramParcel1);
            return true;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */