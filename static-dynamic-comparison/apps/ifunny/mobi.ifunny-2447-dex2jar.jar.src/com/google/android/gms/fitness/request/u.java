package com.google.android.gms.fitness.request;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.BleDevice;

public abstract class u
        extends Binder
        implements s {
    public static s a(IBinder paramIBinder) {
        if (paramIBinder == null) {
            return null;
        }
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.fitness.request.IBleScanCallback");
        if ((localIInterface != null) && ((localIInterface instanceof s))) {
            return (s) localIInterface;
        }
        return new w(paramIBinder);
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
        switch (paramInt1) {
            default:
                return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
            case 1598968902:
                paramParcel2.writeString("com.google.android.gms.fitness.request.IBleScanCallback");
                return true;
            case 1:
                paramParcel1.enforceInterface("com.google.android.gms.fitness.request.IBleScanCallback");
                if (paramParcel1.readInt() != 0) {
                }
                for (paramParcel1 = (BleDevice) BleDevice.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null) {
                    a(paramParcel1);
                    return true;
                }
        }
        paramParcel1.enforceInterface("com.google.android.gms.fitness.request.IBleScanCallback");
        a();
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */