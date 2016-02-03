package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jw
        implements SafeParcelable {
    public static final Parcelable.Creator<jw> CREATOR = new jx();
    String adq;
    String description;
    private final int xH;

    jw() {
        this.xH = 1;
    }

    jw(int paramInt, String paramString1, String paramString2) {
        this.xH = paramInt;
        this.adq = paramString1;
        this.description = paramString2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        jx.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/jw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */