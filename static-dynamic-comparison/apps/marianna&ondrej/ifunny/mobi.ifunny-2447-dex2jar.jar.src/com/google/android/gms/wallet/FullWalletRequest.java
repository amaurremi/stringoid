package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class FullWalletRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<FullWalletRequest> CREATOR = new g();
    String a;
    String b;
    Cart c;
    private final int d;

    FullWalletRequest() {
        this.d = 1;
    }

    FullWalletRequest(int paramInt, String paramString1, String paramString2, Cart paramCart) {
        this.d = paramInt;
        this.a = paramString1;
        this.b = paramString2;
        this.c = paramCart;
    }

    public int a() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        g.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/FullWalletRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */