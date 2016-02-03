package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ju
        implements SafeParcelable {
    public static final Parcelable.Creator<ju> CREATOR = new jv();
    long ado;
    long adp;
    private final int xH;

    ju() {
        this.xH = 1;
    }

    ju(int paramInt, long paramLong1, long paramLong2) {
        this.xH = paramInt;
        this.ado = paramLong1;
        this.adp = paramLong2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        jv.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ju.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */