package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class OfferWalletObject
        implements SafeParcelable {
    public static final Parcelable.Creator<OfferWalletObject> CREATOR = new n();
    String acj;
    String eC;
    private final int xH;

    OfferWalletObject() {
        this.xH = 2;
    }

    OfferWalletObject(int paramInt, String paramString1, String paramString2) {
        this.xH = paramInt;
        this.eC = paramString1;
        this.acj = paramString2;
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.eC;
    }

    public String getRedemptionCode() {
        return this.acj;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        n.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/wallet/OfferWalletObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */