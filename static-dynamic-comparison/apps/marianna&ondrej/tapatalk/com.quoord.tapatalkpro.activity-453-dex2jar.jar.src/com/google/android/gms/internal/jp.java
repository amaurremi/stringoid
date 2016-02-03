package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jp
        implements SafeParcelable {
    public static final Parcelable.Creator<jp> CREATOR = new jq();
    int adh;
    String adi;
    double adj;
    String adk;
    long adl;
    int adm;
    private final int xH;

    jp() {
        this.xH = 1;
        this.adm = -1;
        this.adh = -1;
        this.adj = -1.0D;
    }

    jp(int paramInt1, int paramInt2, String paramString1, double paramDouble, String paramString2, long paramLong, int paramInt3) {
        this.xH = paramInt1;
        this.adh = paramInt2;
        this.adi = paramString1;
        this.adj = paramDouble;
        this.adk = paramString2;
        this.adl = paramLong;
        this.adm = paramInt3;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        jq.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/jp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */