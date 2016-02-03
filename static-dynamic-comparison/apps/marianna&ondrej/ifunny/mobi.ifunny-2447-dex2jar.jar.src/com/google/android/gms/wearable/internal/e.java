package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;

public abstract class e
        extends Binder
        implements d {
    public static d a(IBinder paramIBinder) {
        if (paramIBinder == null) {
            return null;
        }
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
        if ((localIInterface != null) && ((localIInterface instanceof d))) {
            return (d) localIInterface;
        }
        return new f(paramIBinder);
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
        Object localObject2 = null;
        Object localObject3 = null;
        Object localObject4 = null;
        Object localObject1 = null;
        switch (paramInt1) {
            default:
                return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
            case 1598968902:
                paramParcel2.writeString("com.google.android.gms.wearable.internal.IWearableListener");
                return true;
            case 1:
                paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                paramParcel2 = (Parcel) localObject1;
                if (paramParcel1.readInt() != 0) {
                    paramParcel2 = DataHolder.CREATOR.a(paramParcel1);
                }
                a(paramParcel2);
                return true;
            case 2:
                paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                paramParcel2 = (Parcel) localObject2;
                if (paramParcel1.readInt() != 0) {
                    paramParcel2 = (ah) ah.CREATOR.createFromParcel(paramParcel1);
                }
                a(paramParcel2);
                return true;
            case 3:
                paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                paramParcel2 = (Parcel) localObject3;
                if (paramParcel1.readInt() != 0) {
                    paramParcel2 = (ak) ak.CREATOR.createFromParcel(paramParcel1);
                }
                a(paramParcel2);
                return true;
        }
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
        paramParcel2 = (Parcel) localObject4;
        if (paramParcel1.readInt() != 0) {
            paramParcel2 = (ak) ak.CREATOR.createFromParcel(paramParcel1);
        }
        b(paramParcel2);
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/internal/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */