package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;
import com.google.android.gms.auth.c;

class sz
        implements sx {
    private IBinder a;

    sz(IBinder paramIBinder) {
        this.a = paramIBinder;
    }

    public Bundle a(String paramString, Bundle paramBundle) {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (; ; ) {
            try {
                localParcel1.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
                localParcel1.writeString(paramString);
                if (paramBundle != null) {
                    localParcel1.writeInt(1);
                    paramBundle.writeToParcel(localParcel1, 0);
                    this.a.transact(2, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    if (localParcel2.readInt() != 0) {
                        paramString = (Bundle) Bundle.CREATOR.createFromParcel(localParcel2);
                        return paramString;
                    }
                } else {
                    localParcel1.writeInt(0);
                    continue;
                }
                paramString = null;
            } finally {
                localParcel2.recycle();
                localParcel1.recycle();
            }
        }
    }

    public Bundle a(String paramString1, String paramString2, Bundle paramBundle) {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (; ; ) {
            try {
                localParcel1.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
                localParcel1.writeString(paramString1);
                localParcel1.writeString(paramString2);
                if (paramBundle != null) {
                    localParcel1.writeInt(1);
                    paramBundle.writeToParcel(localParcel1, 0);
                    this.a.transact(1, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    if (localParcel2.readInt() != 0) {
                        paramString1 = (Bundle) Bundle.CREATOR.createFromParcel(localParcel2);
                        return paramString1;
                    }
                } else {
                    localParcel1.writeInt(0);
                    continue;
                }
                paramString1 = null;
            } finally {
                localParcel2.recycle();
                localParcel1.recycle();
            }
        }
    }

    public AccountChangeEventsResponse a(AccountChangeEventsRequest paramAccountChangeEventsRequest) {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (; ; ) {
            try {
                localParcel1.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
                if (paramAccountChangeEventsRequest != null) {
                    localParcel1.writeInt(1);
                    paramAccountChangeEventsRequest.writeToParcel(localParcel1, 0);
                    this.a.transact(3, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    if (localParcel2.readInt() != 0) {
                        paramAccountChangeEventsRequest = AccountChangeEventsResponse.CREATOR.a(localParcel2);
                        return paramAccountChangeEventsRequest;
                    }
                } else {
                    localParcel1.writeInt(0);
                    continue;
                }
                paramAccountChangeEventsRequest = null;
            } finally {
                localParcel2.recycle();
                localParcel1.recycle();
            }
        }
    }

    public IBinder asBinder() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/sz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */