package com.google.android.gms.plus.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.u;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.internal.jp;
import com.google.android.gms.internal.ny;
import com.google.android.gms.internal.pm;
import com.google.android.gms.internal.rw;

public abstract class c
        extends Binder
        implements b {
    public c() {
        attachInterface(this, "com.google.android.gms.plus.internal.IPlusCallbacks");
    }

    public static b a(IBinder paramIBinder) {
        if (paramIBinder == null) {
            return null;
        }
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
        if ((localIInterface != null) && ((localIInterface instanceof b))) {
            return (b) localIInterface;
        }
        return new d(paramIBinder);
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
        jp localjp = null;
        Object localObject2 = null;
        Object localObject3 = null;
        Object localObject4 = null;
        Object localObject1 = null;
        switch (paramInt1) {
            default:
                return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
            case 1598968902:
                paramParcel2.writeString("com.google.android.gms.plus.internal.IPlusCallbacks");
                return true;
            case 1:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                paramInt1 = paramParcel1.readInt();
                if (paramParcel1.readInt() != 0) {
                    localObject1 = (Bundle) Bundle.CREATOR.createFromParcel(paramParcel1);
                    if (paramParcel1.readInt() == 0) {
                        break label206;
                    }
                }
                for (paramParcel1 = (Bundle) Bundle.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null) {
                    a(paramInt1, (Bundle) localObject1, paramParcel1);
                    paramParcel2.writeNoException();
                    return true;
                    localObject1 = null;
                    break;
                }
            case 2:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                paramInt1 = paramParcel1.readInt();
                if (paramParcel1.readInt() != 0) {
                    localObject1 = (Bundle) Bundle.CREATOR.createFromParcel(paramParcel1);
                    if (paramParcel1.readInt() == 0) {
                        break label283;
                    }
                }
                for (paramParcel1 = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null) {
                    a(paramInt1, (Bundle) localObject1, paramParcel1);
                    paramParcel2.writeNoException();
                    return true;
                    localObject1 = null;
                    break;
                }
            case 3:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                a(paramParcel1.readString());
                paramParcel2.writeNoException();
                return true;
            case 4:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                if (paramParcel1.readInt() != 0) {
                    localObject1 = DataHolder.CREATOR.a(paramParcel1);
                }
                a((DataHolder) localObject1, paramParcel1.readString());
                paramParcel2.writeNoException();
                return true;
            case 5:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                paramInt1 = paramParcel1.readInt();
                if (paramParcel1.readInt() != 0) {
                }
                for (localObject1 = (Bundle) Bundle.CREATOR.createFromParcel(paramParcel1); ; localObject1 = null) {
                    if (paramParcel1.readInt() != 0) {
                        localjp = jp.CREATOR.a(paramParcel1);
                    }
                    a(paramInt1, (Bundle) localObject1, localjp);
                    paramParcel2.writeNoException();
                    return true;
                }
            case 6:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                localObject1 = localObject2;
                if (paramParcel1.readInt() != 0) {
                    localObject1 = DataHolder.CREATOR.a(paramParcel1);
                }
                a((DataHolder) localObject1, paramParcel1.readString(), paramParcel1.readString());
                paramParcel2.writeNoException();
                return true;
            case 7:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                paramInt1 = paramParcel1.readInt();
                if (paramParcel1.readInt() != 0) {
                }
                for (paramParcel1 = (Bundle) Bundle.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null) {
                    a(paramInt1, paramParcel1);
                    paramParcel2.writeNoException();
                    return true;
                }
            case 8:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                b(paramParcel1.readString());
                paramParcel2.writeNoException();
                return true;
            case 9:
                label206:
                label283:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                paramInt1 = paramParcel1.readInt();
                localObject1 = localObject3;
                if (paramParcel1.readInt() != 0) {
                    localObject1 = ny.CREATOR.a(paramParcel1);
                }
                a(paramInt1, (ny) localObject1);
                paramParcel2.writeNoException();
                return true;
        }
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
        localObject1 = localObject4;
        if (paramParcel1.readInt() != 0) {
            localObject1 = Status.CREATOR.a(paramParcel1);
        }
        a((Status) localObject1);
        paramParcel2.writeNoException();
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/plus/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */