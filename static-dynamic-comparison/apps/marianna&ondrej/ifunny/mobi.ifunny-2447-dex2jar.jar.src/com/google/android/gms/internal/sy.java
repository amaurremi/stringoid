package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;
import com.google.android.gms.auth.b;

public abstract class sy
        extends Binder
        implements sx {
    public static sx a(IBinder paramIBinder) {
        if (paramIBinder == null) {
            return null;
        }
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.auth.IAuthManagerService");
        if ((localIInterface != null) && ((localIInterface instanceof sx))) {
            return (sx) localIInterface;
        }
        return new sz(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
        String str1 = null;
        String str2 = null;
        Object localObject = null;
        switch (paramInt1) {
            default:
                return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
            case 1598968902:
                paramParcel2.writeString("com.google.android.auth.IAuthManagerService");
                return true;
            case 1:
                paramParcel1.enforceInterface("com.google.android.auth.IAuthManagerService");
                str1 = paramParcel1.readString();
                str2 = paramParcel1.readString();
                if (paramParcel1.readInt() != 0) {
                    localObject = (Bundle) Bundle.CREATOR.createFromParcel(paramParcel1);
                }
                paramParcel1 = a(str1, str2, (Bundle) localObject);
                paramParcel2.writeNoException();
                if (paramParcel1 != null) {
                    paramParcel2.writeInt(1);
                    paramParcel1.writeToParcel(paramParcel2, 1);
                }
                for (; ; ) {
                    return true;
                    paramParcel2.writeInt(0);
                }
            case 2:
                paramParcel1.enforceInterface("com.google.android.auth.IAuthManagerService");
                str2 = paramParcel1.readString();
                localObject = str1;
                if (paramParcel1.readInt() != 0) {
                    localObject = (Bundle) Bundle.CREATOR.createFromParcel(paramParcel1);
                }
                paramParcel1 = a(str2, (Bundle) localObject);
                paramParcel2.writeNoException();
                if (paramParcel1 != null) {
                    paramParcel2.writeInt(1);
                    paramParcel1.writeToParcel(paramParcel2, 1);
                }
                for (; ; ) {
                    return true;
                    paramParcel2.writeInt(0);
                }
        }
        paramParcel1.enforceInterface("com.google.android.auth.IAuthManagerService");
        localObject = str2;
        if (paramParcel1.readInt() != 0) {
            localObject = AccountChangeEventsRequest.CREATOR.a(paramParcel1);
        }
        paramParcel1 = a((AccountChangeEventsRequest) localObject);
        paramParcel2.writeNoException();
        if (paramParcel1 != null) {
            paramParcel2.writeInt(1);
            paramParcel1.writeToParcel(paramParcel2, 1);
        }
        for (; ; ) {
            return true;
            paramParcel2.writeInt(0);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/sy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */