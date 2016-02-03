package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class d
        implements SafeParcelable {
    public static final Parcelable.Creator<d> CREATOR = new e();
    LoyaltyWalletObject a;
    OfferWalletObject b;
    private final int c;

    d() {
        this.c = 2;
    }

    d(int paramInt, LoyaltyWalletObject paramLoyaltyWalletObject, OfferWalletObject paramOfferWalletObject) {
        this.c = paramInt;
        this.a = paramLoyaltyWalletObject;
        this.b = paramOfferWalletObject;
    }

    public int a() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        e.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */