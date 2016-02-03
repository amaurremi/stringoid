package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.internal.jb;
import com.google.android.gms.internal.jp;
import com.google.android.gms.internal.pd;
import com.google.android.gms.internal.pm;

public abstract class f
        extends Binder
        implements e {
    public static e a(IBinder paramIBinder) {
        if (paramIBinder == null) {
            return null;
        }
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
        if ((localIInterface != null) && ((localIInterface instanceof e))) {
            return (e) localIInterface;
        }
        return new g(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
        String str = null;
        Object localObject2 = null;
        Object localObject1 = null;
        switch (paramInt1) {
            default:
                return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
            case 1598968902:
                paramParcel2.writeString("com.google.android.gms.plus.internal.IPlusService");
                return true;
            case 1:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a(c.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
                paramParcel2.writeNoException();
                return true;
            case 2:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a(c.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
                paramParcel2.writeNoException();
                return true;
            case 3:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                b(c.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
                paramParcel2.writeNoException();
                return true;
            case 4:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                if (paramParcel1.readInt() != 0) {
                }
                for (paramParcel1 = jp.CREATOR.a(paramParcel1); ; paramParcel1 = null) {
                    a(paramParcel1);
                    paramParcel2.writeNoException();
                    return true;
                }
            case 5:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                paramParcel1 = a();
                paramParcel2.writeNoException();
                paramParcel2.writeString(paramParcel1);
                return true;
            case 6:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                b();
                paramParcel2.writeNoException();
                return true;
            case 8:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a(c.a(paramParcel1.readStrongBinder()));
                paramParcel2.writeNoException();
                return true;
            case 9:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                localObject2 = c.a(paramParcel1.readStrongBinder());
                if (paramParcel1.readInt() != 0) {
                    localObject1 = (Uri) Uri.CREATOR.createFromParcel(paramParcel1);
                    if (paramParcel1.readInt() == 0) {
                        break label474;
                    }
                }
                for (paramParcel1 = (Bundle) Bundle.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null) {
                    a((b) localObject2, (Uri) localObject1, paramParcel1);
                    paramParcel2.writeNoException();
                    return true;
                    localObject1 = null;
                    break;
                }
            case 14:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                localObject2 = c.a(paramParcel1.readStrongBinder());
                paramInt1 = paramParcel1.readInt();
                str = paramParcel1.readString();
                if (paramParcel1.readInt() != 0) {
                }
                for (localObject1 = (Uri) Uri.CREATOR.createFromParcel(paramParcel1); ; localObject1 = null) {
                    a((b) localObject2, paramInt1, str, (Uri) localObject1, paramParcel1.readString(), paramParcel1.readString());
                    paramParcel2.writeNoException();
                    return true;
                }
            case 16:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                localObject2 = a(c.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
                paramParcel2.writeNoException();
                paramParcel1 = (Parcel) localObject1;
                if (localObject2 != null) {
                    paramParcel1 = ((u) localObject2).asBinder();
                }
                paramParcel2.writeStrongBinder(paramParcel1);
                return true;
            case 17:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a(paramParcel1.readString());
                paramParcel2.writeNoException();
                return true;
            case 18:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                c(c.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
                paramParcel2.writeNoException();
                return true;
            case 19:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                b(c.a(paramParcel1.readStrongBinder()));
                paramParcel2.writeNoException();
                return true;
            case 34:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a(c.a(paramParcel1.readStrongBinder()), paramParcel1.createStringArrayList());
                paramParcel2.writeNoException();
                return true;
            case 40:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                d(c.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
                paramParcel2.writeNoException();
                return true;
            case 41:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                paramParcel1 = c();
                paramParcel2.writeNoException();
                paramParcel2.writeString(paramParcel1);
                return true;
            case 42:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                boolean bool = d();
                paramParcel2.writeNoException();
                if (bool) {
                }
                for (paramInt1 = 1; ; paramInt1 = 0) {
                    paramParcel2.writeInt(paramInt1);
                    return true;
                }
            case 43:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                paramParcel1 = e();
                paramParcel2.writeNoException();
                paramParcel2.writeString(paramParcel1);
                return true;
            case 44:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                e(c.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
                paramParcel2.writeNoException();
                return true;
            case 45:
                label474:
                paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                localObject2 = c.a(paramParcel1.readStrongBinder());
                localObject1 = str;
                if (paramParcel1.readInt() != 0) {
                    localObject1 = jp.CREATOR.a(paramParcel1);
                }
                a((b) localObject2, (jp) localObject1);
                paramParcel2.writeNoException();
                return true;
        }
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
        }
        for (localObject1 = jb.CREATOR.a(paramParcel1); ; localObject1 = null) {
            if (paramParcel1.readInt() != 0) {
                localObject2 = jb.CREATOR.a(paramParcel1);
            }
            a(str, (jb) localObject1, (jb) localObject2);
            paramParcel2.writeNoException();
            return true;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/plus/internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */