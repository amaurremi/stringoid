package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;
import com.google.android.gms.wallet.wobs.c;

public final class OfferWalletObject
        implements SafeParcelable {
    public static final Parcelable.Creator<OfferWalletObject> CREATOR = new n();
    String a;
    String b;
    CommonWalletObject c;
    private final int d;

    OfferWalletObject() {
        this.d = 3;
    }

    OfferWalletObject(int paramInt, String paramString1, String paramString2, CommonWalletObject paramCommonWalletObject) {
        this.d = paramInt;
        this.b = paramString2;
        if (paramInt < 3) {
            this.c = CommonWalletObject.a().a(paramString1).a();
            return;
        }
        this.c = paramCommonWalletObject;
    }

    public int a() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        n.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/OfferWalletObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */