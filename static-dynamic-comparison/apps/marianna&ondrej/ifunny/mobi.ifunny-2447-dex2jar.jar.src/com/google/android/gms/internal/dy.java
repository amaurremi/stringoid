package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.b.a;
import com.google.android.gms.b.b;

public abstract class dy
        extends Binder
        implements dx {
    public dy() {
        attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    public static dx a(IBinder paramIBinder) {
        if (paramIBinder == null) {
            return null;
        }
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if ((localIInterface != null) && ((localIInterface instanceof dx))) {
            return (dx) localIInterface;
        }
        return new dz(paramIBinder);
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
        Object localObject2 = null;
        Object localObject1 = null;
        a locala;
        switch (paramInt1) {
            default:
                return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
            case 1598968902:
                paramParcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                return true;
            case 1:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                locala = b.a(paramParcel1.readStrongBinder());
                if (paramParcel1.readInt() != 0) {
                    localObject1 = ay.CREATOR.a(paramParcel1);
                    if (paramParcel1.readInt() == 0) {
                        break label194;
                    }
                }
                for (localObject2 = av.CREATOR.a(paramParcel1); ; localObject2 = null) {
                    a(locala, (ay) localObject1, (av) localObject2, paramParcel1.readString(), eb.a(paramParcel1.readStrongBinder()));
                    paramParcel2.writeNoException();
                    return true;
                    localObject1 = null;
                    break;
                }
            case 2:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                localObject2 = a();
                paramParcel2.writeNoException();
                paramParcel1 = (Parcel) localObject1;
                if (localObject2 != null) {
                    paramParcel1 = ((a) localObject2).asBinder();
                }
                paramParcel2.writeStrongBinder(paramParcel1);
                return true;
            case 3:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                locala = b.a(paramParcel1.readStrongBinder());
                localObject1 = localObject2;
                if (paramParcel1.readInt() != 0) {
                    localObject1 = av.CREATOR.a(paramParcel1);
                }
                a(locala, (av) localObject1, paramParcel1.readString(), eb.a(paramParcel1.readStrongBinder()));
                paramParcel2.writeNoException();
                return true;
            case 4:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                b();
                paramParcel2.writeNoException();
                return true;
            case 5:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                c();
                paramParcel2.writeNoException();
                return true;
            case 6:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                locala = b.a(paramParcel1.readStrongBinder());
                if (paramParcel1.readInt() != 0) {
                    localObject1 = ay.CREATOR.a(paramParcel1);
                    if (paramParcel1.readInt() == 0) {
                        break label415;
                    }
                }
                for (localObject2 = av.CREATOR.a(paramParcel1); ; localObject2 = null) {
                    a(locala, (ay) localObject1, (av) localObject2, paramParcel1.readString(), paramParcel1.readString(), eb.a(paramParcel1.readStrongBinder()));
                    paramParcel2.writeNoException();
                    return true;
                    localObject1 = null;
                    break;
                }
            case 7:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                localObject2 = b.a(paramParcel1.readStrongBinder());
                if (paramParcel1.readInt() != 0) {
                }
                for (localObject1 = av.CREATOR.a(paramParcel1); ; localObject1 = null) {
                    a((a) localObject2, (av) localObject1, paramParcel1.readString(), paramParcel1.readString(), eb.a(paramParcel1.readStrongBinder()));
                    paramParcel2.writeNoException();
                    return true;
                }
            case 8:
                label194:
                label415:
                paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                d();
                paramParcel2.writeNoException();
                return true;
        }
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        e();
        paramParcel2.writeNoException();
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/dy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */