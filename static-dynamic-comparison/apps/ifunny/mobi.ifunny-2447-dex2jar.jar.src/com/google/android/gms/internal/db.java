package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class db
        extends Binder
        implements da {
    public static da a(IBinder paramIBinder) {
        if (paramIBinder == null) {
            return null;
        }
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.gservice.IGservicesValueService");
        if ((localIInterface != null) && ((localIInterface instanceof da))) {
            return (da) localIInterface;
        }
        return new dc(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
        switch (paramInt1) {
            default:
                return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
            case 1598968902:
                paramParcel2.writeString("com.google.android.gms.ads.internal.gservice.IGservicesValueService");
                return true;
        }
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.gservice.IGservicesValueService");
        paramParcel1 = a();
        paramParcel2.writeNoException();
        if (paramParcel1 != null) {
            paramParcel2.writeInt(1);
            paramParcel1.writeToParcel(paramParcel2, 1);
            return true;
        }
        paramParcel2.writeInt(0);
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */