package com.google.android.gms.fitness.data;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class l
        extends Binder
        implements k {
    public static k a(IBinder paramIBinder) {
        if (paramIBinder == null) {
            return null;
        }
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.fitness.data.IDataSourceListener");
        if ((localIInterface != null) && ((localIInterface instanceof k))) {
            return (k) localIInterface;
        }
        return new m(paramIBinder);
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
        switch (paramInt1) {
            default:
                return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
            case 1598968902:
                paramParcel2.writeString("com.google.android.gms.fitness.data.IDataSourceListener");
                return true;
        }
        paramParcel1.enforceInterface("com.google.android.gms.fitness.data.IDataSourceListener");
        if (paramParcel1.readInt() != 0) {
        }
        for (paramParcel1 = (DataPoint) DataPoint.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null) {
            a(paramParcel1);
            return true;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */