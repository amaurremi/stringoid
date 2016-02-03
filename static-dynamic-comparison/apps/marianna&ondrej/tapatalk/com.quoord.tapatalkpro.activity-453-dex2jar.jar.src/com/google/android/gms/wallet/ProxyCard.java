package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ProxyCard
        implements SafeParcelable {
    public static final Parcelable.Creator<ProxyCard> CREATOR = new o();
    String ack;
    String acl;
    int acm;
    int acn;
    private final int xH;

    ProxyCard(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3) {
        this.xH = paramInt1;
        this.ack = paramString1;
        this.acl = paramString2;
        this.acm = paramInt2;
        this.acn = paramInt3;
    }

    public int describeContents() {
        return 0;
    }

    public String getCvn() {
        return this.acl;
    }

    public int getExpirationMonth() {
        return this.acm;
    }

    public int getExpirationYear() {
        return this.acn;
    }

    public String getPan() {
        return this.ack;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        o.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/wallet/ProxyCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */